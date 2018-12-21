package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.sys.entity.CustomerTypeExample;
import com.hm.sys.service.SysCustomerService;
/**
 * 
 * 客户管理  
 * @author 叶云彤
 *
 */
@Controller
@RequestMapping("/common/")
public class CommonController {

	@Autowired
	private SysCustomerService sysCustomerService;
	/**
	 * 普通客户
	 * 
	 * @return
	 */
	@RequestMapping("doCommonUI")
	public String doCommonUI() {
		return "customer/customer";
	}
	/**
	 * 
	 * 显示页面数据
	 * @param example
	 * @return
	 */
	@RequestMapping("selectByExample")
	@ResponseBody
		public JsonResult selectByExample(CustomerTypeExample example) {
			return new JsonResult(sysCustomerService.selectByExample(example));
		}
	
}
