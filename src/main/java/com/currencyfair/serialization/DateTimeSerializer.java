package com.currencyfair.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by scacun on 4/26/15.
 */
public class DateTimeSerializer extends StdSerializer<DateTime> {

  private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("dd-MMM-yy HH:mm:ss");


  public DateTimeSerializer() {
    super(DateTime.class);
  }

  @Override
  public void serialize(DateTime value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
    if (value == null) {
      return;
    }
    jsonGenerator.writeString(FORMATTER.print(value));
  }
}
