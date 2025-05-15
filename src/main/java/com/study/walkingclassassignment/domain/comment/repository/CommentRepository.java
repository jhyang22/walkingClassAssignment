package com.study.walkingclassassignment.domain.comment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.study.walkingclassassignment.common.exception.CustomException;
import com.study.walkingclassassignment.common.exception.ErrorCode;
import com.study.walkingclassassignment.domain.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	default Comment findByIdOrElseThrow(Long id) {
		return findById(id).orElseThrow(() -> new CustomException(ErrorCode.COMMENT_NOT_FOUND));
	}

	Optional<Comment> findByPlan_IdAndId(Long planId, Long id);

	@EntityGraph(attributePaths = {"user", "plan"})
	default Comment findByPlan_IdAndIdOrElseThrow(Long planId, Long id) {
		return findByPlan_IdAndId(planId, id).orElseThrow(() -> new CustomException(ErrorCode.COMMENT_NOT_FOUND));
	}

	List<Comment> findAllByPlan_Id(Long planId);
}
