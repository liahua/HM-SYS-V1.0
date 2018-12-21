package com.hm.sys.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.CheckOutVoDetails;

import com.hm.common.vo.JsonResult;
import com.hm.sys.service.SysCheckOutService;


@Controller
@RequestMapping("/chectOut/")
public class SysCheckOutController {

	
	private SysCheckOutService sysCheckOutService;

	/**
	 * 
	 * @param checkOutVoDetail 应包含roomNameId CustomerId
	 * @return
	 */
	@RequestMapping("checkOutDepencyRoomNameIdAndC")
	@ResponseBody
	public JsonResult checkOutDepencyRoomNameIdCustomerInfo(CheckOutVoDetails checkOutVoDetail) {
		CheckOutVoDetails checkOutVoDetails=sysCheckOutService.checkOutDepencyRoomNameIdCustomerInfo(checkOutVoDetail);
		return new JsonResult(checkOutVoDetails);
	}
}
