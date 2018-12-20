package com.hm.sys.dao;

import com.hm.sys.entity.SysUsers;
import com.hm.sys.entity.SysUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUsersMapper {
	/**
	 * 根据deptId查询部门人数
	 * @param id
	 * @return
	 */
	int getCountByDeptId(Integer id);
	
    int countByExample(SysUsersExample example);

    int deleteByExample(SysUsersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUsers record);

    int insertSelective(SysUsers record);

    List<SysUsers> selectByExample(SysUsersExample example);

    SysUsers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUsers record, @Param("example") SysUsersExample example);

    int updateByExample(@Param("record") SysUsers record, @Param("example") SysUsersExample example);

    int updateByPrimaryKeySelective(SysUsers record);

    int updateByPrimaryKey(SysUsers record);
}