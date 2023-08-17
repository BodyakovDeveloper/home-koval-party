package com.koval.homedemo.payload.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CountryChangeLogoRequest {

    private Long id;
    private MultipartFile image;
}
