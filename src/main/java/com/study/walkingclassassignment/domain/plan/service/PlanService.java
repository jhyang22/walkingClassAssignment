package com.study.walkingclassassignment.domain.plan.service;

import java.util.List;

import com.study.walkingclassassignment.domain.plan.dto.requestdto.PlanCreateRequestDto;
import com.study.walkingclassassignment.domain.plan.dto.requestdto.PlanUpdateRequestDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.FindAllPlanResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanCreateResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanDeleteResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanUpdateResponseDto;

public interface PlanService {
	PlanCreateResponseDto savePlan(PlanCreateRequestDto dto, Long loginUserId);

	List<FindAllPlanResponseDto> findAll(Long loginUserId);

	PlanResponseDto findById(Long planId, Long loginUserId);

	PlanUpdateResponseDto updatePlan(Long planId, PlanUpdateRequestDto dto, Long loginUserId);

	PlanDeleteResponseDto deletePlan(Long planId, Long loginUserId);
}
