package com.study.walkingclassassignment.domain.comment.dto.requestdto;

import lombok.Getter;

@Getter
public class CommentUpdateRequestDto {

	private final String content;

	public CommentUpdateRequestDto(String content) {
		this.content = content;
	}
}
