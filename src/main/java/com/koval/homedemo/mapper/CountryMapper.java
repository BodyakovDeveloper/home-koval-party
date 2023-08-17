package com.koval.homedemo.mapper;

import com.koval.homedemo.model.Country;
import com.koval.homedemo.payload.response.CountryResponse;
import org.mapstruct.Mapper;

@Mapper
public interface CountryMapper {

    CountryResponse toCountryResponse(Country country);
}
