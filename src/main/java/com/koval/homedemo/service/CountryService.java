package com.koval.homedemo.service;

import com.koval.homedemo.payload.response.CountryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface CountryService {

    CountryResponse updateLogo(Long countryId, MultipartFile logo);

    Page<CountryResponse> getPaginatedCountries(Pageable pageRequest);
}
