package com.hm.sys.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.common.exception.ServiceException;
import com.hm.common.utils.DictionarySetData;
import com.hm.common.utils.IntegerUtil;
import com.hm.common.utils.ObjectUtil;
import com.hm.common.vo.CheckOutVoDetails;
import com.hm.sys.dao.JulyPriceMapper;
import com.hm.sys.dao.OrderInfoMapper;
import com.hm.sys.entity.CheckInfo;
import com.hm.sys.entity.CustomerInfo;
import com.hm.sys.entity.JulyPrice;
import com.hm.sys.entity.JulyPriceExample;
import com.hm.sys.entity.OrderInfo;
import com.hm.sys.entity.RoomInfo;
import com.hm.sys.entity.StayInfo;
import com.hm.sys.service.SysCheckOutService;
import com.hm.sys.service.SysCustomerService;
import com.hm.sys.service.SysOrderService;

import com.hm.sys.service.SysStayInfoService;

import sun.nio.cs.ext.Big5;

@Service
public class SysCheckOutServiceImpl implements SysCheckOutService, DictionarySetData {

	@Autowired
	private SysCustomerService sysCustomerService;

	@Autowired
	private SysStayInfoService sysStayInfoService;
	@Autowired
	private SysOrderService sysOrderService;
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	private JulyPriceMapper julyPriceMapper;

	@Override
	public CheckOutVoDetails checkOutDepencyCustomerInfo(CheckOutVoDetails checkOutVoDetail) {
		// 1.roomId是否合法
		// 2.roomId是否存在roomEntity
		// 3.roomId是否存在未支付
		// 4.如果stayInfoQueryType==0
		if (checkOutVoDetail == null || checkOutVoDetail.getCustomerInfo() == null) {
			throw new ServiceException("用户信息为空");
		}

//		通过CardTypeIdCardNum查找CustomerInfo
//		通过CustomerNameTelephone查找CustomerInfo
//		通过id查找CustomerInfo
		CustomerInfo customerInfo = sysCustomerService.findCustomerInfo(checkOutVoDetail.getCustomerInfo());
		// 通过customerInfo查找入住信息,已经包含了指定的stayInfo的查询类型

		List<StayInfo> stayInfos = sysStayInfoService.findStayInfo(customerInfo,
				checkOutVoDetail.getStayInfoQueryType());

		// 根据stayInfo查找OrderInfos
		ArrayList<OrderInfo> orderInfos = new ArrayList<>();
		Map<Integer, OrderInfo> stayAndOrderInfoMap = new HashMap<>();
		for (StayInfo stayInfo : stayInfos) {
			OrderInfo orderInfo = sysOrderService.findOrderInfo(stayInfo.getOrderId());
			orderInfos.add(orderInfo);
			stayAndOrderInfoMap.put(stayInfo.getId(), orderInfo);
		}

		checkOutVoDetail.setCustomerInfo(customerInfo);
		checkOutVoDetail.setStayInfos(stayInfos);
		checkOutVoDetail.setOrderInfos(orderInfos);
		checkOutVoDetail.setStayAndOrderInfoMap(stayAndOrderInfoMap);

		return checkOutVoDetail;
	}

