package com.hm.sys.entity;

public class VipInfo {
    private Integer id;

    private String vipName;

    private Integer vipTel;

    private String gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName == null ? null : vipName.trim();
    }

    public Integer getVipTel() {
        return vipTel;
    }

    public void setVipTel(Integer vipTel) {
        this.vipTel = vipTel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }
}