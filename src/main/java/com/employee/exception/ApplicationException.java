package com.employee.exception;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 5834308350207716130L;

	private String errorCode;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

}
