package com.study.walkingclassassignment.domain.plan.controller;

import static org.springframework.data.domain.Sort.Direction.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import com.study.walkingclassassignment.domain.plan.dto.requestdto.PlanCreateRequestDto;
import com.study.walkingclassassignment.domain.plan.dto.requestdto.PlanUpdateRequestDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.FindAllPlanResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanCreateResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanDeleteResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanUpdateResponseDto;
import com.study.walkingclassassignment.domain.plan.service.PlanService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/plans")
@RequiredArgsConstructor
public class PlanController {

	private final PlanService planService;

	/**
	 * 일정 저장
	 * @param dto
	 * @param loginUserId
	 * @return PlanCreateResponseDto
	 */
	@PostMapping
	public ResponseEntity<PlanCreateResponseDto> savePlan(
		@RequestBody PlanCreateRequestDto dto,
		@SessionAttribute(name = Const.LOGIN_USER, required = false) Long loginUserId
	) {
		PlanCreateResponseDto savedPlan = planService.savePlan(dto, loginUserId);

		return new ResponseEntity<>(savedPlan, HttpStatus.CREATED);
	}

	/**
	 * 전체 일정 조회
	 * 댓글 개수도 함께 조회된다.
	 * @param loginUserId
	 * @return List<FindAllPlanResponseDto>
	 */
	@GetMapping
	public ResponseEntity<Page<FindAllPlanResponseDto>> findAll(
		@PageableDefault(size = 10, direction = DESC) Pageable pageable,
		@SessionAttribute(name = Const.LOGIN_USER, required = false) Long loginUserId
	) {
		Page<FindAllPlanResponseDto> findAllPlan = planService.findAll(pageable, loginUserId);

		return new ResponseEntity<>(findAllPlan, HttpStatus.OK);
	}

	/**
	 * 단일 일정 조회
	 * 댓글 리스트 함께 출력
	 * @param planId
	 * @param loginUserId
	 * @return PlanResponseDto
	 */
	@GetMapping("/{planId}")
	public ResponseEntity<PlanResponseDto> findById(
		@PathVariable Long planId,
		@SessionAttribute(name = Const.LOGIN_USER, required = false) Long loginUserId
	) {
		PlanResponseDto findPlanById = planService.findById(planId, loginUserId);

		return new ResponseEntity<>(findPlanById, HttpStatus.OK);
	}

	/**
	 * 일정 수정
	 * @param planId
	 * @param dto
	 * @param loginUserId
	 * @return
	 */
	@PatchMapping("/{planId}")
	public ResponseEntity<PlanUpdateResponseDto> updatePlan(
		@PathVariable Long planId,
		@RequestBody PlanUpdateRequestDto dto,
		@SessionAttribute(name = Const.LOGIN_USER, required = false) Long loginUserId
	) {
		PlanUpdateResponseDto updatedPlan = planService.updatePlan(planId, dto, loginUserId);

		return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
	}

	/**
	 * 일정 삭제
	 * @param planId
	 * @param loginUserId
	 * @return
	 */
	@DeleteMapping("/{planId}")
	public ResponseEntity<PlanDeleteResponseDto> deletePlan(
		@PathVariable Long planId,
		@SessionAttribute(name = Const.LOGIN_USER, required = false) Long loginUserId
	) {

		PlanDeleteResponseDto deletedPlan = planService.deletePlan(planId, loginUserId);

		return new ResponseEntity<>(deletedPlan, HttpStatus.OK);
	}
}
