package com.study.walkingclassassignment.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.walkingclassassignment.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
