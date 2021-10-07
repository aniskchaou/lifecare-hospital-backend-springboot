package com.dev.delta.exceptions;

public class NurseNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public NurseNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public NurseNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NurseNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NurseNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NurseNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
