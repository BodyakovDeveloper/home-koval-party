package com.koval.homedemo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.koval.homedemo.model.City;
import com.koval.homedemo.payload.request.UpdateCityNameRequest;
import com.koval.homedemo.repository.CityRepository;
import com.koval.homedemo.security.service.impl.JwtServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.security.Key;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Testcontainers
public class CityControllerIntegrationTest {

    @Value("${token.signing.key}")
    private String jwtSigningKey;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtServiceImpl jwtService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CityRepository cityRepository;

    @Container
    private static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:15.0-alpine");

    @DynamicPropertySource
    public static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

    @Test
    @Transactional
    public void testUpdateCityName() throws Exception {
        // Given
        String token = generateToken();
        City city = new City();
        city.setId(1L);
        city.setName("Old City Name");
        cityRepository.save(city);

        UpdateCityNameRequest updateRequest = new UpdateCityNameRequest();
        updateRequest.setId(1L);
        updateRequest.setName("New City Name");

        // When
        mockMvc.perform(patch("/api/v1/cities")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isOk());

        // Then
        City updatedCity = cityRepository.findById(city.getId()).orElse(null);
        assertNotNull(updatedCity);
        assertEquals("New City Name", updatedCity.getName());
    }

    private String generateToken() {

        return Jwts.builder()
                .setSubject("editor")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
