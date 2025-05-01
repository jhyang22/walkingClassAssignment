package com.study.walkingclassassignment.domain.plan.dto.responsedto;

import java.time.LocalDateTime;

import com.study.walkingclassassignment.domain.plan.entity.Plan;

import lombok.Getter;

@Getter
public class PlanUpdateResponseDto {

	private final Long id;

	private final Long userId;

	private final String title;

	private final String content;

	private final LocalDateTime updatedAt;

	private PlanUpdateResponseDto(Plan plan) {
		this.id = plan.getId();
		this.userId = plan.getUser().getId();
		this.title = plan.getTitle();
		this.content = plan.getContent();
		this.updatedAt = plan.getUpdatedAt();
	}

	public static PlanUpdateResponseDto fromPlan(Plan plan) {
		return new PlanUpdateResponseDto(plan);
	}
}
