package com.hm.sys.entity;

import java.util.Date;

public class AccountInfo {
    private Integer id;

    private Date day;

    private Integer manCount;

    private Integer orderCount;

    private Double orderMoney;

    private Double cashCount;

    private Double checkinCount;

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

    public Integer getManCount() {
        return manCount;
    }

    public void setManCount(Integer manCount) {
        this.manCount = manCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Double getCashCount() {
        return cashCount;
    }

    public void setCashCount(Double cashCount) {
        this.cashCount = cashCount;
    }

    public Double getCheckinCount() {
        return checkinCount;
    }

    public void setCheckinCount(Double checkinCount) {
        this.checkinCount = checkinCount;
    }
}