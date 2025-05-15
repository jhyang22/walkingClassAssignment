package com.study.walkingclassassignment.domain.comment.dto.responsedto;

import java.time.LocalDateTime;

import com.study.walkingclassassignment.domain.comment.entity.Comment;

import lombok.Getter;

@Getter
public class CommentCreateResponseDto {

	private final Long planId;

	private final Long userId;

	private final Long id;

	private final String content;

	private final LocalDateTime createdAt;

	private CommentCreateResponseDto (Comment comment) {
		this.planId = comment.getPlan().getId();
		this.userId = comment.getUser().getId();
		this.id = comment.getId();
		this.content = comment.getContent();
		this.createdAt = comment.getCreatedAt();
	}

	public static CommentCreateResponseDto fromComment (Comment comment) {
		return new CommentCreateResponseDto(comment);
	}
}
