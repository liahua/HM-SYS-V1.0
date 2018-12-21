package com.hm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.common.vo.JsonResult;
import com.hm.sys.entity.RoomInfoExample;
import com.hm.sys.service.SysRoomInfoViewService;

@Controller
@RequestMapping("/view/")
public class SysRoomInfoViewController {
	@Autowired
	private SysRoomInfoViewService sysRoomInfoViewService;
	
	@RequestMapping("doRoomViewUI")
	public String doRoomInfoUI(){
		return "room/room_view";
	}
	@RequestMapping("doRoomView")
	@ResponseBody
	public JsonResult doRoomView(RoomInfoExample example){
		return new JsonResult(sysRoomInfoViewService.findObjectsInfo(example));
//		return "room/room_view";
	}
}
