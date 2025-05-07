package com.study.walkingclassassignment.domain.comment.dto.responsedto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.study.walkingclassassignment.domain.comment.entity.Comment;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentResponseDto {

	private final Long id;

	private final Long userId;

	private final String content;

	private final List<CommentResponseDto> reCommentList;

	@Builder
	private CommentResponseDto(Long id, Long userId, String content, List<CommentResponseDto> reCommentList) {
		this.id = id;
		this.userId = userId;
		this.content = content;
		this.reCommentList = reCommentList;
	}

	// public static CommentResponseDto fromComment(Comment comment, List<Comment> reCommentList) {
	// 	return CommentResponseDto.builder()
	// 		.id(comment.getId())
	// 		.userId(comment.getUser().getId())
	// 		.content(comment.getContent())
	// 		.reCommentList(reCommentList.stream()
	// 			.filter(c -> c.getParentCommentId() != null)
	// 			.filter(c -> c.getParentCommentId().equals(comment.getId()))
	// 			.toList())
	// 		.build();
	// }

	public static CommentResponseDto fromComment(Comment comment) {
		return CommentResponseDto.builder()
			.id(comment.getId())
			.userId(comment.getUser().getId())
			.content(comment.getContent())
			.reCommentList(new ArrayList<>())
			.build();
	}
}
