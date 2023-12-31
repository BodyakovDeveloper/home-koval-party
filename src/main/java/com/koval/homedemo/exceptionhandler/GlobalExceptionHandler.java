package com.koval.homedemo.exceptionhandler;

import com.koval.homedemo.exception.CityNotFoundException;
import com.koval.homedemo.exception.CountryNotFoundException;
import com.koval.homedemo.exception.ImageProcessingException;
import com.koval.homedemo.payload.response.ErrorMessageResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Arrays;
import java.util.Date;

import static java.util.Objects.requireNonNull;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(UNPROCESSABLE_ENTITY)
    public ErrorMessageResponse onConstraintValidationException(ConstraintViolationException e) {
        StringBuilder violationMessageBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
            violationMessageBuilder.append(violation.getMessage());
        }
        String description = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getPropertyPath)
                .toList()
                .toString();
        return ErrorMessageResponse.builder()
                .message(violationMessageBuilder.toString())
                .description(description)
                .timestamp(new Date())
                .statusCode(UNPROCESSABLE_ENTITY.value())
                .build();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorMessageResponse handleValidationExceptions(MethodArgumentNotValidException ex) {

        return ErrorMessageResponse
                .builder()
                .timestamp(new Date())
                .message(Arrays.toString(requireNonNull(ex.getDetailMessageArguments())))
                .statusCode(BAD_REQUEST.value())
                .build();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorMessageResponse handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest wr) {

        return ErrorMessageResponse
                .builder()
                .timestamp(new Date())
                .message(ex.getMessage())
                .statusCode(BAD_REQUEST.value())
                .build();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(CityNotFoundException.class)
    public ErrorMessageResponse cityNotFoundExceptionHandler(CityNotFoundException ex, WebRequest request) {

        return ErrorMessageResponse.builder()
                .statusCode(BAD_REQUEST.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .build();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(CountryNotFoundException.class)
    public ErrorMessageResponse countryNotFoundExceptionHandler(CountryNotFoundException ex, WebRequest request) {

        return ErrorMessageResponse.builder()
                .statusCode(BAD_REQUEST.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .build();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ImageProcessingException.class)
    public ErrorMessageResponse imageProcessingExceptionHandler(ImageProcessingException ex, WebRequest request) {

        return ErrorMessageResponse.builder()
                .statusCode(BAD_REQUEST.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorMessageResponse globalExceptionHandler(Exception ex, WebRequest request) {

        return ErrorMessageResponse.builder()
                .statusCode(INTERNAL_SERVER_ERROR.value())
                .timestamp(new Date())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .build();
    }
}
