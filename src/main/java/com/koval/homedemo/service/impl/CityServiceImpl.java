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
        return cityRepository.findAll(pageable).map(cityMapper::toCityResponse);
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
    public List<CityResponse> getAllByCountryName(String countryName) {
        List<City> allByCountryName = cityRepository.findAllByCountryName(countryName);
        return cityMapper.toCityResponse(allByCountryName);
    }

    @Override
    public List<CityResponse> searchCityByName(String nameContaining) {
        List<City> cities = cityRepository.searchCitiesByNameContaining(nameContaining);
        return cityMapper.toCityResponse(cities);
    }
}
