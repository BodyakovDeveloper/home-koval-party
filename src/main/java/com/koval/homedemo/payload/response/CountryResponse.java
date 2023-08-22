package com.koval.homedemo.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryResponse {

    private Long id;
    private String name;
    private byte[] logo;
}
