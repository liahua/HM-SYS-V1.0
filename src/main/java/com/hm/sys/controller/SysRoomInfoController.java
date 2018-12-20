package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.sys.service.SysRoomInfoService;


@Controller
@RequestMapping("/room/")
public class SysRoomInfoController {
	
	@RequestMapping("doRoomInfoUI")
	public String doRoomInfoUI(){
	return "room/room_info";
	}

	//1)基于客户端请求,借助业务层对象访问房间信息
	//2)对房间信息进行封装,并返回
	 @Autowired
	 private SysRoomInfoService sysRoomInfoService;
     @RequestMapping("dofindRoomInfo")
	 @ResponseBody
	 public JsonResult dofindRoomInfo(){
		 return new JsonResult(sysRoomInfoService.findRoomInfo());
	 }
}
