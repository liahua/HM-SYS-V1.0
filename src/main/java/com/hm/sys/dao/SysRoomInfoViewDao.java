/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.hm.sys.dao 
 * @author: lord   
 * @date: Dec 22, 2018 5:45:57 AM 
 */
package com.hm.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.RoomInfoExample;

/**   
* Copyright: Copyright (c) 2018 lord
* 
* @ClassName: SysRoomInfoViewDao.java
* @Description:  房间信息预览
*
* @version: v1.0.0
* @author: lord
* @date: Dec 22, 2018 5:45:57 AM 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* Dec 22, 2018     lord           v1.0.0               
*/
public interface SysRoomInfoViewDao {
	/**
	 * 
	* @Function: SysRoomInfoViewDao.java
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: lord
	* @date: Dec 22, 2018 6:00:20 AM 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* Dec 22, 2018     lord           v1.0.0               修改原因
	 */
	 int getRowCount(@Param("roomName")String roomName);

	 List<RoomInfo> findPageObjects(
			 @Param("roomName")String roomName,
			 @Param("startIndex")Integer startIndex,
			 @Param("pageSize")Integer pageSize);	 
	 
	 List<RoomInfo> findObjectsInfo(RoomInfoExample example);
	 /**
	  * 
	 * @Function: SysRoomInfoViewDao.java
	 * @Description: 根据id查询用户信息
	 *
	 * @param:描述1描述
	 * @return：返回结果描述
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: lord
	 * @date: Dec 22, 2018 6:00:40 AM 
	 *
	 * Modification History:
	 * Date         Author          Version            Description
	 *---------------------------------------------------------*
	 * Dec 22, 2018     lord           v1.0.0               修改原因
	  */
	 RoomInfo findObjectById(Integer id);
}
