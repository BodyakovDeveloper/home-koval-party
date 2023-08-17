package com.koval.homedemo.exceptionhandler;

import com.koval.homedemo.exception.CityNotFoundException;
import com.koval.homedemo.exception.CountryNotFoundException;
import com.koval.homedemo.exception.ImageProcessingException;
import com.koval.homedemo.payload.response.ErrorMessageResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorMessageResponse handleConstraintViolationException(ConstraintViolationException ex, WebRequest wr) {

        return ErrorMessageResponse
                .builder()
                .message(ex.getMessage())
                .statusCode(BAD_REQUEST.value())
                .description(ex.getConstraintViolations().toString())
                .build();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorMessageResponse handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest wr) {

        return ErrorMessageResponse
                .builder()
                .message(ex.getMessage())
                .statusCode(BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(CityNotFoundException.class)
    public ErrorMessageResponse cityNotFoundExceptionHandler(CityNotFoundException ex, WebRequest request) {

        return ErrorMessageResponse.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .build();
    }

    @ExceptionHandler(CountryNotFoundException.class)
    public ErrorMessageResponse countryNotFoundExceptionHandler(CountryNotFoundException ex, WebRequest request) {

        return ErrorMessageResponse.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .build();
    }

    @ExceptionHandler(ImageProcessingException.class)
    public ErrorMessageResponse imageProcessingExceptionHandler(ImageProcessingException ex, WebRequest request) {

        return ErrorMessageResponse.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessageResponse globalExceptionHandler(Exception ex, WebRequest request) {

        return ErrorMessageResponse.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .build();
    }
}
