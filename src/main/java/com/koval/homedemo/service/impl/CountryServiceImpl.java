package com.koval.homedemo.service.impl;

import com.koval.homedemo.exception.CountryNotFoundException;
import com.koval.homedemo.exception.ImageProcessingException;
import com.koval.homedemo.mapper.CountryMapper;
import com.koval.homedemo.model.Country;
import com.koval.homedemo.payload.response.CountryResponse;
import com.koval.homedemo.repository.CountryRepository;
import com.koval.homedemo.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    @Modifying
    @Transactional
    public CountryResponse updateLogo(Long countryId, MultipartFile logo) {
        log.debug("Start updating logo service with countryId={} and logo={}", countryId, logo);

        Country country = countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFoundException(
                        String.format("Country with id: %d not found", countryId)));

        byte[] imageInBytes;
        try {
            imageInBytes = logo.getBytes();
        } catch (IOException e) {
            log.error("Error processing image", e);
            throw new ImageProcessingException("Error processing image bytes", e);
        }
        country.setLogo(imageInBytes);

        return countryMapper.toCountryResponse(country);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<CountryResponse> getPaginatedCountries(Pageable pageRequest) {
        return countryRepository.findAll(pageRequest)
                .map(countryMapper::toCountryResponse);
    }
}
