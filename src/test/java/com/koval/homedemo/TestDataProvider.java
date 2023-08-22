package com.koval.homedemo;

import com.koval.homedemo.payload.dto.CountryDto;
import com.koval.homedemo.payload.response.CityResponse;

import java.util.List;

public class TestDataProvider {

    public static List<CityResponse> getCityResponses() {
        return List.of(
                CityResponse.builder()
                        .id(1L)
                        .name("City1")
                        .country(getCountryDtoOne())
                        .build(),

                CityResponse.builder()
                        .id(1L)
                        .name("City2")
                        .country(getCountryDtoTwo())
                        .build());
    }

    public static CountryDto getCountryDtoOne() {
        return CountryDto.builder()
                .id(1L)
                .name("Country1")
                .build();
    }

    public static CountryDto getCountryDtoTwo() {
        return CountryDto.builder()
                .id(2L)
                .name("Country2")
                .build();
    }
}
