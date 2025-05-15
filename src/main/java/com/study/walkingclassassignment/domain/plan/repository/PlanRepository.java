package com.study.walkingclassassignment.domain.plan.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.study.walkingclassassignment.common.exception.CustomException;
import com.study.walkingclassassignment.common.exception.ErrorCode;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.FindAllPlanResponseDto;
import com.study.walkingclassassignment.domain.plan.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

	default Plan findByIdOrElseThrow(Long planId) {
		return findById(planId).orElseThrow(() -> new CustomException(ErrorCode.PLAN_NOT_FOUND));
	}

	Plan findByUserId(Long id);

	Page<Plan> findAll(Pageable pageable);

	@EntityGraph(attributePaths = "user")
	@Query("SELECT new com.study.walkingclassassignment.domain.plan.dto.responsedto.FindAllPlanResponseDto(p.id, p.user.id, p.title, p.content, COUNT(c), p.updatedAt) "
		+ "FROM Plan p LEFT JOIN p.commentList c JOIN p.user u "
		+ "GROUP BY p.id, p.user.id, p.title, p.content, p.updatedAt")
	Page<FindAllPlanResponseDto> findAllPlanWithCountComment(Pageable pageable);
}
