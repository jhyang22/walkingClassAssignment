package com.study.walkingclassassignment.domain.comment.dto.responsedto;

import com.study.walkingclassassignment.domain.comment.entity.Comment;

import lombok.Getter;

@Getter
public class CommentDeleteResponseDto {

	private final Long planId;

	private final Long userId;

	private final Long id;

	private final String content;

	private CommentDeleteResponseDto(Comment comment) {
		this.planId = comment.getPlan().getId();
		this.userId = comment.getUser().getId();
		this.id = comment.getId();
		this.content = comment.getContent();
	}

	public static CommentDeleteResponseDto fromComment(Comment comment) {
		return new CommentDeleteResponseDto(comment);
	}
}
