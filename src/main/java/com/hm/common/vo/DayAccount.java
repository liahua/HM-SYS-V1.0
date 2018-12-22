package com.hm.common.vo;

import java.io.Serializable;
import java.util.List;

import com.hm.sys.entity.AccountInfo;
import com.hm.sys.entity.AccountRoom;

/**
 * 账单信息
 * 
 * @author 邹文豪
 *
 */

public class DayAccount implements Serializable {

	private static final long serialVersionUID = 6121991721354065815L;

	private List<AccountInfo> accountInfo;
	private List<AccountRoom> roomList;

	public List<AccountInfo> getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(List<AccountInfo> accountInfo) {
		this.accountInfo = accountInfo;
	}

	public List<AccountRoom> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<AccountRoom> roomList) {
		this.roomList = roomList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DayAccount [accountInfo=" + accountInfo + ", roomList=" + roomList + "]";
	}

}
