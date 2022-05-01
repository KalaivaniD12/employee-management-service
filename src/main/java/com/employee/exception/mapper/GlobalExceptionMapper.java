package com.employee.exception.mapper;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employee.error.dto.ErrorResponse;
import com.employee.exception.ApplicationException;
import com.employee.exception.BusinessException;

@ControllerAdvice
public class GlobalExceptionMapper extends ResponseEntityExceptionHandler {

	@ExceptionHandler()
	public ResponseEntity<ErrorResponse> handleAllException(Exception ex) {
		ErrorResponse error;
		HttpStatus status;

		if (ex instanceof ApplicationException) {
			status = HttpStatus.BAD_REQUEST;
			error = new ErrorResponse(((ApplicationException) ex).getErrorCode(),
					((ApplicationException) ex).getMessage());
		} else if (ex instanceof BusinessException) {
			status = HttpStatus.BAD_REQUEST;
			error = new ErrorResponse(((BusinessException) ex).getErrorCode(), ((BusinessException) ex).getMessage());
		} else {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			error = new ErrorResponse("500", "Some unknown error occured");
		}

		error.setTimestamp(LocalDateTime.now());

		return ResponseEntity.status(status).body(error);

	}
}
