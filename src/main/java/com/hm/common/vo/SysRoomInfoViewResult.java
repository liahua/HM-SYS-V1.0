/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.db.sys.vo 
 * @author: lord   
 * @date: Dec 22, 2018 9:12:08 PM 
 */
package com.hm.common.vo;

import java.io.Serializable;

/**   
* Copyright: Copyright (c) 2018 lord
* 
* @ClassName: SysRoomInfoViewResult.java
* @Description: 封装房间信息以及对应的价格、状态、类型
*
* @version: v1.0.0
* @author: lord
* @date: Dec 22, 2018 9:12:08 PM 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* Dec 22, 2018     lord           v1.0.0               
*/
public class SysRoomInfoViewResult implements Serializable {

	// @Fields serialVersionUID : 
	private static final long serialVersionUID = 1941601539782520671L;
	// 房间编号
    private Integer id;
    //房间号码
    private String roomName;
    //房间楼层
    private String roomAdd;
    //房间床位数
    private Integer bedNum;
    //房间类型
    private String rtName;
    //房间价格
    private Double priceUp;
    //房间状态
    private String stat;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the roomName
	 */
	public String getRoomName() {
		return roomName;
	}
	/**
	 * @param roomName the roomName to set
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	/**
	 * @return the roomAdd
	 */
	public String getRoomAdd() {
		return roomAdd;
	}
	/**
	 * @param roomAdd the roomAdd to set
	 */
	public void setRoomAdd(String roomAdd) {
		this.roomAdd = roomAdd;
	}
	/**
	 * @return the bedNum
	 */
	public Integer getBedNum() {
		return bedNum;
	}
	/**
	 * @param bedNum the bedNum to set
	 */
	public void setBedNum(Integer bedNum) {
		this.bedNum = bedNum;
	}
	/**
	 * @return the rtName
	 */
	public String getRtName() {
		return rtName;
	}
	/**
	 * @param rtName the rtName to set
	 */
	public void setRtName(String rtName) {
		this.rtName = rtName;
	}
	/**
	 * @return the priceUp
	 */
	public Double getPriceUp() {
		this.priceUp=priceUp*100;
		return priceUp;
	}
	/**
	 * @param priceUp the priceUp to set
	 */
	public void setPriceUp(Double priceUp) {
		this.priceUp = priceUp;
	}
	/**
	 * @return the stat
	 */
	public String getStat() {
		return stat;
	}
	/**
	 * @param stat the stat to set
	 */
	public void setStat(String stat) {
		this.stat = stat;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
