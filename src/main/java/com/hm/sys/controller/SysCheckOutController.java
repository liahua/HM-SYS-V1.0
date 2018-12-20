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
	 * @param roomId 房间的id
	 * @return 房客需支付的价格
	 */
	@RequestMapping("depencyRoomId")
	@ResponseBody
	public JsonResult checkOut(Integer roomId) {
		CheckOutVoDetails checkOutVoDetails=sysCheckOutService.checkOutOrder(roomId);
		return new JsonResult(checkOutVoDetails);
	}
}
