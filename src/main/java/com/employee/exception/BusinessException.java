package com.employee.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BusinessException extends Exception {

	private static final long serialVersionUID = -8114822168718945389L;

	private String errorCode;

	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;

	}

	public BusinessException(String message) {
		super(message);

	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

}
