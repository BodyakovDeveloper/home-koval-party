package com.koval.homedemo.controller;

import com.koval.homedemo.payload.response.CountryResponse;
import com.koval.homedemo.service.CountryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountryControllerTest {

    @Mock
    private CountryService countryService;

    @InjectMocks
    private CountryController countryController;

    @Test
    @WithMockUser(roles = {"USER", "EDITOR"})
    void getCountries_AuthorizedUser_ReturnsPageOfCountryResponses() {

        // given
        Pageable pageRequest = PageRequest.of(0, 10);
        List<CountryResponse> mockCountryResponses = new ArrayList<>();
        Page<CountryResponse> expectedPage = new PageImpl<>(mockCountryResponses, pageRequest, 20);

        //when
        when(countryService.getPaginatedCountries(pageRequest)).thenReturn(expectedPage);

        //then
        Page<CountryResponse> resultPage = countryController.getCountries(pageRequest);

        // assert
        assertEquals(expectedPage, resultPage);
        verify(countryService, times(1)).getPaginatedCountries(pageRequest);
    }

    @Test
    @WithMockUser(roles = {"SOME_OTHER_ROLE"})
    void getCountries_UnauthorizedUser_DoesNotWork() {
        // given
        Pageable pageRequest = PageRequest.of(0, 10);

        // assert
        verify(countryService, never()).getPaginatedCountries(pageRequest);
    }
}
