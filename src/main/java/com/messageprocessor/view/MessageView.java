package com.messageprocessor.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.messageprocessor.models.Message;
import com.messageprocessor.util.DateUtil;

/**
 * @implNote : View POJO for Message
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageView {

    private Double buyAmount;
    private Double sellAmount;
    private String currencyFrom;
    private String currencyTo;
    private String date;
    private Double rate;

    public MessageView(Message message) {
        this.buyAmount = message.getAmountBuy();
        this.sellAmount = message.getAmountSell();
        this.currencyFrom = message.getCurrencyFrom();
        this.currencyTo = message.getCurrencyTo();
        this.date = DateUtil.formatStringToCharts(message.getTimePlaced());
        this.rate = message.getRate();
    }

    public Double getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(Double buyAmount) {
        this.buyAmount = buyAmount;
    }

    public Double getSellAmount() {
        return sellAmount;
    }

    public void setSellAmount(Double sellAmount) {
        this.sellAmount = sellAmount;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
