package com.study.walkingclassassignment.domain.plan.dto.requestdto;

import lombok.Getter;

@Getter
public class PlanUpdateRequestDto {

	private final String title;

	private final String content;

	public PlanUpdateRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
