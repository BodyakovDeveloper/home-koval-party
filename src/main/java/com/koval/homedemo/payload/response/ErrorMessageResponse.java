package com.koval.homedemo.payload.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ErrorMessageResponse {

    private Integer statusCode;
    private Date timestamp;
    private String message;
    private String description;
}