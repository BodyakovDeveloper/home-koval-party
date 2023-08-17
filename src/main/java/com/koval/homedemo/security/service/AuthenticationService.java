package com.koval.homedemo.security.service;

import com.koval.homedemo.payload.request.SigninRequest;
import com.koval.homedemo.payload.response.JwtAuthenticationResponse;

public interface AuthenticationService {

    JwtAuthenticationResponse signin(SigninRequest request);
}