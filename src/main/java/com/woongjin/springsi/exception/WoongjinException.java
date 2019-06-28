package com.woongjin.springsi.exception;

public class WoongjinException extends RuntimeException {
	
	public WoongjinException() {
		super();
	}
	
	public WoongjinException(Exception e) {
		super(e);
	}

	public WoongjinException(String msg) {
		super(msg);
	}
	
	public WoongjinException(String msg, Exception e) {
		super(msg, e);
	}
}
