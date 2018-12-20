package com.hm.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room/")
public class SysRoomController {
	
	@RequestMapping("doRoomInfoUI")
	public String doRoomInfoUI(){
	return "room/room_info";
	}
	
	@RequestMapping("doRoomTypeUI")
	public String doRoomTypeUI(){
		return "room/room_type";
	}
	
	@RequestMapping("doRoomStateUI")
	public String doRoomStateUI(){
		return "room/room_state";
	}
}
