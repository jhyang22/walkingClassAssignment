package com.study.walkingclassassignment.domain.plan.controller;

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
import com.study.walkingclassassignment.domain.plan.dto.requestdto.PlanCreateRequestDto;
import com.study.walkingclassassignment.domain.plan.dto.requestdto.PlanUpdateRequestDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.FindAllPlanResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanCreateResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanDeleteResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanUpdateResponseDto;
import com.study.walkingclassassignment.domain.plan.service.PlanService;
import com.study.walkingclassassignment.domain.user.dto.UserResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/plans")
@RequiredArgsConstructor
public class PlanController {

	private final PlanService planService;

	/**
	 * 일정 저장
	 * @param dto
	 * @param loginUser
	 * @return PlanCreateResponseDto
	 */
	@PostMapping
	public ResponseEntity<PlanCreateResponseDto> savePlan(
		@RequestBody PlanCreateRequestDto dto,
		@SessionAttribute(name = Const.LOGIN_USER, required = false) UserResponseDto loginUser
	) {
		PlanCreateResponseDto savedPlan = planService.savePlan(dto, loginUser);

		return new ResponseEntity<>(savedPlan, HttpStatus.CREATED);
	}

	/**
	 * 전체 일정 조회
	 * TODO loginUser는 어디에 쓰지..? -> planId로 가져온 정보랑 loginUser id랑 같은지 비교하려고 쓰나?
	 * @param loginUser
	 * @return List<FindAllPlanResponseDto>
	 */
	@GetMapping
	public ResponseEntity<List<FindAllPlanResponseDto>> findAll(
		@SessionAttribute(name = Const.LOGIN_USER, required = false) UserResponseDto loginUser
	) {
		List<FindAllPlanResponseDto> findAllPlan = planService.findAll(loginUser);

		return new ResponseEntity<>(findAllPlan, HttpStatus.OK);
	}

	/**
	 * 단일 일정 조회
	 * 댓글 리스트 함께 출력
	 * @param planId
	 * @param loginUser
	 * @return PlanResponseDto
	 */
	@GetMapping("/{planId}")
	public ResponseEntity<PlanResponseDto> findById(
		@PathVariable Long planId,
		@SessionAttribute(name = Const.LOGIN_USER, required = false) UserResponseDto loginUser
	) {
		PlanResponseDto findPlanById = planService.findById(planId, loginUser);

		return new ResponseEntity<>(findPlanById, HttpStatus.OK);
	}

	/**
	 * 일정 수정
	 * TODO loginUser는 어디에 쓰지..?
	 * @param planId
	 * @param dto
	 * @param loginUser
	 * @return
	 */
	@PatchMapping("/{planId}")
	public ResponseEntity<PlanUpdateResponseDto> updatePlan(
		@PathVariable Long planId,
		@RequestBody PlanUpdateRequestDto dto,
		@SessionAttribute(name = Const.LOGIN_USER, required = false) UserResponseDto loginUser
	) {
		PlanUpdateResponseDto updatedPlan = planService.updatePlan(planId, dto, loginUser);

		return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
	}

	/**
	 * 일정 삭제
	 * TODO loginUser는 어디에 쓰지..?
	 * @param planId
	 * @param loginUser
	 * @return
	 */
	@DeleteMapping("/{planId}")
	public ResponseEntity<PlanDeleteResponseDto> deletePlan(
		@PathVariable Long planId,
		@SessionAttribute(name = Const.LOGIN_USER, required = false) UserResponseDto loginUser
	) {

		PlanDeleteResponseDto deletedPlan = planService.deletePlan(planId, loginUser);

		return new ResponseEntity<>(deletedPlan, HttpStatus.OK);
	}
}
