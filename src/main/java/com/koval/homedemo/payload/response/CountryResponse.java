package com.koval.homedemo.payload.response;

import lombok.Data;

@Data
public class CountryResponse {

    private Long id;
    private String name;
    private byte[] logo;
}
