package com.study.walkingclassassignment.domain.comment.dto.responsedto;

import java.time.LocalDateTime;

import com.study.walkingclassassignment.domain.comment.entity.Comment;

import lombok.Getter;

@Getter
public class CommentUpdateResponseDto {

	private final Long planId;

	private final Long userId;

	private final Long id;

	private final String content;

	private final LocalDateTime updatedAt;

	private CommentUpdateResponseDto(Comment comment) {
		this.planId = comment.getPlan().getId();
		this.userId = comment.getUser().getId();
		this.id = comment.getId();
		this.content = comment.getContent();
		this.updatedAt = comment.getUpdatedAt();
	}

	public static CommentUpdateResponseDto fromComment(Comment comment) {
		return new CommentUpdateResponseDto(comment);
	}
}
