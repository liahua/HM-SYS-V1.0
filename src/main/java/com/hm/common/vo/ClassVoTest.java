package com.hm.common.vo;
import java.io.Serializable;
/**
 * VO 用于封装Checkbox相关信息
 * @author ta
 *
 */
public class ClassVoTest implements Serializable{

	private static final long serialVersionUID = -3747382113566175347L;
	/**
	 * 
	 */
	private int i;
	private int test;
	private Object object;
	

	public ClassVoTest(int i) {
		this.i=i;
	}


	public int getI() {
		return i;
	}


	public void setI(int i) {
		this.i = i;
	}


	public int getTest() {
		return test;
	}


	public void setTest(int test) {
		this.test = test;
	}


	public Object getObject() {
		return object;
	}


	public void setObject(Object object) {
		this.object = object;
	}


	@Override
	public String toString() {
		return "ClassVoTest [i=" + i + ", test=" + test + ", object=" + object + "]";
	}
	
	
	
	
	
}
