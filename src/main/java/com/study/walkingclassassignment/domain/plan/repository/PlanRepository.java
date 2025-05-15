package com.study.walkingclassassignment.domain.plan.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.study.walkingclassassignment.common.exception.CustomException;
import com.study.walkingclassassignment.common.exception.ErrorCode;
import com.study.walkingclassassignment.domain.plan.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

	default Plan findByIdOrElseThrow(Long planId) {
		return findById(planId).orElseThrow(() -> new CustomException(ErrorCode.PLAN_NOT_FOUND));
	}

	Plan findByUserId(Long id);

	Page<Plan> findAll(Pageable pageable);
}
