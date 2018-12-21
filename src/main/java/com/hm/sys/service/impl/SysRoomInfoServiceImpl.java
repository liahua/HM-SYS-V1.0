package com.hm.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hm.common.exception.ServiceException;
import com.hm.common.utils.ListUtil;
import com.hm.common.vo.PageObject;
import com.hm.sys.dao.RoomInfoMapper;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.RoomInfoExample;
import com.hm.sys.service.SysRoomInfoService;


@Service
public class SysRoomInfoServiceImpl implements SysRoomInfoService{

	 /**
     * @Qualifier 要与@Autowired注解结合使用。
     * 当为@Autowired修饰的属性按类型注入值，存
     * 在多个类型时，可以借助@Qualifier指定其要
     * 注入的bean的名字
     */
	@Autowired
    @Qualifier("roomInfoMapper")
	private RoomInfoMapper roomInfoMapper;
	
	@Override
	public int deleteRoomInfo(Integer... ids) {
		if(ids==null||ids.length==0)
		    throw new IllegalArgumentException("请选择一个");
			//2.执行删除操作
			int rows;
			try{//此异常可以不在此处理
			rows=roomInfoMapper.deleteRoomInfo(ids);
			}catch(Throwable e){
			e.printStackTrace();
			//发出报警信息(例如给运维人员发短信)
			throw new ServiceException("系统故障，正在恢复中...");
			}
			//4.对结果进行验证
			if(rows==0)
			throw new ServiceException("记录可能已经不存在");
			//5.返回结果
			return rows;
	}
	
	@Override
	public PageObject<RoomInfo> findPageObjects(
			String roomName, 
			Integer pageCurrent){
		//1.对方法参数进行校验
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("页码值不正确");
		//2.依据条件查询总记录数
		int rowCount=roomInfoMapper.getRowCount(roomName);
		//3.对总记录数进行校验(等于0表示没有记录)
		if(rowCount==0)
		//throw new RuntimeException("记录不存在");//不够具体
		//NoRecordsFoundException
	    throw new ServiceException("记录不存在");
		//4.依据条件查询当前页要显示的记录
		int pageSize=2;//页面大小
		int startIndex=(pageCurrent-1)*pageSize;//起始位置
		List<RoomInfo> records=
				roomInfoMapper.findPageObjects(roomName,
						startIndex, pageSize);
		//5.对查询结果进行封装并返回。
		PageObject<RoomInfo> pageObject=new PageObject<>();
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		/*
		方法1：
		int pageCount=rowCount/pageSize;
		if(rowCount%pageSize!=0){
			pageCount++;
		}*/ 
		//方法2
		int pageCount=(rowCount-1)/pageSize+1;
		pageObject.setPageCount(pageCount);
		
		return pageObject;
	}

	@Override
	public List<RoomInfo> findObjectsInfo(RoomInfoExample example) {
		return roomInfoMapper.findObjectsInfo(example);
	}

	
	@Override
	public RoomInfo findRoomFromRoomInfo(String roomNameId) {
		RoomInfoExample roomInfoExample = new RoomInfoExample();
		roomInfoExample.or().andRoomNameEqualTo(roomNameId);
		List<RoomInfo> roomsInfo = roomInfoMapper.selectByExample(roomInfoExample);

		if (ListUtil.isEmpty(roomsInfo)) {
			throw new ServiceException("无此房间");
		} else if (ListUtil.count(roomsInfo) > 1) {
			throw new ServiceException("房间名重复,联系管理员查改");
		}
		RoomInfo roomInfo = roomsInfo.get(0);

		return roomInfo;
	}
}
