package com.koval.homedemo.controller;

import com.koval.homedemo.payload.request.UpdateCityNameRequest;
import com.koval.homedemo.payload.response.CityResponse;
import com.koval.homedemo.service.CityService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@SecurityRequirement(name = "bearerAuth")
public class CityController {

    private final CityService cityService;

    @GetMapping("cities")
    @PreAuthorize("hasAnyRole('USER', 'EDITOR')")
    public Page<CityResponse> getCities(Pageable pageRequest) {
        return cityService.getPaginatedCitiesWithLogos(pageRequest);
    }

    @GetMapping("{countryName}/cities")
    @PreAuthorize("hasAnyRole('USER', 'EDITOR')")
    public List<CityResponse> getCities(@PathVariable("countryName") String countryName) {
        return cityService.getAllByCountryName(countryName);
    }

    @GetMapping("cities/search")
    @PreAuthorize("hasAnyRole('USER', 'EDITOR')")
    public List<CityResponse> searchCities(@RequestParam("nameContaining") String nameContaining) {
        return cityService.searchCityByName(nameContaining);
    }

    @PatchMapping("cities")
    @PreAuthorize("hasRole('EDITOR')")
    public ResponseEntity<CityResponse> updateCountry(@RequestBody UpdateCityNameRequest updateCityNameRequest) {
        return ResponseEntity.ok(cityService.updateName(updateCityNameRequest));
    }
}
