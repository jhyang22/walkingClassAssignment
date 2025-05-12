package com.study.walkingclassassignment.domain.comment.entity;

import com.study.walkingclassassignment.common.entity.BaseEntity;
import com.study.walkingclassassignment.domain.comment.dto.requestdto.CommentUpdateRequestDto;
import com.study.walkingclassassignment.domain.plan.entity.Plan;
import com.study.walkingclassassignment.domain.user.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comment")
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plan_id", nullable = false)
	private Plan plan;

	private String content;

	private Long parentCommentId;

	public Comment(User user, Plan plan, String content) {
		this.user = user;
		this.plan = plan;
		this.content = content;
	}

	/**
	 * 댓글 수정을 위한 메서드
	 * @param dto
	 */
	public void update(CommentUpdateRequestDto dto) {
		this.content = dto.getContent();
	}

	/**
	 * 부모 댓글 id를 지정해주기 위한 메서드
	 * @param id
	 */
	public void specifyParentId (Long id) {
		this.parentCommentId = id;
	}
}
