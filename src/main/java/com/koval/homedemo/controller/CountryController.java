package com.koval.homedemo.controller;

import com.koval.homedemo.annotation.ValidLogo;
import com.koval.homedemo.payload.response.CountryResponse;
import com.koval.homedemo.service.CountryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/countries")
@SecurityRequirement(name = "bearerAuth")
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'EDITOR')")
    public Page<CountryResponse> getCountries(Pageable pageRequest) {
        log.debug("CountryController getCountries starts with pageRequest={}", pageRequest);

        Page<CountryResponse> countries = countryService.getPaginatedCountries(pageRequest);

        log.debug("CountryController getCountries ends, returning countries={}", countries);
        return countries;
    }

    @PatchMapping(consumes = {"multipart/form-data"})
    @PreAuthorize("hasRole('EDITOR')")
    public ResponseEntity<CountryResponse> updateCountry(@RequestParam("countryId") Long countryId,
                                                         @ValidLogo @RequestParam("logo") MultipartFile logo) {
        log.debug("CountryController updateCountry starts with countryId={} and logo={}", countryId, logo.getOriginalFilename());

        CountryResponse countryResponse = countryService.updateLogo(countryId, logo);

        log.debug("CountryController updateCountry ends, returning countryResponse={}", countryResponse);
        return ResponseEntity.ok(countryResponse);
    }
}
