package com.hm.sys.entity;

public class OrderStat {
    private Integer id;

    private String orderStat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderStat() {
        return orderStat;
    }

    public void setOrderStat(String orderStat) {
        this.orderStat = orderStat == null ? null : orderStat.trim();
    }
}