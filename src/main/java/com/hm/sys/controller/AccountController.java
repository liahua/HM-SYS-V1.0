package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.DayAccount;
import com.hm.common.vo.JsonResult;
import com.hm.sys.service.SysAccountService;

@Controller
@RequestMapping("/account/")
public class AccountController {

	@Autowired
	private SysAccountService sysAccountService;
	
	@RequestMapping("doDayAccount")
	@ResponseBody
	public JsonResult doDayAccount(String date) {
		
		DayAccount dayCheck = sysAccountService.doDayCheck(date);
		return new JsonResult(dayCheck);
	}
}
