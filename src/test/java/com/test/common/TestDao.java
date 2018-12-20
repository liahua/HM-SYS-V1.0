package com.test.common;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.hm.sys.dao.OrderInfoMapper;
import com.hm.sys.entity.OrderInfo;
import com.hm.sys.entity.OrderInfoExample;

public class TestDao extends TestBase {
	@Test
	public void doTestDao() {
		OrderInfoMapper orderInfoMapper = ctx.getBean(OrderInfoMapper.class);
		OrderInfoExample orderInfoExample = new OrderInfoExample();
		com.hm.sys.entity.OrderInfoExample.Criteria criteria = orderInfoExample.createCriteria();
		criteria.andCreatedtimeBetween(initDate(0), initDate(24));
		List<OrderInfo> orderInfolist = orderInfoMapper.selectByExample(orderInfoExample);

		System.out.println(orderInfolist);
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
