package com.hm.sys.dao;

import com.hm.sys.entity.SysMenus;
import com.hm.sys.entity.SysMenusExample;
import com.hm.sys.vo.Node;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenusMapper {
    int countByExample(SysMenusExample example);
    /**
     * 根据id查询子菜单数量
     * @param id
     * @return
     */
    int getChildCount(Integer id);

    int deleteByExample(SysMenusExample example);
    /**
     * 根据id删除菜单
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 添加数据
     * @param record
     * @return
     */
    int insert(SysMenus record);

    int insertSelective(SysMenus record);

    List<SysMenus> selectByExample(SysMenusExample example);

    SysMenus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysMenus record, @Param("example") SysMenusExample example);

    int updateByExample(@Param("record") SysMenus record, @Param("example") SysMenusExample example);

    int updateByPrimaryKeySelective(SysMenus record);
    
    int updateByPrimaryKey(SysMenus record);
    /**
     * 定义一个Node对象,借助此对象封装从数据库查询到的数据
     * @return
     */
    List<Node> findZtreeMenuNodes();
}