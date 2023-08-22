package com.koval.homedemo.service.impl;

import com.koval.homedemo.TestDataProvider;
import com.koval.homedemo.payload.response.CityResponse;
import com.koval.homedemo.service.CityService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CityService cityService;

    @Test
    @WithMockUser(roles = {"USER", "EDITOR"})
    public void testGetCities() throws Exception {
        List<CityResponse> cityResponses = TestDataProvider.getCityResponses();

        Page<CityResponse> cityResponsePage = new PageImpl<>(cityResponses);
        when(cityService.getPaginatedCitiesWithLogos(any(Pageable.class))).thenReturn(cityResponsePage);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cities")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser(roles = {"USER", "EDITOR"})
    public void testGetCitiesByCountry() throws Exception {
        String countryName = "CountryName";
        List<CityResponse> cityResponses = TestDataProvider.getCityResponses();

        when(cityService.getAllByCountryName(countryName)).thenReturn(cityResponses);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/{countryName}/cities", countryName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser(roles = {"USER", "EDITOR"})
    public void testSearchCities() throws Exception {
        String nameContaining = "CityName";
        List<CityResponse> cityResponses = TestDataProvider.getCityResponses();

        when(cityService.searchCityByName(nameContaining)).thenReturn(cityResponses);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/cities/search")
                        .param("nameContaining", nameContaining)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
