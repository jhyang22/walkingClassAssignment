package com.study.walkingclassassignment.common.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime timestamp = LocalDateTime.now();
	private final int status;
	private final String error;
	private final String code;
	private final String message;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private final List<FieldError> fieldErrors;

	public static ErrorResponse of(ErrorCode errorCode) {
		return ErrorResponse.builder()
			.status(errorCode.getStatus())
			.error(errorCode.getError())
			.code(errorCode.getCode())
			.message(errorCode.getMessage())
			.fieldErrors(new ArrayList<>())
			.build();
	}

	public static ErrorResponse of(ErrorCode errorCode, String message) {
		return ErrorResponse.builder()
			.status(errorCode.getStatus())
			.error(errorCode.getError())
			.code(errorCode.getCode())
			.message(message)
			.fieldErrors(new ArrayList<>())
			.build();
	}
}
