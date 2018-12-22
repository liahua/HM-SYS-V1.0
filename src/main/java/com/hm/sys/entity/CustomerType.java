package com.hm.sys.entity;

public class CustomerType {
    private Integer id;

    private String customerType;

    private Double discountPer;

    private Double lateArrivePer;

    private Double earlyLeavePer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType == null ? null : customerType.trim();
    }

    public Double getDiscountPer() {
        return discountPer;
    }

    public void setDiscountPer(Double discountPer) {
        this.discountPer = discountPer;
    }

    public Double getLateArrivePer() {
        return lateArrivePer;
    }

    public void setLateArrivePer(Double lateArrivePer) {
        this.lateArrivePer = lateArrivePer;
    }

    public Double getEarlyLeavePer() {
        return earlyLeavePer;
    }

    public void setEarlyLeavePer(Double earlyLeavePer) {
        this.earlyLeavePer = earlyLeavePer;
    }
}