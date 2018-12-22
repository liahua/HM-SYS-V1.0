package com.hm.sys.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.CheckOutVoDetails;

import com.hm.common.vo.JsonResult;
import com.hm.sys.entity.CheckInfo;
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
	/**
	 * 
	* @Function: SysCheckOutController.java
	* @Description: 通过checkOutVoDetail 计算付款金额,以及生成checkInfo明细,回显明细表
	*
	* @param checkOutVoDetail
	* @return
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: 李志学
	* @date: 2018年12月22日 下午4:08:38 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年12月22日     李志学          v1.0.0               修改原因
	 */
	public JsonResult CalculateBillDetails(@RequestBody CheckOutVoDetails checkOutVoDetail) {
		List<CheckInfo> checkInfoEntity=sysCheckOutService.CalculateBillDetails(checkOutVoDetail);
		return new JsonResult(checkInfoEntity);
	}
	
	
	
}
