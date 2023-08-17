package com.koval.homedemo.payload.dto;

import lombok.Data;

@Data
public class CountryDto {

    private Long id;
    private String name;
    private byte[] logo;
}
