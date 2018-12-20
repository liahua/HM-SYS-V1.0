package com.test.common;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.hm.sys.dao.OrderInfoMapper;
import com.hm.sys.entity.OrderInfo;
import com.hm.sys.entity.OrderInfoExample;
import com.hm.sys.service.impl.SysCheckOutServiceImpl;

public class TestDao extends TestBase {
	@Test
	public void doTestDao() {
		SysCheckOutServiceImpl bean = ctx.getBean("sysCheckOutServiceImpl",SysCheckOutServiceImpl.class);
		bean.checkOutDepencyRoomId("1101");
	}
	
	private Date initDate(Integer hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		System.out.println(calendar.getTime());
		return calendar.getTime();
	}
	
	
}
