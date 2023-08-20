package com.koval.homedemo.payload.response;

import com.koval.homedemo.payload.dto.Violation;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationErrorResponse {

    private List<Violation> violations = new ArrayList<>();
}