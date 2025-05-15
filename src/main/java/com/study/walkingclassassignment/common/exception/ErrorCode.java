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
	PLAN_NOT_FOUND(404, "Not Found", "P001", "일정이 없습니다."),


	// Comment
	COMMENT_NOT_FOUND(404, "Not Found", "C001", "댓글이 없습니다."),
	USER_MISMATCH(400, "Bad Request", "C002", "작성자와 수정자가 일치하지 않습니다."),
	INVALID_USER(400, "Bad Request", "C003", "작성자만 삭제가 가능합니다."),
	ONE_DEPTH_ONLY(400, "Bad Request", "C004", "대댓글은 1 depth만 가능합니다.");



	private final int status;
	private final String error;
	private final String code;
	private final String message;
}
