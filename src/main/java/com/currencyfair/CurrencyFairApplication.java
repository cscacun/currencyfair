package com.currencyfair;

import com.currencyfair.serialization.DateTimeDeserializer;
import com.currencyfair.serialization.DateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by scacun on 4/25/15.
 */
@SpringBootApplication
public class CurrencyFairApplication extends WebMvcConfigurerAdapter {

  public static void main(String[] args) {
    new SpringApplicationBuilder(CurrencyFairApplication.class)
        .showBanner(false)
        .run(args);
  }

  @Autowired
  public void configureConverter(MappingJackson2HttpMessageConverter messageConverter) {
    messageConverter.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    messageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    messageConverter.getObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
    messageConverter.getObjectMapper().registerModule(getJsonDateTimeModule());
  }

  @Bean
  public DispatcherServlet dispatcherServlet() {
    DispatcherServlet dispatcherServlet = new DispatcherServlet();
    dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
    return dispatcherServlet;
  }

  private Module getJsonDateTimeModule() {
    SimpleModule jsonModule = new SimpleModule("JsonDateTimeModule");
    jsonModule.addDeserializer(DateTime.class, new DateTimeDeserializer());
    jsonModule.addSerializer(DateTime.class, new DateTimeSerializer());
    return jsonModule;
  }

}
