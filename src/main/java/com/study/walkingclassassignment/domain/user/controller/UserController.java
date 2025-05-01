package com.study.walkingclassassignment.domain.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.walkingclassassignment.domain.user.dto.UserResponseDto;
import com.study.walkingclassassignment.domain.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<UserResponseDto> createUser() {

		UserResponseDto createdUser = userService.createUser();

		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}
}
