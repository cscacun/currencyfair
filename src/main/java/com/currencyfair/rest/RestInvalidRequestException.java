package com.currencyfair.rest;

/**
 * Created by scacun on 4/25/15.
 */
public class RestInvalidRequestException extends RuntimeException {

    public RestInvalidRequestException(String message) {
        super(message);
    }

}
