package com.hm.sys.service;

import java.util.List;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.RoomType;
import com.hm.sys.entity.RoomTypeExample;

public interface SysRoomTypeService {
	/**
	 * 删除
	 */
	public int deleteRoomType(Integer... ids);
	
     /**
      * 通过此方法执行日志分页查询
      * 1)获取总记录数
      * 2)获取当前页的记录
      * 3)计算总页数
      * 4)封装查询结果
      * @param rtName 查询条件(基于用户名查询日志行为数据)
      * @param pageCurrent 分页条件(当前页的页码值)
      * @return
      */
	 PageObject<RoomType> findPageObjects(
			 String rtName,
			 Integer pageCurrent);

	 
	 List<RoomType> findObjectsType(RoomTypeExample example);

}
