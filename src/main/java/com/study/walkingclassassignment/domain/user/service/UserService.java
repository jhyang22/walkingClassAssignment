package com.study.walkingclassassignment.domain.user.service;

import org.springframework.stereotype.Service;

import com.study.walkingclassassignment.domain.user.dto.UserResponseDto;
import com.study.walkingclassassignment.domain.user.entity.User;
import com.study.walkingclassassignment.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public UserResponseDto createUser() {

		User user = new User();

		User savedUser = userRepository.save(user);

		return new UserResponseDto(savedUser);
	}
}
