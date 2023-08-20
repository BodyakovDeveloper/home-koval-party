package com.koval.homedemo.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Bohdan Koval",
                        email = "bodyakov2002@gmail.com",
                        url = "https://www.linkedin.com/in/bohdan-koval-23917b21a/"
                ),
                title = "Home Koval",
                description = "OpenApi documentation for \"Home Koval\" project",
                version = "1.0"
        ),
        servers = @Server(
                description = "Local server",
                url = "http://localhost:8080"
        )
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT authentication",
        scheme = "bearer",
        bearerFormat = "JWT",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
