package com.study.walkingclassassignment.domain.user.dto;

import lombok.Getter;

@Getter
public class UserLoginRequestDto {

	private final Long id;

	public UserLoginRequestDto(Long id) {
		this.id = id;
	}
}
