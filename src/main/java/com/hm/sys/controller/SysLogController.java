package com.hm.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.common.vo.PageObject;
import com.hm.sys.entity.SysLogs;
import com.hm.sys.service.SysLogService;


@Controller
@RequestMapping("/log/")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;
	
	  @RequestMapping("doLogUI")
	  public String doLogListUI(){
		  return "logs/log";
	  }
	  /**
	   * 分页查找日志信息
	   * @param username
	   * @param pageCurrent
	   * @return
	   */
	  @RequestMapping("dogetPageObjects")
	  @ResponseBody
	  public JsonResult dogetPageObjects(String username, Integer pageCurrent) {
		  PageObject<SysLogs> objects = sysLogService.getObjects(username, pageCurrent);
		  return new JsonResult(objects);		  
	  }
	  
	  @RequestMapping("doDeleteObjects")
	  @ResponseBody
	  public JsonResult doDeleteObjects(Integer...ids) {
		  sysLogService.deleteObjects(ids);
		  return new JsonResult("delete is ok");
	  }
}
