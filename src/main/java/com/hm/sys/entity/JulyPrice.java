package com.hm.sys.entity;

import java.util.Date;

public class JulyPrice {
    private Integer id;

    private Date day;

    private Integer priceStd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getPriceStd() {
        return priceStd;
    }

    public void setPriceStd(Integer priceStd) {
        this.priceStd = priceStd;
    }
}