package com.study.walkingclassassignment.domain.plan.service;

import java.util.List;

import com.study.walkingclassassignment.domain.plan.dto.requestdto.PlanCreateRequestDto;
import com.study.walkingclassassignment.domain.plan.dto.requestdto.PlanUpdateRequestDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.FindAllPlanResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanCreateResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanDeleteResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanUpdateResponseDto;
import com.study.walkingclassassignment.domain.user.dto.UserResponseDto;

public interface PlanService {
	PlanCreateResponseDto savePlan(PlanCreateRequestDto dto, UserResponseDto loginUser);

	List<FindAllPlanResponseDto> findAll(UserResponseDto loginUser);

	PlanResponseDto findById(Long planId, UserResponseDto loginUser);

	PlanUpdateResponseDto updatePlan(Long planId, PlanUpdateRequestDto dto, UserResponseDto loginUser);

	PlanDeleteResponseDto deletePlan(Long planId, UserResponseDto loginUser);
}
