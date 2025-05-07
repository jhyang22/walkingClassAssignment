package com.study.walkingclassassignment.domain.plan.dto.responsedto;

import java.time.LocalDateTime;

import com.study.walkingclassassignment.domain.plan.entity.Plan;

import lombok.Getter;

@Getter
public class FindAllPlanResponseDto {

	private final Long id;

	private final Long userId;

	private final String title;

	private final String content;

	private final Long count;

	private final LocalDateTime updatedAt;

	private FindAllPlanResponseDto (Plan plan) {
		this.id = plan.getId();
		this.userId = plan.getUser().getId();
		this.title = plan.getTitle();
		this.content = plan.getContent();
		this.count = plan.getCommentList().stream().count(); // 모든 List에는 페이징을 적용해야 한다
		this.updatedAt = plan.getUpdatedAt();
	}

	public static FindAllPlanResponseDto fromPlan(Plan plan) {
		return new FindAllPlanResponseDto(plan);
	}
}
