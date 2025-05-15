package com.study.walkingclassassignment.domain.comment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.study.walkingclassassignment.common.filter.Const;
import com.study.walkingclassassignment.domain.comment.dto.requestdto.CommentCreateRequestDto;
import com.study.walkingclassassignment.domain.comment.dto.responsedto.CommentCreateResponseDto;
import com.study.walkingclassassignment.domain.comment.dto.responsedto.CommentDeleteResponseDto;
import com.study.walkingclassassignment.domain.comment.dto.responsedto.CommentResponseDto;
import com.study.walkingclassassignment.domain.comment.dto.requestdto.CommentUpdateRequestDto;
import com.study.walkingclassassignment.domain.comment.dto.responsedto.CommentUpdateResponseDto;
import com.study.walkingclassassignment.domain.comment.service.CommentService;

import lombok.RequiredArgsConstructor;

//TODO URL 수정으로 인한 PathVariable 추가 사항 반영해서 로직 다시 만들어야함
@RestController
@RequestMapping("/api/plans/{planId}/comments")
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	/**
	 * 댓글 생성
	 * @param planId
	 * @param dto
	 * @param loginUserId
	 * @return
	 */
	@PostMapping
	public ResponseEntity<CommentCreateResponseDto> saveComment(
		@PathVariable Long planId,
		@RequestBody CommentCreateRequestDto dto,
		@SessionAttribute(name = Const.LOGIN_USER, required = false) Long loginUserId
	) {
		CommentCreateResponseDto savedComment = commentService.saveComment(planId, dto, loginUserId);

		return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
	}

	/**
	 * 전체 댓글 조회
	 * 대댓글의 경우 해당 댓글의 하위에 출력된다
	 * @param planId
	 * @param loginUserId
	 * @return List<CommentResponseDto>
	 */
	@GetMapping
	public ResponseEntity<List<CommentResponseDto>> findAll(
		@PathVariable Long planId,
		@SessionAttribute(name = Const.LOGIN_USER, required = false) Long loginUserId
	) {
		List<CommentResponseDto> findAllComment = commentService.findAll(planId, loginUserId);

		return new ResponseEntity<>(findAllComment, HttpStatus.OK);
	}

	/**
	 * 댓글 및 대댓글 수정
	 * @param planId
	 * @param commentId
	 * @param dto
	 * @param loginUserId
	 * @return CommentUpdateResponseDto
	 */
	@PatchMapping("/{commentId}")
	public ResponseEntity<CommentUpdateResponseDto> updateComment(
		@PathVariable Long planId,
		@PathVariable Long commentId,
		@RequestBody CommentUpdateRequestDto dto,
		@SessionAttribute(name = Const.LOGIN_USER, required = false) Long loginUserId
	) {

		CommentUpdateResponseDto updatedComment = commentService.update(planId, commentId, dto, loginUserId);

		return new ResponseEntity<>(updatedComment, HttpStatus.OK);
	}

	/**
	 * 댓글 및 대댓글 삭제
	 * @param planId
	 * @param commentId
	 * @param loginUserId
	 * @return CommentDeleteResponseDto
	 */
	@DeleteMapping("/{commentId}")
	public ResponseEntity<CommentDeleteResponseDto> deleteComment(
		@PathVariable Long planId,
		@PathVariable Long commentId,
		@SessionAttribute(name = Const.LOGIN_USER, required = false) Long loginUserId
	) {

		CommentDeleteResponseDto deletedComment = commentService.delete(planId, commentId, loginUserId);

		return new ResponseEntity<>(deletedComment, HttpStatus.OK);
	}
}
