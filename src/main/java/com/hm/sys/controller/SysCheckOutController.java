package com.hm.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.CheckOutVoDetails;
import com.hm.common.vo.CheckoutSettlementVoDetail;
import com.hm.common.vo.JsonResult;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.service.SysCheckOutService;
import com.sun.org.apache.regexp.internal.recompile;


@Controller
@RequestMapping("/checkOut/")
public class SysCheckOutController {

	@Autowired
	private SysCheckOutService sysCheckOutService;

	/**
	 * 
	 * @param checkOutVoDetail 应包含roomNameId CustomerNameTelephone|id|cardTypecardNum
	 * @return
	 */
	@RequestMapping("checkOutDepencyRoomNameIdCustomerInfo")
	@ResponseBody
	public JsonResult checkOutDepencyRoomNameIdCustomerInfo(@RequestBody CheckOutVoDetails checkOutVoDetail) {
		
	/*	CheckOutVoDetails checkOutVoDetails1 = new CheckOutVoDetails();
		RoomInfo roomInfo = new RoomInfo();
		roomInfo.setRoomName("2202");
		checkOutVoDetails1.setRoomInfo(roomInfo);
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setId(1);
		checkOutVoDetails1.setCustomerInfo(customerInfo);
		System.out.println("checkOutVoDetails1"+checkOutVoDetails1);*/
		
		CheckOutVoDetails checkOutVoDetails=sysCheckOutService.checkOutDepencyRoomNameIdCustomerInfo(checkOutVoDetail);
		return new JsonResult(checkOutVoDetails);
	}
	public JsonResult CheckoutSettlement(@RequestBody CheckOutVoDetails checkOutVoDetail) {
		CheckoutSettlementVoDetail checkoutSettlementVoDetail=sysCheckOutService.CheckoutSettlement(checkOutVoDetail);
		return new JsonResult(checkoutSettlementVoDetail);
	}
	
	
	
}
