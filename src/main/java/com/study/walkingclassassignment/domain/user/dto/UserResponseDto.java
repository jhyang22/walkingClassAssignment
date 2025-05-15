package com.study.walkingclassassignment.domain.user.dto;

import com.study.walkingclassassignment.domain.user.entity.User;

import lombok.Getter;

@Getter
public class UserResponseDto {

	private final Long id;

	public UserResponseDto(User user) {
		this.id = user.getId();
	}
}
