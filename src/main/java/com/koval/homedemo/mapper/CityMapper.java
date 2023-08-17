package com.koval.homedemo.mapper;

import com.koval.homedemo.model.City;
import com.koval.homedemo.payload.response.CityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface CityMapper {

    @Mapping(target = "country", source = "country")
    CityResponse toCityResponse(City city);

    List<CityResponse> toCityResponse(List<City> city);
}
