package com.study.walkingclassassignment.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	// Common
	NEED_LOGIN(400, "Bad Request", "F001", "로그인이 필요합니다."),


	// User
	USER_NOT_FOUND(404, "Not Found", "U001", "유저가 없습니다."),


	// Plan
	PLAN_NOT_FOUND(404, "Not Found", "P001", "일정이 없습니다");



	private final int status;
	private final String error;
	private final String code;
	private final String message;
}
