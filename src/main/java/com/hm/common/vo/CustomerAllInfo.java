package com.hm.common.vo;

import java.io.Serializable;
import java.util.Date;


public class CustomerAllInfo implements Serializable{


		/**
	 * 
	 */
	private static final long serialVersionUID = -2067857748398370764L;
		private Integer id;
	    private String customerName;
	    private String gender;
	    private String country;
	    private String telephone;
	    private String cardType;
		private String cardNum;
	    private String operator;
	    private Date createdTime;
	    private Date modifiedTime;
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
			this.customerName = customerName;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String getCardType() {
			return cardType;
		}
		public void setCardType(String cardType) {
			this.cardType = cardType;
		}
		public String getCardNum() {
			return cardNum;
		}
		public void setCardNum(String cardNum) {
			this.cardNum = cardNum;
		}
		public String getOperator() {
			return operator;
		}
		public void setOperator(String operator) {
			this.operator = operator;
		}
	
		public Date getCreatedTime() {
			return createdTime;
		}
		public void setCreatedTime(Date createdTime) {
			this.createdTime = createdTime;
		}
		public Date getModifiedTime() {
			return modifiedTime;
		}
		public void setModifiedTime(Date modifiedTime) {
			this.modifiedTime = modifiedTime;
		}
		@Override
		public String toString() {
			return "CustomerAllInfo [id=" + id + ", customerName=" + customerName + ", gender=" + gender + ", country="
					+ country + ", telephone=" + telephone + ", cardType=" + cardType + ", cardNum=" + cardNum
					+ ", operator=" + operator + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime
					+ "]";
		}
	
		
	   
}
