package com.study.walkingclassassignment.domain.comment.dto.responsedto;

import java.time.LocalDateTime;

import com.study.walkingclassassignment.domain.comment.entity.Comment;

import lombok.Getter;

@Getter
public class ReCommentCreateResponseDto {

	private final Long planId;

	private final Long userId;

	private final Long parentCommentId;

	private final Long commentId;

	private final String content;

	private final LocalDateTime createdAt;

	private ReCommentCreateResponseDto (Comment comment) {
		this.planId = comment.getPlan().getId();
		this.userId = comment.getUser().getId();
		this.parentCommentId = comment.getParentCommentId();
		this.commentId = comment.getId();
		this.content = comment.getContent();
		this.createdAt = comment.getCreatedAt();
	}

	public static ReCommentCreateResponseDto fromComment (Comment comment) {
		return new ReCommentCreateResponseDto(comment);
	}
}
