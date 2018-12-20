package com.hm.sys.dao;

import com.hm.sys.entity.SysDepts;
import com.hm.sys.entity.SysDeptsExample;
import com.hm.sys.vo.Node;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDeptsMapper {
    int countByExample(SysDeptsExample example);

    int deleteByExample(SysDeptsExample example);
    /**
               * 根据id删除部门信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    int insert(SysDepts record);

    int insertSelective(SysDepts record);
    /**
              * 查询sys_depts的表信息
     * @param example
     * @return
     */
    List<SysDepts> selectByExample(SysDeptsExample example);
    /**
     * 根据id查询子目录子部门数量
     * @param id
     * @return
     */
    public int getChildCount(Integer id);

    SysDepts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysDepts record, @Param("example") SysDeptsExample example);

    int updateByExample(@Param("record") SysDepts record, @Param("example") SysDeptsExample example);

    int updateByPrimaryKeySelective(SysDepts record);

    int updateByPrimaryKey(SysDepts record);
    
    public List<Node> findZtreeDeptNodes();
    
}