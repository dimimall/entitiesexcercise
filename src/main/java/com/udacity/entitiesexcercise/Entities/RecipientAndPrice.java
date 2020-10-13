package com.udacity.entitiesexcercise.Entities;

import java.math.BigDecimal;

public class RecipientAndPrice {
    private String resipientName;
    private BigDecimal price;

    public RecipientAndPrice(String resipientName, BigDecimal price)
    {
        this.resipientName = resipientName;
        this.price = price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setResipientName(String resipientName) {
        this.resipientName = resipientName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getResipientName() {
        return resipientName;
    }
}
