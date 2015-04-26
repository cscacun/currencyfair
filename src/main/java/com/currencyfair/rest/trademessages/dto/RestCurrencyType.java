package com.currencyfair.rest.trademessages.dto;

import com.currencyfair.rest.EnumNamesProvider;
import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Created by scacun on 4/25/15.
 */
public enum RestCurrencyType {

    GBP("British Pound"),
    EUR("Euro"),
    USD("US Dollar");

    private static final EnumNamesProvider<RestCurrencyType> ENUMS =
            new EnumNamesProvider<>("Currencies", RestCurrencyType.class);

    private final String name;

    private RestCurrencyType(String name) {
        this.name = name;
    }

    @JsonCreator
    public static RestCurrencyType getCurrency(String currency) {
        return ENUMS.getByName(currency);
    }

    public String getName() {
        return name;
    }

}
