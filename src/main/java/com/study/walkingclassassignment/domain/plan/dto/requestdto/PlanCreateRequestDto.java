package com.study.walkingclassassignment.domain.plan.dto.requestdto;

import lombok.Getter;

@Getter
public class PlanCreateRequestDto {

	private final String title;

	private final String content;

	public PlanCreateRequestDto(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
