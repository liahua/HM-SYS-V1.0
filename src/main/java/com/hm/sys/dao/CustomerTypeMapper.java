package com.hm.sys.dao;

import com.hm.sys.entity.CustomerType;
import com.hm.sys.entity.CustomerTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerTypeMapper {
    int countByExample(CustomerTypeExample example);

    int deleteByExample(CustomerTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerType record);

    int insertSelective(CustomerType record);

    List<CustomerType> selectByExample(CustomerTypeExample example);

    CustomerType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerType record, @Param("example") CustomerTypeExample example);

    int updateByExample(@Param("record") CustomerType record, @Param("example") CustomerTypeExample example);

    int updateByPrimaryKeySelective(CustomerType record);

    int updateByPrimaryKey(CustomerType record);
}