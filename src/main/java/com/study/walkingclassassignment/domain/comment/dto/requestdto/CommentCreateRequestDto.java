package com.study.walkingclassassignment.domain.comment.dto.requestdto;

import lombok.Getter;

@Getter
public class CommentCreateRequestDto {

	private final Long commentId;

	private final String content;

	public CommentCreateRequestDto(Long commentId, String content) {
		this.commentId = commentId;
		this.content = content;
	}
}
