package com.dev.delta.exceptions;

public class EmployeeNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public EmployeeNotFound() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotFound(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
