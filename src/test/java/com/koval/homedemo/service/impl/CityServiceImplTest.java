package com.koval.homedemo.service.impl;

import com.koval.homedemo.model.City;
import com.koval.homedemo.payload.request.UpdateCityNameRequest;
import com.koval.homedemo.payload.response.CityResponse;
import com.koval.homedemo.repository.CityRepository;
import com.koval.homedemo.service.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Testcontainers
public class CityServiceImplTest {

    @Autowired
    private CityService cityService;

    @Autowired
    private CityRepository cityRepository;

    @Container
    private static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:15.0-alpine");

    @Test
    @Transactional
    public void testUpdateName() {
        // given
        City city = new City();
        city.setId(1L);
        city.setName("Old City Name");
        cityRepository.save(city);

        UpdateCityNameRequest updateRequest = new UpdateCityNameRequest();
        updateRequest.setId(1L);
        updateRequest.setName("New City Name");

        // proceed
        CityResponse updatedCityResponse = cityService.updateName(updateRequest);

        // assert
        assertEquals("New City Name", updatedCityResponse.getName());

        City updatedCity = cityRepository.findById(1L).orElse(null);
        assertNotNull(updatedCity);
        assertEquals("New City Name", updatedCity.getName());
    }
}
