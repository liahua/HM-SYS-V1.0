package com.hm.common.vo;

import java.io.Serializable;

import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.OrderInfo;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.StayInfo;

public class CheckOutVoDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4577198849323797815L;
	private OrderInfo orderInfo;
	private StayInfo stayInfo;
	private CustomerInfo customerInfo;
	private RoomInfo roomInfo;
	public OrderInfo getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
	public StayInfo getStayInfo() {
		return stayInfo;
	}
	public void setStayInfo(StayInfo stayInfo) {
		this.stayInfo = stayInfo;
	}
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public RoomInfo getRoomInfo() {
		return roomInfo;
	}
	public void setRoomInfo(RoomInfo roomInfo) {
		this.roomInfo = roomInfo;
	}
	@Override
	public String toString() {
		return "CheckOutVoDetails [orderInfo=" + orderInfo + ", stayInfo=" + stayInfo + ", customerInfo=" + customerInfo
				+ ", roomInfo=" + roomInfo + "]";
	}
	
	
	
	
	

}
