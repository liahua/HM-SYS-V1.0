package com.hm.common.vo;

import java.io.Serializable;

public class JsonResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7746971523919492297L;
	/**
	 * 状态码
	 */
	private int state=1;
	/**
	 * 状态码对应的消息
	 */
	private String message;
	/**
	 * 要呈现到客户端的业务数据
	 */
	private Object data;

	public JsonResult(String message) {
		this.message = message;
	}

	public JsonResult() {

	}

	public JsonResult(Object data) {
		this.data = data;
	}

	public JsonResult(Throwable ex) {
		this.state = 0;
		this.message = ex.getMessage();
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
