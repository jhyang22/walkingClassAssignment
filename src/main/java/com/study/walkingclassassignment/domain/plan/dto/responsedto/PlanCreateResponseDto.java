package com.study.walkingclassassignment.domain.plan.dto.responsedto;

import java.time.LocalDateTime;

import com.study.walkingclassassignment.domain.plan.entity.Plan;

import lombok.Getter;

@Getter
public class PlanCreateResponseDto {

	private final Long id;

	private final String title;

	private final String content;

	private final LocalDateTime createdAt;

	private PlanCreateResponseDto(Plan plan) {
		this.id = plan.getId();
		this.title = plan.getTitle();
		this.content = plan.getContent();
		this.createdAt = plan.getCreatedAt();
	}

	public static PlanCreateResponseDto fromPlan(Plan plan) {
		return new PlanCreateResponseDto(plan);
	}
}
