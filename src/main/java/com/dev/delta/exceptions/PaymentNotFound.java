package com.dev.delta.exceptions;

public class PaymentNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public PaymentNotFound() {
		// TODO Auto-generated constructor stub
	}

	public PaymentNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PaymentNotFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public PaymentNotFound(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PaymentNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
