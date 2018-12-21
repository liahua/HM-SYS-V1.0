package com.hm.sys.dao;

import com.hm.sys.entity.CustomerCardType;
import com.hm.sys.entity.CustomerCardTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerCardTypeMapper {
    int countByExample(CustomerCardTypeExample example);

    int deleteByExample(CustomerCardTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerCardType record);

    int insertSelective(CustomerCardType record);

    List<CustomerCardType> selectByExample(CustomerCardTypeExample example);

    CustomerCardType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerCardType record, @Param("example") CustomerCardTypeExample example);

    int updateByExample(@Param("record") CustomerCardType record, @Param("example") CustomerCardTypeExample example);

    int updateByPrimaryKeySelective(CustomerCardType record);

    int updateByPrimaryKey(CustomerCardType record);
}