package com.study.walkingclassassignment.domain.plan.dto.responsedto;

import java.time.LocalDateTime;

import com.study.walkingclassassignment.domain.plan.entity.Plan;

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

	// private FindAllPlanResponseDto (Plan plan, Long commentCount) {
	// 	this.id = plan.getId();
	// 	this.userId = plan.getUser().getId();
	// 	this.title = plan.getTitle();
	// 	this.content = plan.getContent();
	// 	// this.commentCount = plan.getCommentList().stream().count(); // 모든 List에는 페이징을 적용해야 한다
	// 	this.commentCount = commentCount;
	// 	this.updatedAt = plan.getUpdatedAt();
	// }
	//
	// public static FindAllPlanResponseDto fromPlan(Plan plan, Long commentCount) {
	// 	return new FindAllPlanResponseDto(plan, commentCount);
	// }
}
