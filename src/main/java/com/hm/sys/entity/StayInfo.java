package com.hm.sys.entity;

import java.util.Date;

public class StayInfo {
    private Integer id;

    private Integer orderId;

    private Integer roomId;

    private Integer customerId;

    private Date stayDate;

    private Integer stayDayCount;

    private Integer stayManCount;

    private Float cash;

    private Date leaveDate;

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

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getStayDate() {
        return stayDate;
    }

    public void setStayDate(Date stayDate) {
        this.stayDate = stayDate;
    }

    public Integer getStayDayCount() {
        return stayDayCount;
    }

    public void setStayDayCount(Integer stayDayCount) {
        this.stayDayCount = stayDayCount;
    }

    public Integer getStayManCount() {
        return stayManCount;
    }

    public void setStayManCount(Integer stayManCount) {
        this.stayManCount = stayManCount;
    }

    public Float getCash() {
        return cash;
    }

    public void setCash(Float cash) {
        this.cash = cash;
    }

    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
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