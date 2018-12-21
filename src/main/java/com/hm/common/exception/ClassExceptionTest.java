package com.hm.common.exception;

/**
 * 自定义异常(继承RuntimeException或者Exception)
 * 为什么自定义异常?
 * 1)能够更好对异常信息进行理解和定位
 * 2)提高处理异常的速度和质量
 * 
 * @author tarena
 *
 */
public class ClassExceptionTest extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4128212794713955236L;

	public ClassExceptionTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassExceptionTest(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ClassExceptionTest(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ClassExceptionTest(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ClassExceptionTest(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


}
