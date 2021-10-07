package com.dev.delta.exceptions;

public class DriverNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public DriverNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public DriverNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DriverNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DriverNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DriverNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
