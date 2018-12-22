package com.hm.sys.entity;

import java.util.Date;

public class CheckInfo {
    private Integer id;

    private Integer stayId;

    private Float dueMoney;

    private Float orderMoney;

    private String discountType;

    private Float discountRate;

    private Float paidUpMoney;

    private Date checkDate;

    private String operator;

    private Date createdtime;

    private Date modifiedtime;

    private Float cashPledge;

    private Float lateArrivalNeedPay;

    private Float earlyLeaveNeedPay;

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

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType == null ? null : discountType.trim();
    }

    public Float getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Float discountRate) {
        this.discountRate = discountRate;
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

    public Float getCashPledge() {
        return cashPledge;
    }

    public void setCashPledge(Float cashPledge) {
        this.cashPledge = cashPledge;
    }

    public Float getLateArrivalNeedPay() {
        return lateArrivalNeedPay;
    }

    public void setLateArrivalNeedPay(Float lateArrivalNeedPay) {
        this.lateArrivalNeedPay = lateArrivalNeedPay;
    }

    public Float getEarlyLeaveNeedPay() {
        return earlyLeaveNeedPay;
    }

    public void setEarlyLeaveNeedPay(Float earlyLeaveNeedPay) {
        this.earlyLeaveNeedPay = earlyLeaveNeedPay;
    }
}