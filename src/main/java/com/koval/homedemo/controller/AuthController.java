package com.koval.homedemo.controller;

import com.koval.homedemo.payload.request.SigninRequest;
import com.koval.homedemo.payload.response.JwtAuthenticationResponse;
import com.koval.homedemo.security.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@Valid @RequestBody SigninRequest request) {
        log.debug("AuthController starts proceed signin with request={}", request);
        JwtAuthenticationResponse signin = authenticationService.signin(request);
        log.debug("AuthController ends, returning responseEntity={}", signin);
        return ResponseEntity.ok(signin);
    }
}
