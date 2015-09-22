package com.iboss.exceptions;

public class JobException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public JobException() {
		super();
	}

	public JobException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public JobException(String message, Throwable cause) {
		super(message, cause);
	}

	public JobException(String message) {
		super(message);
	}

	public JobException(Throwable cause) {
		super(cause);
	}

}
