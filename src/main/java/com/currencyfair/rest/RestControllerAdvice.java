package com.currencyfair.rest;

import com.currencyfair.RestInvalidRequestException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.stream.Collectors;

/**
 * Created by scacun on 4/26/15.
 */
@ControllerAdvice
class RestControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public RestErrorBody handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        if (e.getCause() != null && e.getCause() instanceof JsonMappingException) {
            JsonMappingException jsonMappingException = (JsonMappingException) e.getCause();
            if (jsonMappingException.getCause() != null &&
                    jsonMappingException.getCause() instanceof RestInvalidRequestException) {
                RestInvalidRequestException restInvalidRequestException =
                        (RestInvalidRequestException) jsonMappingException.getCause();
                return new RestErrorBody(HttpStatus.BAD_REQUEST.value(), restInvalidRequestException.getMessage());
            }
        }

        return new RestErrorBody(HttpStatus.BAD_REQUEST.value(), "unreadable json");
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestErrorBody handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return createBadRequestResponse(e.getBindingResult());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RestInvalidRequestException.class)
    public RestErrorBody handleRestInvalidRequestException(RestInvalidRequestException e) {
        return new RestErrorBody(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public RestErrorBody handleBindException(BindException e) {
        return createBadRequestResponse(e.getBindingResult());
    }

    private RestErrorBody createBadRequestResponse(BindingResult bindingResult) {
        String message = bindingResult.getAllErrors().stream()
                .filter(error -> error instanceof FieldError)
                .map(error -> (FieldError) error)
                .map(error -> " field - [" + error.getField() + "] - " + error.getDefaultMessage())
                .collect(Collectors.joining(";"));
        return new RestErrorBody(HttpStatus.BAD_REQUEST.value(), message);
    }

}