package com.hm.common.vo;

import java.io.Serializable;

/**
 * 		动态房间信息
 * 		多表联查
 * @author 邹文豪
 *
 */
public class DynamicRoomInfo implements Serializable{

	private static final long serialVersionUID = 1226745637511986479L;
	private Integer id;
	
	/**
	 * 房间名字
	 */
	private String roomName;
	
	/**
	 * 房间楼层
	 */
	private String roomAdd;
	
	/**
	 * 房间床数
	 */
	private Integer bedNum;
	
	/**
	 * 房间类型
	 */
	private String rtName;
	
	/**
	 * 房间价格率
	 */
	private Float priceUp;
	
	/**
	 * 房间状态
	 */
	private String stat;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomAdd() {
		return roomAdd;
	}

	public void setRoomAdd(String roomAdd) {
		this.roomAdd = roomAdd;
	}

	public Integer getBedNum() {
		return bedNum;
	}

	public void setBedNum(Integer bedNum) {
		this.bedNum = bedNum;
	}

	public String getRtName() {
		return rtName;
	}

	public void setRtName(String rtName) {
		this.rtName = rtName;
	}

	public Float getPriceUp() {
		return priceUp;
	}

	public void setPriceUp(Float priceUp) {
		this.priceUp = priceUp;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DynamicRoomInfo [id=" + id + ", roomName=" + roomName + ", roomAdd=" + roomAdd + ", bedNum=" + bedNum
				+ ", rtName=" + rtName + ", priceUp=" + priceUp + ", stat=" + stat + "]";
	}
	
	
}
