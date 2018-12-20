package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.sys.service.SysRoomStateService;


@Controller
@RequestMapping("/room/")
public class SysRoomStateController {
	
	@RequestMapping("doRoomStateUI")
	public String doRoomStateUI(){
		return "room/room_state";
	}
	
	//1)基于客户端请求,借助业务层对象访问房间状态信息
	//2)对房间状态信息进行封装,并返回
	 @Autowired
	 private SysRoomStateService sysRoomStateService;
     @RequestMapping("dofindRoomState")
	 @ResponseBody
	 public JsonResult dofindRoomState(){
		 return new JsonResult(sysRoomStateService.findRoomState());
	 }
}
