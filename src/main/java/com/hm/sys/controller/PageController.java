package com.hm.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 系统底层发现@RequestMapping注解以后会
 * 找到一个HandlerMapping对象(具备全局唯一性)，
 * 此对象内部对应的是一个map,用于存储url到具体方法的映射
 * 说明:在spring mvc中会将@Controller注解修饰
 * 的类理解为Handler对象
 * @author lord
 * Dec 12, 2018-7:28:19 PM
 */
@RequestMapping("/")
@Controller
public class PageController {
	/**
	 * 
	 * @return 首页页面
	 */
	@RequestMapping("index")
	public String index(){
		return "index";
	}
	
	 @RequestMapping("doPageUI")
	  public String doPageUI(){
		  return "customer/page";//page.html
	  }
	 

		//分页加载
		@RequestMapping("doPageUIyl")
		public String doPageUIyl(){
			 return "room/page";
		 }
}
