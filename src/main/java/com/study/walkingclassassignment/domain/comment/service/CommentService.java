package com.study.walkingclassassignment.domain.comment.service;

import java.util.List;

import com.study.walkingclassassignment.domain.comment.dto.requestdto.CommentCreateRequestDto;
import com.study.walkingclassassignment.domain.comment.dto.requestdto.ReCommentCreateRequestDto;
import com.study.walkingclassassignment.domain.comment.dto.responsedto.CommentCreateResponseDto;
import com.study.walkingclassassignment.domain.comment.dto.responsedto.CommentDeleteResponseDto;
import com.study.walkingclassassignment.domain.comment.dto.responsedto.CommentResponseDto;
import com.study.walkingclassassignment.domain.comment.dto.requestdto.CommentUpdateRequestDto;
import com.study.walkingclassassignment.domain.comment.dto.responsedto.CommentUpdateResponseDto;
import com.study.walkingclassassignment.domain.comment.dto.responsedto.ReCommentCreateResponseDto;

public interface CommentService {
	CommentCreateResponseDto saveComment(Long planId, CommentCreateRequestDto dto, Long loginUserId);

	List<CommentResponseDto> findAll(Long planId, Long loginUserId);

	CommentUpdateResponseDto update(Long planId, Long commentId, CommentUpdateRequestDto dto, Long loginUserId);

	CommentDeleteResponseDto delete(Long planId, Long commentId, Long loginUserId);

	ReCommentCreateResponseDto saveReComment(Long PlanId, Long commentId, ReCommentCreateRequestDto dto, Long loginUserId);
}
