package com.study.walkingclassassignment.domain.plan.dto.responsedto;

import com.study.walkingclassassignment.domain.plan.entity.Plan;

import lombok.Getter;

@Getter
public class PlanDeleteResponseDto {

	private final Long planId;

	private final Long userId;

	private final String title;

	private PlanDeleteResponseDto(Plan plan) {
		this.planId = plan.getId();
		this.userId = plan.getUser().getId();
		this.title = plan.getTitle();
	}

	public static PlanDeleteResponseDto fromPlan(Plan plan) {
		return new PlanDeleteResponseDto(plan);
	}
}
