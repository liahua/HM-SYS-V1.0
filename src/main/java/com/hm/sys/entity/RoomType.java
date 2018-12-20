package com.hm.sys.entity;

public class RoomType {
    private Integer id;

    private String rtName;

    private Float priceUp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRtName() {
        return rtName;
    }

    public void setRtName(String rtName) {
        this.rtName = rtName == null ? null : rtName.trim();
    }

    public Float getPriceUp() {
        return priceUp;
    }

    public void setPriceUp(Float priceUp) {
        this.priceUp = priceUp;
    }
}