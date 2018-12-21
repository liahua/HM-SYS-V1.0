package com.hm.common.vo;

import java.util.Date;

public class CustomerAllInfo {
	   private Integer id;

	    private String customerName;

	    private String gender;

	    private String country;

	    private String telephone;

	    private String cardType;

	    public String getCardType() {
			return cardType;
		}

		public void setCardType(String cardType) {
			this.cardType = cardType;
		}

		private String cardNum;

	    private String operator;

	    private Date createdtime;

	    private Date modifiedtime;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName == null ? null : customerName.trim();
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender == null ? null : gender.trim();
	    }

	    public String getCountry() {
	        return country;
	    }

	    public void setCountry(String country) {
	        this.country = country == null ? null : country.trim();
	    }

	    public String getTelephone() {
	        return telephone;
	    }

	    public void setTelephone(String telephone) {
	        this.telephone = telephone == null ? null : telephone.trim();
	    }

	

	    public String getCardNum() {
	        return cardNum;
	    }

	    public void setCardNum(String cardNum) {
	        this.cardNum = cardNum == null ? null : cardNum.trim();
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
