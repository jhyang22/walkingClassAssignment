package com.study.walkingclassassignment.domain.comment.dto.requestdto;

import lombok.Getter;

@Getter
public class ReCommentCreateRequestDto {

	private final String content;

	public ReCommentCreateRequestDto(String content) {
		this.content = content;
	}
}
