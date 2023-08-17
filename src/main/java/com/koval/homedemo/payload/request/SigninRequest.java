package com.koval.homedemo.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.koval.homedemo.util.RegexConstant.PASSWORD_REGEX;
import static com.koval.homedemo.util.RegexConstant.USERNAME_REGEX;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SigninRequest {

    @NotBlank
    @Pattern(regexp = USERNAME_REGEX, message = "Incorrect username")
    private String username;

    @NotBlank
    @Pattern(regexp = PASSWORD_REGEX, message = "Incorrect password")
    private String password;
}