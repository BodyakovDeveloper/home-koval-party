package com.koval.homedemo.payload.response;

import com.koval.homedemo.payload.dto.CountryDto;
import lombok.Data;

@Data
public class CityResponse {

    private Long id;
    private String name;
    private CountryDto country;
}
