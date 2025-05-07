package com.study.walkingclassassignment.domain.plan.dto.responsedto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.study.walkingclassassignment.domain.comment.dto.responsedto.CommentResponseDto;
import com.study.walkingclassassignment.domain.plan.entity.Plan;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PlanResponseDto {

	private final Long id;

	private final Long userId;

	private final String title;

	private final String content;

	private final LocalDateTime updatedAt;

	private final List<CommentResponseDto> commentList;

	@Builder
	private PlanResponseDto(Long id, Long userId, String title, String content, LocalDateTime updatedAt,
		List<CommentResponseDto> commentList) {
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.updatedAt = updatedAt;
		this.commentList = commentList;
	}

	public static PlanResponseDto fromPlan (Plan plan) {
		return PlanResponseDto.builder()
			.id(plan.getId())
			.userId(plan.getUser().getId())
			.title(plan.getTitle())
			.content(plan.getContent())
			.updatedAt(plan.getUpdatedAt())
			.commentList(plan.getCommentList().stream()
				.map(CommentResponseDto::fromComment)
				.collect(Collectors.toList()))
			.build();
	}

}
