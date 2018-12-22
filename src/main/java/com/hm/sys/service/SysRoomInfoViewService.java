package com.hm.sys.service;

import java.util.List;
import java.util.Map;

import com.hm.common.vo.PageObject;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.RoomInfoExample;
/**
 * 
 * @author luorui
 *
 */
public interface SysRoomInfoViewService {
	/**
	 * 查找房间信息
	 * @param room 房间信息
	 * @return
	 */
	List<RoomInfo> findObjectsInfo(RoomInfoExample room);
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
	 /**
	  * 
	 * @Function: SysRoomInfoViewService.java
	 * @Description: 该函数的功能描述
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: lord
	 * @date: Dec 22, 2018 5:41:09 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 22, 2018     lord           v1.0.0               修改原因
	  */
	 public Map<String, Object> findObjectById(Integer id);
}
