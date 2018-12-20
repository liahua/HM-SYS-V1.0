package com.hm.sys.entity;

import java.util.Date;

public class CheckInfo {
    private Integer id;

    private Integer stayId;

    private Float dueMoney;

    private Float orderMoney;

    private Float discountRate;

    private Float discountPrice;

    private Float paidUpMoney;

    private Date checkDate;

    private Integer status;

    private String operator;

    private Date createdtime;

    private Date modifiedtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStayId() {
        return stayId;
    }

    public void setStayId(Integer stayId) {
        this.stayId = stayId;
    }

    public Float getDueMoney() {
        return dueMoney;
    }

    public void setDueMoney(Float dueMoney) {
        this.dueMoney = dueMoney;
    }

    public Float getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Float orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Float getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Float discountRate) {
        this.discountRate = discountRate;
    }

    public Float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Float discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Float getPaidUpMoney() {
        return paidUpMoney;
    }

    public void setPaidUpMoney(Float paidUpMoney) {
        this.paidUpMoney = paidUpMoney;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }
}