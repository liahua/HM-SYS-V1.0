package com.hm.sys.service;


import com.hm.common.vo.PageObject;
import com.hm.sys.entity.RoomInfo;


public interface SysRoomInfoService {
	/**
	 * 删除
	 */
	public int deleteRoomInfo(Integer... ids);
	
     /**
      * 通过此方法执行日志分页查询
      * 1)获取总记录数
      * 2)获取当前页的记录
      * 3)计算总页数
      * 4)封装查询结果
      * @param roomName 查询条件(基于用户名查询日志行为数据)
      * @param pageCurrent 分页条件(当前页的页码值)
      * @return
      */
	 PageObject<RoomInfo> findPageObjects(
			 String roomName,
			 Integer pageCurrent);
}
