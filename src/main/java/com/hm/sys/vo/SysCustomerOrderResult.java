package com.hm.sys.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.hm.sys.entity.OrderInfo;

/**
 * 封装入住用户以及订单信息
 * @author Xianggc
 *
 */
public class SysCustomerOrderResult implements Serializable{

	private static final long serialVersionUID = 8437501386508358561L;
	  private Integer id;
	    private String customerName;
	    private String gender;
	    private String country;
	    private String telephone;
	    private Integer cardTypeId;
		private String cardNum;
	    private String operator;
	    private Date createdtime;
	    private Date modifiedtime;
	    private List<OrderInfo> orderInfo;
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
		public Integer getCardTypeId() {
			return cardTypeId;
		}
		public void setCardTypeId(Integer cardTypeId) {
			this.cardTypeId = cardTypeId;
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
		public List<OrderInfo> getOrderInfo() {
			return orderInfo;
		}
		public void setOrderInfo(List<OrderInfo> orderInfo) {
			this.orderInfo = orderInfo;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
	    
}
