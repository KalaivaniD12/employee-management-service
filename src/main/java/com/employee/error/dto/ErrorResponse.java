package com.employee.error.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 1731412635485355870L;

	private String errorCode;

	private String errorDescription;

	private LocalDateTime timestamp;

	public ErrorResponse(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.timestamp = LocalDateTime.now();
	}

}
