package com.study.walkingclassassignment.domain.comment.dto.requestdto;

import lombok.Getter;

@Getter
public class CommentCreateRequestDto {

	private final String content;

	public CommentCreateRequestDto(String content) {
		this.content = content;
	}
}
