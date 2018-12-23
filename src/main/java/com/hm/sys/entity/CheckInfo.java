package com.hm.sys.entity;

import java.util.Date;

public class CheckInfo {
    private Integer id;

    private Integer stayId;

    private Double dueMoney;

    private Double orderMoney;

    private String discountType;

    private Double discountRate;

    private Double paidUpMoney;

    private Date checkDate;

    private String operator;

    private Date createdtime;

    private Date modifiedtime;

    private Double cashPledge;

    private Double lateArrivalNeedPay;

    private Double earlyLeaveNeedPay;

    private Double stayDayNeedPay;

    private Integer lateArrivalDay;

    private Integer earlyLeaveDay;

    private Integer stayDay;

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

    public Double getDueMoney() {
        return dueMoney;
    }

    public void setDueMoney(Double dueMoney) {
        this.dueMoney = dueMoney;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType == null ? null : discountType.trim();
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public Double getPaidUpMoney() {
        return paidUpMoney;
    }

    public void setPaidUpMoney(Double paidUpMoney) {
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

    public Double getCashPledge() {
        return cashPledge;
    }

    public void setCashPledge(Double cashPledge) {
        this.cashPledge = cashPledge;
    }

    public Double getLateArrivalNeedPay() {
        return lateArrivalNeedPay;
    }

    public void setLateArrivalNeedPay(Double lateArrivalNeedPay) {
        this.lateArrivalNeedPay = lateArrivalNeedPay;
    }

    public Double getEarlyLeaveNeedPay() {
        return earlyLeaveNeedPay;
    }

    public void setEarlyLeaveNeedPay(Double earlyLeaveNeedPay) {
        this.earlyLeaveNeedPay = earlyLeaveNeedPay;
    }

    public Double getStayDayNeedPay() {
        return stayDayNeedPay;
    }

    public void setStayDayNeedPay(Double stayDayNeedPay) {
        this.stayDayNeedPay = stayDayNeedPay;
    }

    public Integer getLateArrivalDay() {
        return lateArrivalDay;
    }

    public void setLateArrivalDay(Integer lateArrivalDay) {
        this.lateArrivalDay = lateArrivalDay;
    }

    public Integer getEarlyLeaveDay() {
        return earlyLeaveDay;
    }

    public void setEarlyLeaveDay(Integer earlyLeaveDay) {
        this.earlyLeaveDay = earlyLeaveDay;
    }

    public Integer getStayDay() {
        return stayDay;
    }

    public void setStayDay(Integer stayDay) {
        this.stayDay = stayDay;
    }
}