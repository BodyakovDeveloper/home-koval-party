package com.koval.homedemo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.koval.homedemo.TestDataProvider;
import com.koval.homedemo.model.City;
import com.koval.homedemo.payload.request.UpdateCityNameRequest;
import com.koval.homedemo.payload.response.CityResponse;
import com.koval.homedemo.repository.CityRepository;
import com.koval.homedemo.service.CityService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Testcontainers
public class CityControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private CityService cityService;

    @Autowired
    private CityRepository cityRepository;

    @Container
    private static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:15.0-alpine");

    @DynamicPropertySource
    public static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

    @Test
    @WithMockUser(roles = {"USER", "EDITOR"})
    @Transactional
    public void testUpdateCityName() throws Exception {
        // Given
        City city = new City();
        city.setId(1L);
        city.setName("Old City Name");
        cityRepository.save(city);

        UpdateCityNameRequest updateRequest = new UpdateCityNameRequest();
        updateRequest.setId(1L);
        updateRequest.setName("New City Name");

        // When
        mockMvc.perform(patch("/api/v1/cities")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isOk());

        // Then
        City updatedCity = cityRepository.findById(city.getId()).orElse(null);
        assertNotNull(updatedCity);
        assertEquals("New City Name", updatedCity.getName());
    }


    @Test
    public void testGetCities() throws Exception {
        Pageable pageable = PageRequest.of(0, 10);
        List<CityResponse> cityResponses = TestDataProvider.getCityResponses();

        Page<CityResponse> page = new PageImpl<>(cityResponses, pageable, cityResponses.size());

        given(cityService.getPaginatedCitiesWithLogos(pageable)).willReturn(page);

        mockMvc.perform(get("/api/v1/cities"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(cityResponses.size())))
                .andExpect(jsonPath("$.content[0].name").value(cityResponses.get(0).getName()));

        verify(cityService, times(1)).getPaginatedCitiesWithLogos(pageable);
    }

    @Test
    public void testGetCitiesByCountry() throws Exception {
        String countryName = "TestCountry";
        List<CityResponse> cityResponses = TestDataProvider.getCityResponses();

        given(cityService.getAllByCountryName(countryName)).willReturn(cityResponses);

        mockMvc.perform(get("/api/v1/{countryName}/cities", countryName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(cityResponses.size())))
                .andExpect(jsonPath("$[0].name").value(cityResponses.get(0).getName()));

        verify(cityService, times(1)).getAllByCountryName(countryName);
    }

    @Test
    public void testSearchCities() throws Exception {
        String cityName = "TestCity";
        List<CityResponse> cityResponses = TestDataProvider.getCityResponses();

        given(cityService.searchCityByName(cityName)).willReturn(cityResponses);

        mockMvc.perform(get("/api/v1/cities/search")
                        .param("nameContaining", cityName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(cityResponses.size())))
                .andExpect(jsonPath("$[0].name").value(cityResponses.get(0).getName()));

        verify(cityService, times(1)).searchCityByName(cityName);
    }
}
