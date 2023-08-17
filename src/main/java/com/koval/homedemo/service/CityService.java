package com.koval.homedemo.service;

import com.koval.homedemo.payload.request.UpdateCityNameRequest;
import com.koval.homedemo.payload.response.CityResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CityService {

    Page<CityResponse> getPaginatedCitiesWithLogos(Pageable pageable);

    CityResponse updateName(UpdateCityNameRequest updateCityNameRequest);

    List<CityResponse> getAllByCountryName(String countryName);

    List<CityResponse> searchCityByName(String nameContaining);
}
