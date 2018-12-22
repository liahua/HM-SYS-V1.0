package com.hm.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hm.common.vo.CustomerAllInfo;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.CustomerInfoExample;

/**
 * 
 * @author 叶云彤
 *
 */
public interface CommonDao {
	/**
	 * list集合查询封装
	 * @param 
	 * @return
	 */
	   List<CustomerInfo> selectByExample(CustomerInfoExample example);
	    /**
	     * 分页查询角色信息
	     * @param startIndex 上一页的结束位置
	     * @param pageSize 每页要查询的记录数
	     * @return
	     */
		
		List<CustomerAllInfo> findPageObjects(
	             @Param("name")String name,
				@Param("startIndex")Integer startIndex,
				@Param("pageSize")Integer pageSize);
		/**
		 * 查询记录总数
		 * @return
		 */
		int getRowCount(@Param("name")String name);

}
