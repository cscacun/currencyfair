package com.currencyfair.serialization;

import com.currencyfair.rest.RestInvalidRequestException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

/**
 * Created by scacun on 4/25/15.
 */
public class DateTimeDeserializer extends JsonDeserializer<DateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("dd-MMM-yy HH:mm:ss");

    @Override
    public DateTime deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        try {
            return FORMATTER.parseDateTime(jsonParser.getText());
        } catch (IllegalArgumentException e) {
            throw new RestInvalidRequestException("invalid date format");
        }
    }

}
