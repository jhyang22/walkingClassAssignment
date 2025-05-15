package com.study.walkingclassassignment.domain.plan.entity;

import java.util.ArrayList;
import java.util.List;

import com.study.walkingclassassignment.common.entity.BaseEntity;
import com.study.walkingclassassignment.domain.comment.entity.Comment;
import com.study.walkingclassassignment.domain.plan.dto.requestdto.PlanUpdateRequestDto;
import com.study.walkingclassassignment.domain.user.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Plan extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	private String title;

	private String content;

	@OneToMany(mappedBy = "plan")
	private List<Comment> commentList = new ArrayList<>();

	public Plan(User user, String title, String content) {
		this.user = user;
		this.title = title;
		this.content = content;
	}

	/**
	 * 일정 수정을 위한 메서드
	 * @param dto
	 */
	public void update(PlanUpdateRequestDto dto) {
		this.title = dto.getTitle();
		this.content = dto.getContent();
	}
}
