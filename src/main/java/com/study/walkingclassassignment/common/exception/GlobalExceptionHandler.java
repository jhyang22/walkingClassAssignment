package com.study.walkingclassassignment.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
		log.error("CustomException: {}", e.getMessage());
		ErrorCode errorCode = e.getErrorCode;
		ErrorResponse response = ErrorResponse.of(errorCode, e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
	}
}
