package com.hm.sys.dao;

import com.hm.sys.entity.AccountRoom;
import com.hm.sys.entity.AccountRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountRoomMapper {
    int countByExample(AccountRoomExample example);

    int deleteByExample(AccountRoomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccountRoom record);

    int insertSelective(AccountRoom record);

    List<AccountRoom> selectByExample(AccountRoomExample example);

    AccountRoom selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccountRoom record, @Param("example") AccountRoomExample example);

    int updateByExample(@Param("record") AccountRoom record, @Param("example") AccountRoomExample example);

    int updateByPrimaryKeySelective(AccountRoom record);

    int updateByPrimaryKey(AccountRoom record);
}