package com.hm.sys.service;

import com.hm.common.vo.CheckOutVoDetails;

public interface SysCheckOutService {

	

	/**
	 * 
	 * @param CheckOutVoDetails 应包含RooNameId以及CustomerInfo
	 * @return
	 */
	CheckOutVoDetails checkOutDepencyRoomNameIdCustomerInfo(CheckOutVoDetails CheckOutVoDetails);
	CheckOutVoDetails checkOutDepencyOrderInfo(CheckOutVoDetails CheckOutVoDetails);

}
