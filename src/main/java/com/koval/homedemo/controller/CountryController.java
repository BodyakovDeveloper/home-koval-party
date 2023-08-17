package com.koval.homedemo.controller;

import com.koval.homedemo.payload.response.CountryResponse;
import com.koval.homedemo.service.CountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Validated
@RequestMapping("api/v1/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'EDITOR')")
    public Page<CountryResponse> getCountries(Pageable pageRequest) {
        return countryService.getPaginatedCountries(pageRequest);
    }

    @PatchMapping
    @PreAuthorize("hasRole('EDITOR')")
    public CountryResponse updateCountry(@RequestParam("countryId") Long countryId,
                                         @Valid @RequestParam("logo") MultipartFile logo) {
        return countryService.updateLogo(countryId, logo);
    }
}
