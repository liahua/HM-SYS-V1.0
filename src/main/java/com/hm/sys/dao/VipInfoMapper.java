package com.hm.sys.dao;

import com.hm.sys.entity.VipInfo;
import com.hm.sys.entity.VipInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VipInfoMapper {
    int countByExample(VipInfoExample example);

    int deleteByExample(VipInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VipInfo record);

    int insertSelective(VipInfo record);

    List<VipInfo> selectByExample(VipInfoExample example);

    VipInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VipInfo record, @Param("example") VipInfoExample example);

    int updateByExample(@Param("record") VipInfo record, @Param("example") VipInfoExample example);

    int updateByPrimaryKeySelective(VipInfo record);

    int updateByPrimaryKey(VipInfo record);
}