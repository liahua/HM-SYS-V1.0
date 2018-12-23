package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.sys.service.SysStayCheckInService;

@Controller
@RequestMapping("/stay/")
public class StayCheckInController {
	@Autowired
	private SysStayCheckInService sysStayCheckInService;
	
	@RequestMapping("doCheckinUI")
	public String doCheckinUI(){
		return "stay/checkin";
	}
	@RequestMapping("doFindObjectByCardNum")
	@ResponseBody
	public JsonResult doFindObjectByCardNum(Integer cardNum) {

		return new JsonResult(
				sysStayCheckInService.findCustomerOrderbyCardNum(cardNum));
	}
	@RequestMapping("doStayCheckIn")
	@ResponseBody
	public JsonResult doStayCheckIn(Integer cardNum) {
		return new JsonResult(
				sysStayCheckInService.insertStayInfo(cardNum, null, null));
	}
}
