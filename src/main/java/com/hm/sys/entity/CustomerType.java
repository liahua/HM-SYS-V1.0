package com.hm.sys.entity;

public class CustomerType {
    private Integer id;

    private String customerType;

    private Float discountPer;

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

    public Float getDiscountPer() {
        return discountPer;
    }

    public void setDiscountPer(Float discountPer) {
        this.discountPer = discountPer;
    }
}