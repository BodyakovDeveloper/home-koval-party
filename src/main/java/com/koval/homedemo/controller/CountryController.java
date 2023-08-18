package com.koval.homedemo.controller;

import com.koval.homedemo.payload.response.CountryResponse;
import com.koval.homedemo.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'EDITOR')")
    public ResponseEntity<Page<CountryResponse>> getCountries(Pageable pageRequest) {
        Page<CountryResponse> paginatedCountries = countryService.getPaginatedCountries(pageRequest);
        return ResponseEntity.ok(paginatedCountries);
    }

    @PatchMapping
    @PreAuthorize("hasRole('EDITOR')")
    public ResponseEntity<CountryResponse> updateCountry(@RequestParam("countryId") Long countryId,
                                                         @RequestParam("logo") MultipartFile logo) {
        CountryResponse countryResponse = countryService.updateLogo(countryId, logo);
        return ResponseEntity.ok(countryResponse);
    }
}
