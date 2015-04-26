package com.currencyfair.rest;

/**
 * Created by scacun on 4/26/15.
 */
public class RestErrorBody {

    private final int status;
    private final String message;

    public RestErrorBody(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
