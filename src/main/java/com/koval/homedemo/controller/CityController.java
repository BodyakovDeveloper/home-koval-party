package com.koval.homedemo.controller;

import com.koval.homedemo.payload.request.UpdateCityNameRequest;
import com.koval.homedemo.payload.response.CityResponse;
import com.koval.homedemo.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("cities")
    @PreAuthorize("hasAnyRole('USER', 'EDITOR')")
    public ResponseEntity<Page<CityResponse>> getCities(Pageable pageRequest) {
        Page<CityResponse> paginatedCitiesWithLogos = cityService.getPaginatedCitiesWithLogos(pageRequest);
        return ResponseEntity.ok(paginatedCitiesWithLogos);
    }

    @GetMapping("{countryName}/cities")
    @PreAuthorize("hasAnyRole('USER', 'EDITOR')")
    public ResponseEntity<List<CityResponse>> getCities(@PathVariable("countryName") String countryName) {
        List<CityResponse> allByCountryName = cityService.getAllByCountryName(countryName);
        return ResponseEntity.ok(allByCountryName);
    }

    @GetMapping("cities/search")
    @PreAuthorize("hasAnyRole('USER', 'EDITOR')")
    public ResponseEntity<List<CityResponse>> searchCities(@RequestParam("nameContaining") String nameContaining) {
        List<CityResponse> cityResponses = cityService.searchCityByName(nameContaining);
        return ResponseEntity.ok(cityResponses);
    }

    @PatchMapping("cities")
    @PreAuthorize("hasRole('EDITOR')")
    public ResponseEntity<CityResponse> updateCountry(@RequestBody UpdateCityNameRequest updateCityNameRequest) {
        return ResponseEntity.ok(cityService.updateName(updateCityNameRequest));
    }
}
