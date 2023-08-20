package com.koval.homedemo.service.impl;

import com.koval.homedemo.exception.CityNotFoundException;
import com.koval.homedemo.mapper.CityMapper;
import com.koval.homedemo.model.City;
import com.koval.homedemo.payload.request.UpdateCityNameRequest;
import com.koval.homedemo.payload.response.CityResponse;
import com.koval.homedemo.repository.CityRepository;
import com.koval.homedemo.service.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Transactional(readOnly = true)
    @Override
    public Page<CityResponse> getPaginatedCitiesWithLogos(Pageable pageable) {
        log.debug("Start getting cities from pageable={}", pageable);

        List<City> cities = cityRepository.findCitiesWithCountry(pageable);
        List<CityResponse> cityResponses = cities.stream()
                .map(cityMapper::toCityResponse)
                .toList();

        return new PageImpl<>(cityResponses, pageable, cities.size());
    }

    @Override
    @Modifying
    @Transactional
    public CityResponse updateName(UpdateCityNameRequest updateCityNameRequest) {
        log.debug("Start updating city with dtp={}", updateCityNameRequest);

        Long cityId = updateCityNameRequest.getId();
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new CityNotFoundException(String.format("City with id %d not found", cityId)));
        city.setName(updateCityNameRequest.getName());

        return cityMapper.toCityResponse(city);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CityResponse> getAllByCountryName(String countryName) {
        log.debug("Start getting cities from countryName={}", countryName);

        List<City> citiesWithCountry = cityRepository.findAllByCountryNameWithCountry(countryName);
        return cityMapper.toCityResponse(citiesWithCountry);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CityResponse> searchCityByName(String nameContaining) {
        log.debug("Start searching cities from nameContaining={}", nameContaining);

        List<City> citiesWithCountry = cityRepository.searchCitiesByNameContainingWithCountry(nameContaining);
        return cityMapper.toCityResponse(citiesWithCountry);
    }
}
