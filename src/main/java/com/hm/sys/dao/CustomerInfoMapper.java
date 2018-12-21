package com.hm.sys.dao;

import com.hm.common.vo.CustomerAllInfo;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.CustomerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerInfoMapper {
    int countByExample(CustomerInfoExample example);

    int deleteByExample(CustomerInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerInfo record);

    int insertSelective(CustomerInfo record);
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


    CustomerInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerInfo record, @Param("example") CustomerInfoExample example);

    int updateByExample(@Param("record") CustomerInfo record, @Param("example") CustomerInfoExample example);

    int updateByPrimaryKeySelective(CustomerInfo record);

    int updateByPrimaryKey(CustomerInfo record);
}