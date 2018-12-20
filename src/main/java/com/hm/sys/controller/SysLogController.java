package com.hm.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log/")
public class SysLogController {
	  @RequestMapping("doLogListUI")
	  public String doLogListUI(){
		  return "logs/log";
	  }
}
