package com.hm.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room/")
public class RoomViewController {
	  @RequestMapping("doRoomViewUI")
	  public String doRoomViewUI(){
		  return "room/room_view";
	  }
}
