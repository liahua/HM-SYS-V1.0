package com.hm.sys.dao;

import com.hm.sys.entity.SysRoles;
import com.hm.sys.entity.SysRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolesMapper {
    int countByExample(SysRolesExample example);

    int deleteByExample(SysRolesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysRoles record);

    int insertSelective(SysRoles record);
    
    List<SysRoles> selectByExample(SysRolesExample example);

    SysRoles selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysRoles record, @Param("example") SysRolesExample example);

    int updateByExample(@Param("record") SysRoles record, @Param("example") SysRolesExample example);

    int updateByPrimaryKeySelective(SysRoles record);

    int updateByPrimaryKey(SysRoles record);
    
    /**
     * 分页查询角色信息
     * @param startIndex 上一页的结束位置
     * @param pageSize 每页要查询的记录数
     * @return
     */
	List<SysRoles> findPageObjects(
             @Param("name")String name,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**
	 * 查询记录总数
	 * @return
	 */
	int getRowCount(@Param("name")String name);
}