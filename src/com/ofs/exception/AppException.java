package com.ofs.exception;

public class AppException
extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AppException(AppErrorCode e) {
		e.getMessage();
	}
	
	public AppException(Throwable cause) {
		super(cause);
	}

}