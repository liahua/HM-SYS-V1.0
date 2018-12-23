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
	
	@RequestMapping("doAccountUI")
	public String doAccountUI() {
		return "account/account";
	}
	
	@RequestMapping("doDayAccount")
	@ResponseBody
	public JsonResult doDayAccount(String date) {
		
		int row = sysAccountService.doDayCheck(date);
		return new JsonResult(row);
	}
	
	@RequestMapping("doFindAccounts")
	@ResponseBody
	public JsonResult doFindAccounts(String start,String end) {
		System.out.println(start+end);
		DayAccount dayAccount = sysAccountService.doFindDayAccounts(start, end);
		return new JsonResult(dayAccount);
	}
}
