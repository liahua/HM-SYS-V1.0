package com.hm.sys.entity;

import java.util.Date;

public class AccountRoom {
    private Integer id;

    private Integer roomTypeId;

    private Date day;

    private Integer filledNum;

    private Integer unfilledNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getFilledNum() {
        return filledNum;
    }

    public void setFilledNum(Integer filledNum) {
        this.filledNum = filledNum;
    }

    public Integer getUnfilledNum() {
        return unfilledNum;
    }

    public void setUnfilledNum(Integer unfilledNum) {
        this.unfilledNum = unfilledNum;
    }
}