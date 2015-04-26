package com.currencyfair.rest.dto;

import com.currencyfair.EnumNamesProvider;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Created by scacun on 4/25/15.
 */
public enum  RestCountry {

    FR("France"),
    UK("United Kingdom"),
    IE("Ireland"),
    US("USA");

    private static final EnumNamesProvider<RestCountry> ENUMS = new EnumNamesProvider<>("Countries", RestCountry.class);

    private final String name;

    private RestCountry(String name) {
        this.name = name;
    }

    @JsonCreator
    public static RestCountry getCountry(String country) {
        return ENUMS.getByName(country);
    }

    public String getName() {
        return name;
    }

}
