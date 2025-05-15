package com.study.walkingclassassignment.domain.comment.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.study.walkingclassassignment.common.exception.CustomException;
import com.study.walkingclassassignment.common.exception.ErrorCode;
import com.study.walkingclassassignment.domain.comment.dto.requestdto.CommentCreateRequestDto;
import com.study.walkingclassassignment.domain.comment.dto.requestdto.ReCommentCreateRequestDto;
import com.study.walkingclassassignment.domain.comment.dto.responsedto.CommentCreateResponseDto;
import com.study.walkingclassassignment.domain.comment.dto.responsedto.CommentDeleteResponseDto;
import com.study.walkingclassassignment.domain.comment.dto.responsedto.CommentResponseDto;
import com.study.walkingclassassignment.domain.comment.dto.requestdto.CommentUpdateRequestDto;
import com.study.walkingclassassignment.domain.comment.dto.responsedto.CommentUpdateResponseDto;
import com.study.walkingclassassignment.domain.comment.dto.responsedto.ReCommentCreateResponseDto;
import com.study.walkingclassassignment.domain.comment.entity.Comment;
import com.study.walkingclassassignment.domain.comment.repository.CommentRepository;
import com.study.walkingclassassignment.domain.plan.entity.Plan;
import com.study.walkingclassassignment.domain.plan.repository.PlanRepository;
import com.study.walkingclassassignment.domain.user.entity.User;
import com.study.walkingclassassignment.domain.user.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

	private final CommentRepository commentRepository;
	private final UserRepository userRepository;
	private final PlanRepository planRepository;

	/**
	 * 댓글 및 대댓글 생성
	 * 대댓글의 경우 1 depth가 넘어갈 경우 ONE_DEPTH_ONLY 예외처리
	 * @param planId
	 * @param dto
	 * @param loginUserId
	 * @return CommentCreateResponseDto
	 */
	@Transactional
	@Override
	public CommentCreateResponseDto saveComment(Long planId, CommentCreateRequestDto dto, Long loginUserId) {

		Plan findPlan = planRepository.findByIdOrElseThrow(planId);

		User findUserById = userRepository.findByIdOrElseThrow(loginUserId);

		Comment comment = new Comment(findUserById, findPlan, dto.getContent());

		// 대댓글
		if(dto.getCommentId() != null) {
			Comment findComment = commentRepository.findByPlan_IdAndIdOrElseThrow(planId, dto.getCommentId());

			if(findComment.getParentCommentId() != null) {
				throw new CustomException(ErrorCode.ONE_DEPTH_ONLY);
			}

			comment.specifyParentId(dto.getCommentId());

			Comment savedReComment = commentRepository.save(comment);

			return CommentCreateResponseDto.fromComment(savedReComment);
		}

		commentRepository.save(comment);

		return CommentCreateResponseDto.fromComment(comment);
	}

	/**
	 * 전체 댓글 조회
	 * 대댓글의 경우 해당 댓글의 하위에 출력된다
	 * @param planId
	 * @param loginUserId
	 * @return
	 */
	@Override
	public List<CommentResponseDto> findAll(Long planId, Long loginUserId) {

		// parentCommentId를 활용해야 할 것 같은데 어케하지
		// parentCommentId가 없으면 그냥 출력, 있으면 parentCommentId 하위에 출력?
		// 하위에 출력하는걸 어떻게 하지
		// order by를 2중으로
		// 코드 레벨에서 해결
		// Order by Created_At DESC -> Order By parentCommentId
		List<Comment> findAllComment = commentRepository.findAllByPlan_Id(planId);

		// commentId를 key, CommentResponseDto를 value로 가지는 Map 생성
		Map<Long, CommentResponseDto> commentMap = new HashMap<>();

		// commentMap에 데이터 넣는 과정
		for(Comment c : findAllComment) {
			commentMap.put(c.getId(), CommentResponseDto.fromComment(c));
		}

		// 자식들을 모두 parent에 있는 reCommentList에 삽입하는 과정
		// 만약 댓글만 삭제하고 대댓글은 존재한다면 여기서 에러가 나는 것 같다
		// 소프트 딜리트 해줘야 하나?
		for(Comment c : findAllComment) {
			if(c.getParentCommentId() != null) {
				CommentResponseDto parentDto = commentMap.get(c.getParentCommentId());
				parentDto.getReCommentList().add(CommentResponseDto.fromComment(c));
				commentMap.remove(c.getId());
			}
		}

		return commentMap.values().stream().toList();

		// 이렇게 해도 되고 ReCommentResponseDto를 만들어서 해도 된다 어차피 parentCommentId를 제일 부모 id로 지정하기 때문에 굴레에 갖히지 않는다

		// return findAllComment.stream().map(CommentResponseDto::fromComment).toList();
	}

	/**
	 * 댓글 및 대댓글 수정
	 * 수정자와 작성자가 일치하지 않을 경우 USER_MISMATCH 예외 발생
	 * @param planId
	 * @param commentId
	 * @param dto
	 * @param loginUserId
	 * @return
	 */
	@Transactional
	@Override
	public CommentUpdateResponseDto update(Long planId, Long commentId, CommentUpdateRequestDto dto, Long loginUserId) {

		Comment findComment = commentRepository.findByPlan_IdAndIdOrElseThrow(planId, commentId);

		User findUserById = userRepository.findByIdOrElseThrow(loginUserId);

		if(!findUserById.getId().equals(findComment.getUser().getId())) {
			throw new CustomException(ErrorCode.USER_MISMATCH);
		}

		findComment.update(dto);

		return CommentUpdateResponseDto.fromComment(findComment);
	}

	/**
	 * 댓글 및 대댓글 삭제
	 * 작성자가 아닐 경우 INVALID_USER 예외 발생
	 * @param planId
	 * @param commentId
	 * @param loginUserId
	 * @return
	 */
	@Transactional
	@Override
	public CommentDeleteResponseDto delete(Long planId, Long commentId, Long loginUserId) {

		User findUserById = userRepository.findByIdOrElseThrow(loginUserId);

		Comment findComment = commentRepository.findByPlan_IdAndIdOrElseThrow(planId, commentId);

		if(!findComment.getUser().equals(findUserById)) {
			throw new CustomException(ErrorCode.INVALID_USER);
		}

		findComment.deleteComment();

		return CommentDeleteResponseDto.fromComment(findComment);
	}
}
