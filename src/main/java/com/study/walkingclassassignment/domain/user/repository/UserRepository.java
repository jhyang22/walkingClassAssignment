package com.study.walkingclassassignment.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.walkingclassassignment.common.exception.CustomException;
import com.study.walkingclassassignment.common.exception.ErrorCode;
import com.study.walkingclassassignment.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	default User findByIdOrElseThrow(Long id) {
		return findById(id).orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
	}
}
