package com.currencyfair.rest;

import com.currencyfair.rest.RestInvalidRequestException;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by scacun on 4/26/15.
 */
public class EnumNamesProvider<E extends Enum<E>> {

    private final String enumName;
    private final ImmutableMap<String, E> enumNameValues;
    private final String validValueNames;

    public EnumNamesProvider(String enumName, Class<E> enumClass) {
        this.enumName = enumName;
        StringBuilder validValueNamesProvider = new StringBuilder("(Valid values: |");
        ImmutableMap.Builder<String, E> enumValuesBuilder = ImmutableMap.builder();
        for (E value : enumClass.getEnumConstants()) {
            enumValuesBuilder.put(value.toString(), value);
            validValueNamesProvider.append(value);
            validValueNamesProvider.append("|");
        }
        validValueNamesProvider.append(")");
        validValueNames = validValueNamesProvider.toString();
        enumNameValues = enumValuesBuilder.build();
    }

    public E getByName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new RestInvalidRequestException(enumName + " value name is empty. " + validValueNames);
        }
        E enumValue = enumNameValues.get(StringUtils.trim(name));
        if (enumValue == null) {
            throw new RestInvalidRequestException(
                    enumName + " value name is invalid: '" + name + "'. " + validValueNames);
        }
        return enumValue;
    }

}
