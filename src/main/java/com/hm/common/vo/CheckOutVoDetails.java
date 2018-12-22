package com.hm.common.vo;

import java.io.Serializable;
import java.util.List;

import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.OrderInfo;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.StayInfo;

public class CheckOutVoDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4577198849323797815L;
	private List<OrderInfo> orderInfos;
	private List<StayInfo> stayInfos;
	private CustomerInfo customerInfo;
	private RoomInfo roomInfo;
	/**
	 * 1.查询类型为已支付
	 * 0.查询类型为未支付
	 * null.查询类型为全部订单
	 */
	private Integer stayInfoQueryType;
	/**
	 *  2.查询类型为已取消订单
	 * 	1.查询类型为已确认订单
	 * null.查询类型为全部订单
	 */
	private Integer orderInfoQueryType;

	


	public List<OrderInfo> getOrderInfos() {
		return orderInfos;
	}

	public void setOrderInfos(List<OrderInfo> orderInfos) {
		this.orderInfos = orderInfos;
	}

	public List<StayInfo> getStayInfos() {
		return stayInfos;
	}

	public void setStayInfos(List<StayInfo> stayInfos) {
		this.stayInfos = stayInfos;
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

	public Integer getStayInfoQueryType() {
		return stayInfoQueryType;
	}

	public void setStayInfoQueryType(Integer stayInfoQueryType) {
		this.stayInfoQueryType = stayInfoQueryType;
	}

	public Integer getOrderInfoQueryType() {
		return orderInfoQueryType;
	}

	public void setOrderInfoQueryType(Integer orderInfoQueryType) {
		this.orderInfoQueryType = orderInfoQueryType;
	}

	@Override
	public String toString() {
		return "CheckOutVoDetails [orderInfos=" + orderInfos + ", stayInfos=" + stayInfos + ", customerInfo="
				+ customerInfo + ", roomInfo=" + roomInfo + ", stayInfoQueryType=" + stayInfoQueryType
				+ ", orderInfoQueryType=" + orderInfoQueryType + "]";
	}
	

	
	

	
	
	





}
