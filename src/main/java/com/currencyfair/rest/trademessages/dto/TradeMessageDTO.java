package com.currencyfair.rest.trademessages.dto;

import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;

/**
 * Created by scacun on 4/25/15.
 */
public class TradeMessageDTO {

  private static final long MIN_AMOUNT = 0;
  private static final long MIN_RATE = 0;

  @NotBlank
  private String userId;

  @NotNull
  private RestCurrencyType currencyFrom;

  @NotNull
  private RestCurrencyType currencyTo;

  @Min(MIN_AMOUNT)
  @NotNull
  private BigDecimal amountSell;

  @Min(MIN_AMOUNT)
  @NotNull
  private BigDecimal amountBuy;

  @Min(MIN_RATE)
  @NotNull
  private BigDecimal rate;

  @NotNull
  private DateTime timePlaced;

  @NotNull
  private RestCountry originatingCountry;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public RestCurrencyType getCurrencyFrom() {
    return currencyFrom;
  }

  public void setCurrencyFrom(RestCurrencyType currencyFrom) {
    this.currencyFrom = currencyFrom;
  }

  public RestCurrencyType getCurrencyTo() {
    return currencyTo;
  }

  public void setCurrencyTo(RestCurrencyType currencyTo) {
    this.currencyTo = currencyTo;
  }

  public BigDecimal getAmountSell() {
    return amountSell;
  }

  public void setAmountSell(BigDecimal amountSell) {
    this.amountSell = amountSell;
  }

  public BigDecimal getAmountBuy() {
    return amountBuy;
  }

  public void setAmountBuy(BigDecimal amountBuy) {
    this.amountBuy = amountBuy;
  }

  public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  public DateTime getTimePlaced() {
    return timePlaced;
  }

  public void setTimePlaced(DateTime timePlaced) {
    this.timePlaced = timePlaced;
  }

  public RestCountry getOriginatingCountry() {
    return originatingCountry;
  }

  public void setOriginatingCountry(RestCountry originatingCountry) {
    this.originatingCountry = originatingCountry;
  }

}
