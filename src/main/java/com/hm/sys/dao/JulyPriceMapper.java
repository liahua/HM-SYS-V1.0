package com.hm.sys.dao;

import com.hm.sys.entity.JulyPrice;
import com.hm.sys.entity.JulyPriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JulyPriceMapper {
    int countByExample(JulyPriceExample example);

    int deleteByExample(JulyPriceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(JulyPrice record);

    int insertSelective(JulyPrice record);

    List<JulyPrice> selectByExample(JulyPriceExample example);

    JulyPrice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") JulyPrice record, @Param("example") JulyPriceExample example);

    int updateByExample(@Param("record") JulyPrice record, @Param("example") JulyPriceExample example);

    int updateByPrimaryKeySelective(JulyPrice record);

    int updateByPrimaryKey(JulyPrice record);
}