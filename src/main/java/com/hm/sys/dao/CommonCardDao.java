package com.hm.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CommonCardDao {
	
	/**
	 * 叶云彤
	 * 
	 * card表中数据删除
	 * @param customered
	 * @return
	 */
	int deleteObjectsByCardId(Integer Id);
	
	/**
	 * 修改模块(证件类型)先查找
	 */
	List<Integer> findMenuIdsByCardId(Integer Id);
	
	/**
	 * 叶云彤
	 * 往数据库插数据
	 * @param roleId
	 * @param menuIds
	 * @return
	 */
		int insertObject(
				@Param("commonid")Integer roleId,
				@Param("cardid")Integer[] menuIds);
		
		List<Integer> findMenuIdsByCustomerIds(
				@Param("commonids")Integer[] integers);
		
		int deleteObjectsByCustomerId(Integer customerId);
}
