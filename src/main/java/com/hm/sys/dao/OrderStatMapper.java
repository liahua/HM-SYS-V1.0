package com.hm.sys.dao;

import com.hm.sys.entity.OrderStat;
import com.hm.sys.entity.OrderStatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderStatMapper {
    int countByExample(OrderStatExample example);

    int deleteByExample(OrderStatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderStat record);

    int insertSelective(OrderStat record);

    List<OrderStat> selectByExample(OrderStatExample example);

    OrderStat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderStat record, @Param("example") OrderStatExample example);

    int updateByExample(@Param("record") OrderStat record, @Param("example") OrderStatExample example);

    int updateByPrimaryKeySelective(OrderStat record);

    int updateByPrimaryKey(OrderStat record);
}