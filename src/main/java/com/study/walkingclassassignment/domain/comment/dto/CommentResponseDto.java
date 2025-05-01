package com.study.walkingclassassignment.domain.comment.dto;

import com.study.walkingclassassignment.domain.comment.entity.Comment;

import lombok.Getter;

@Getter
public class CommentResponseDto {

	private final Long id;

	private final Long userId;

	private final String content;

	private CommentResponseDto(Comment comment) {
		this.id = comment.getId();
		this.userId = comment.getUser().getId();
		this.content = comment.getContent();
	}

	public static CommentResponseDto fromComment(Comment comment) {
		return new CommentResponseDto(comment);
	}
}
