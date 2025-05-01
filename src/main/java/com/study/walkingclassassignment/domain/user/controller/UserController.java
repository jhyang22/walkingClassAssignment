package com.study.walkingclassassignment.domain.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.walkingclassassignment.common.filter.Const;
import com.study.walkingclassassignment.domain.user.dto.UserLoginRequestDto;
import com.study.walkingclassassignment.domain.user.dto.UserResponseDto;
import com.study.walkingclassassignment.domain.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@PostMapping("/signin")
	public ResponseEntity<UserResponseDto> signin() {

		UserResponseDto createdUser = userService.createUser();

		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(
		@RequestBody UserLoginRequestDto dto,
		HttpServletRequest request
	) {

		Long loginUserId = userService.login(dto);

		HttpSession session = request.getSession();
		session.setAttribute(Const.LOGIN_USER, loginUserId);

		return new ResponseEntity<>("로그인 되었습니다.", HttpStatus.OK);
	}
}
