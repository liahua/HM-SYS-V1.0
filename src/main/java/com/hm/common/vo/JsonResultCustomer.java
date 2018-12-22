package com.hm.common.vo;

import java.io.Serializable;

public class JsonResultCustomer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1355028454387003335L;
	/**状态码*/
    private int state=1;//1-OK,0-Error
    /**状态码对应的消息*/
    private String message="OK";
    /**要呈现到客户端的业务数据*/
    private Object data;
    public JsonResultCustomer() {
	 }
    public JsonResultCustomer(String message) {
   	 this.message=message;
	 }
    public JsonResultCustomer(Object data) {
   	 this.data=data;
    }
    public JsonResultCustomer(Throwable e) {
   	 this.state=0;
   	 this.message=e.getMessage();
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
}
