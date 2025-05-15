package com.study.walkingclassassignment.domain.plan.dto.responsedto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FindAllPlanResponseDto {

	private final Long id;

	private final Long userId;

	private final String title;

	private final String content;

	private final Long commentCount;

	private final LocalDateTime updatedAt;
}