	@Override
	public List<CheckInfo> CalculateUnpayBillDetails(CheckOutVoDetails checkOutVoDetail) {
		if (ObjectUtil.isEmpty(checkOutVoDetail)) {
			new ServiceException("checkOutVoDetail为空");
		}
		List<OrderInfo> orderInfos = checkOutVoDetail.getOrderInfos();
		List<StayInfo> stayInfos = checkOutVoDetail.getStayInfos();
		CustomerInfo customerInfo = checkOutVoDetail.getCustomerInfo();
		RoomInfo roomInfo = checkOutVoDetail.getRoomInfo();
		Map<Integer, OrderInfo> stayAndOrderInfoMap = checkOutVoDetail.getStayAndOrderInfoMap();
		if (ObjectUtil.isEmpty(orderInfos, stayInfos, customerInfo, roomInfo, stayAndOrderInfoMap)) {
			new ServiceException("checkOutVoDetail传入参数不全,请检查");
		}

//		1.查找无leaveDate的stayInfo,即未支付的当前账单,将临时将此刻系统时间赋值给未支付账单的leaveDate
		StayInfo thisTimeStayInfo = null;
		for (StayInfo stayInfo : stayInfos) {
			if (stayInfo.getLeaveDate() == null) {
				Date leaveDate = new Date(System.currentTimeMillis());
				stayInfo.setLeaveDate(leaveDate);
				thisTimeStayInfo = stayInfo;
			}
		}
		OrderInfo thisTimeOrderInfo = stayAndOrderInfoMap.get(thisTimeStayInfo.getId());

//	  2.根据折扣比率计算每日房价
		Double aveDailyRate = getDailyRate(thisTimeOrderInfo);
//	  3.根据orderInfo,stayInfo计算lateArrivalDay,stayDay,earlyLeaveDay	
		// 需要对stayInfo中的StayDate,LeaveDate向前一天,后一天取整
		Date stayDateVirtual = null;
		Date leaveDateVirtual = null;
		try {
			stayDateVirtual = getStayDateVirtual(thisTimeStayInfo.getStayDate());
			leaveDateVirtual = getLeaveDateVirtual(thisTimeStayInfo.getLeaveDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int lateArrivalDay = getDaysCountInfo(thisTimeOrderInfo.getCheckinDate(), stayDateVirtual);
		int stayDay = getDaysCountInfo(stayDateVirtual, leaveDateVirtual);
		int earlyLeaveDay = getDaysCountInfo(leaveDateVirtual, thisTimeOrderInfo.getCheckoutDate());
	
//	  4.根据lateArrivalDay,stayDay,earlyLeaveDay分别计算lateArrivalNeedPay,stayDayNeedPay,earlyLeaveNeedPay
		double lateArrivalNeedPay=getLateArrivalNeedPay(lateArrivalDay,aveDailyRate);
		double stayDayNeedPay=getStayDayNeedPay(stayDay,aveDailyRate);
		double earlyLeaveNeedPay=getEarlyLeaveNeedPay(earlyLeaveDay,aveDailyRate);
			
//	  5.根据lateArrivalNeedPay,stayDayNeedPay,earlyLeaveNeedPay计算dueMoney
		double dueMoney=lateArrivalNeedPay+stayDayNeedPay+earlyLeaveNeedPay;
//	  6.根据dueMoney-(orderMoney+cashPledge)计算paidUpMoney
		Double orderMoney = thisTimeOrderInfo.getOrderMoney();
		Double cashPledge = thisTimeStayInfo.getCash();
		double paidUpMoney=dueMoney-(orderMoney+cashPledge);
//	  7.存入CheckInfo
		CheckInfo checkInfo = new CheckInfo();
//	  8.根据stayInfo列表中其他stayInfo,获取checkInfo
//	  9.将checkInfo放入list集合中
//	  8.回显

		return null;
	}

	/**
	 * 
	* @Function: SysCheckOutServiceImpl.java
	* @Description: 计算金额  加入切面
	*
	* @param earlyLeaveDay
	* @param aveDailyRate
	* @return
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: 李志学
	* @date: 2018年12月23日 下午2:17:43 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年12月23日     李志学          v1.0.0               修改原因
	 */
	private double getEarlyLeaveNeedPay(int earlyLeaveDay, Double aveDailyRate) {
		
		return earlyLeaveDay*aveDailyRate;
	}

	/**
	 * 
	* @Function: SysCheckOutServiceImpl.java
	* @Description: 计算金额,加入切面
	*
	* @param stayDay
	* @param aveDailyRate
	* @return
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: 李志学
	* @date: 2018年12月23日 下午2:18:02 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年12月23日     李志学          v1.0.0               修改原因
	 */
	private Double getStayDayNeedPay(int stayDay, Double aveDailyRate) {
		
		return stayDay*aveDailyRate;
	}

	/**
	 * 
	* @Function: SysCheckOutServiceImpl.java
	* @Description: 计算金额,加入切面
	*
	* @param lateArrivalDay
	* @param aveDailyRate
	* @return
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: 李志学
	* @date: 2018年12月23日 下午2:18:22 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2018年12月23日     李志学          v1.0.0               修改原因
	 */
	private Double getLateArrivalNeedPay(int lateArrivalDay, Double aveDailyRate) {
		
		return lateArrivalDay*aveDailyRate;
	}

	/**
	 * 
	 * @Function: SysCheckOutServiceImpl.java
	 * @Description: 向前取整 [12-22 12:00,12-23 12:00) [12-23 12:00,12-24 12:00) 12-23
	 *               2:00 ---------->12-22 12:00 12-23 13:00 --------->12-23 12:00
	 *               12-23 12:00---------->12-23 12:00
	 *
	 * @param stayDate
	 * @return
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: 李志学
	 * @throws ParseException
	 * @date: 2018年12月23日 上午11:37:18
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------* 2018年12月23日
	 *        李志学 v1.0.0 修改原因
	 */
	private Date getStayDateVirtual(Date stayDate) throws ParseException {

		Map<String, Long> standardDateMap = getStandardDateMap(stayDate);
		Long dateTime = standardDateMap.get("dateTime");
		Long lastDateTime = standardDateMap.get("lastDateTime");
		Long todayDateTime = standardDateMap.get("todayDateTime");
		if (dateTime >= lastDateTime && dateTime < todayDateTime) {
			return new Date(lastDateTime);
		} else {
			return new Date(todayDateTime);
		}
	}

	/**
	 * 
	 * @Function: SysCheckOutServiceImpl.java
	 * @Description: 将当前date转成酒店入店/离店标准时间 Map 
	 * 12-23 12:53 ------> 12-23 12:00||12-24 12:00
	 * 该函数的功能描述 Calendar在高并发情况下 需要做LocalThread
	 *
	 * @param stayDate
	 * @return
	 * @throws ParseException
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: 李志学
	 * @date: 2018年12月23日 下午12:35:31
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------* 2018年12月23日
	 *        李志学 v1.0.0 修改原因
	 */
	private Map<String, Long> getStandardDateMap(Date stayDate) throws ParseException {
		Calendar instance = Calendar.getInstance();

		instance.setTime(stayDate);
		instance.add(Calendar.DAY_OF_MONTH, 1);
		Date nextTime = instance.getTime();

		instance.setTime(stayDate);
		instance.add(Calendar.DAY_OF_MONTH, -1);
		Date lastTime = instance.getTime();

		nextTime = parseStandardDate(nextTime);
		lastTime = parseStandardDate(lastTime);
		Date todayTime = parseStandardDate(stayDate);

		long dateTime = stayDate.getTime();
		long nextDateTime = nextTime.getTime();
		long lastDateTime = lastTime.getTime();
		long todayDateTime = todayTime.getTime();

		HashMap<String, Long> standardDateMap = new HashMap<>();
		standardDateMap.put("dateTime", dateTime);
		standardDateMap.put("nextDateTime", nextDateTime);
		standardDateMap.put("lastDateTime", lastDateTime);
		standardDateMap.put("todayDateTime", todayDateTime);

		return standardDateMap;
	}

	private Date parseStandardDate(Date date) throws ParseException {
		SimpleDateFormat sdfStart = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdfStart.format(date);
		time = time + " " + "12:00:00";
		Date standardDate = sdfEnd.parse(time);
		return standardDate;
	}

	/**
	 * 
	 * @Function: SysCheckOutServiceImpl.java
	 * @Description: 向后取整 [12-22 12:00,12-23 12:00) [12-23 12:00,12-24 12:00)
	 *
	 * @param leaveDate
	 * @return
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: 李志学
	 * @throws ParseException
	 * @date: 2018年12月23日 上午11:37:32
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------* 2018年12月23日
	 *        李志学 v1.0.0 修改原因
	 */
	private Date getLeaveDateVirtual(Date leaveDate) throws ParseException {
		Map<String, Long> standardDateMap = getStandardDateMap(leaveDate);
		Long dateTime = standardDateMap.get("dateTime");
		Long lastDateTime = standardDateMap.get("lastDateTime");
		Long todayDateTime = standardDateMap.get("todayDateTime");
		Long nextDateTime = standardDateMap.get("nextDateTime");
		if (dateTime >= lastDateTime && dateTime < todayDateTime) {
			return new Date(todayDateTime);
		} else {
			return new Date(nextDateTime);
		}
	}

	/**
	 * 
	 * @Function: SysCheckOutServiceImpl.java
	 * @Description: 该函数的功能描述 [12-22 12:00,12-23 12:00) [12-23 12:00,12-24 12:00)
	 * 
	 * @param checkinDate 此时间向当前时间
	 * @param stayDate
	 * @return
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: 李志学
	 * @date: 2018年12月23日 上午11:16:16
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------* 2018年12月23日
	 *        李志学 v1.0.0 修改原因
	 */
	private int getDaysCountInfo(Date checkinDate, Date stayDate) {
		int daysCount=0;
		Calendar calendar = Calendar.getInstance();
		Date temp=checkinDate;
		while(temp.before(stayDate)) {
			calendar.setTime(temp);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			temp=calendar.getTime();
			daysCount++;
		}
		
		return daysCount;
	}

	/**
	 * 
	 * @Function: SysCheckOutServiceImpl.java
	 * @Description: 通过orderInfo计算每日平均房价 可通过AOP实现打折计算
	 *
	 * @param orderInfo
	 * @return
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: 李志学
	 * @date: 2018年12月23日 上午10:39:34
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------* 2018年12月23日
	 *        李志学 v1.0.0 修改原因
	 */
	private Double getDailyRate(OrderInfo orderInfo) {
		// 订单进店时间
		Date checkinDate = orderInfo.getCheckinDate();
		// 订单离店时间
		Date checkoutDate = orderInfo.getCheckoutDate();
		List<JulyPrice> julyPriceList = getDays(checkinDate, checkoutDate);
		Double dailyRate = getAvePrice(julyPriceList);
		return dailyRate;
	}

	/**
	 * 
	 * @Function: SysCheckOutServiceImpl.java
	 * @Description: 计算每日平均房价 可通过AOP实现根据orderInfo的客户类型进行打折计算
	 *
	 * @param julyPriceList
	 * @return
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: 李志学
	 * @date: 2018年12月23日 上午10:41:23
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------* 2018年12月23日
	 *        李志学 v1.0.0 修改原因
	 */
	private Double getAvePrice(List<JulyPrice> julyPriceList) {
		int sum = 0;
		for (JulyPrice julyPrice : julyPriceList) {
			Integer priceStd = julyPrice.getPriceStd();
			if (IntegerUtil.isIllegality(priceStd)) {
				throw new ServiceException("日期基准价异常,日期Id:" + julyPrice.getId());
			}
			sum = sum + priceStd;
		}
		int length = julyPriceList.size();
		if (length <= 0) {
			throw new ServiceException("julyPriceList长度异常");
		}
		BigDecimal sumBig = new BigDecimal(sum);
		BigDecimal lengthBig = new BigDecimal(length);
		double avePrice = sumBig.divide(lengthBig, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return avePrice;
	}

	/**
	 * 
	 * @Function: SysCheckOutServiceImpl.java
	 * @Description: 遍历获得两个Date之间的所有julyPrice Entity
	 *
	 * @param checkinDate
	 * @param checkoutDate
	 * @return
	 * @throws：异常描述
	 *
	 * @version: v1.0.0
	 * @author: 李志学
	 * @date: 2018年12月22日 下午9:28:05
	 *
	 *        Modification History: Date Author Version Description
	 *        ---------------------------------------------------------* 2018年12月22日
	 *        李志学 v1.0.0 修改原因
	 */
	private List<JulyPrice> getDays(Date checkinDate, Date checkoutDate) {
		ArrayList<Date> daysList = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(checkoutDate);
		calendar.add(Calendar.DATE, -1);
		checkoutDate = calendar.getTime();
		JulyPriceExample julyPriceExample = new JulyPriceExample();
		julyPriceExample.or().andDayBetween(checkinDate, checkoutDate);
		List<JulyPrice> julyPrice = julyPriceMapper.selectByExample(julyPriceExample);
		return julyPrice;
	}

	@Override
	public CheckOutVoDetails checkOutDepencyOrderInfo(CheckOutVoDetails CheckOutVoDetails) {
		// TODO Auto-generated method stub
		return null;
	}

}
