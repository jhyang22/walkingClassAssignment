package com.study.walkingclassassignment.domain.plan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.study.walkingclassassignment.domain.plan.dto.requestdto.PlanCreateRequestDto;
import com.study.walkingclassassignment.domain.plan.dto.requestdto.PlanUpdateRequestDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.FindAllPlanResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanCreateResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanDeleteResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanResponseDto;
import com.study.walkingclassassignment.domain.plan.dto.responsedto.PlanUpdateResponseDto;
import com.study.walkingclassassignment.domain.plan.entity.Plan;
import com.study.walkingclassassignment.domain.plan.repository.PlanRepository;
import com.study.walkingclassassignment.domain.user.dto.UserResponseDto;
import com.study.walkingclassassignment.domain.user.entity.User;
import com.study.walkingclassassignment.domain.user.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService{

	private final PlanRepository planRepository;
	private final UserRepository userRepository;

	/**
	 * 일정 저장
	 * @param dto
	 * @param loginUser
	 * @return PlanCreateResponseDto
	 */
	@Transactional
	@Override
	public PlanCreateResponseDto savePlan(PlanCreateRequestDto dto, UserResponseDto loginUser) {

		User foundUser = userRepository.findByIdOrElseThrow(loginUser.getId());

		Plan plan = new Plan(foundUser, dto.getTitle(), dto.getContent());

		Plan savedPlan = planRepository.save(plan);

		return PlanCreateResponseDto.fromPlan(savedPlan);
	}

	/**
	 * 전체 일정 조회
	 * TODO loginUser는 어디에 쓰지..?
	 * @param loginUser
	 * @return List<FindAllPlanResponseDto>
	 */
	@Override
	public List<FindAllPlanResponseDto> findAll(UserResponseDto loginUser) {

		List<Plan> findAllPlan = planRepository.findAll();

		return findAllPlan.stream().map(FindAllPlanResponseDto::fromPlan).toList();
	}

	/**
	 * 단일 일정 조회 (상세 조회)
	 * 댓글 리스트 함께 출력
	 * @param planId
	 * @param loginUser
	 * @return PlanResponseDto
	 */
	@Override
	public PlanResponseDto findById(Long planId, UserResponseDto loginUser) {

		Plan findPlanById = planRepository.findByIdOrElseThrow(planId);

		return PlanResponseDto.fromPlan(findPlanById);
	}

	/**
	 * 일정 수정
	 * TODO loginUser는 어디에 쓰지..?
	 * @param planId
	 * @param dto
	 * @param loginUser
	 * @return PlanUpdateResponseDto
	 */
	@Transactional
	@Override
	public PlanUpdateResponseDto updatePlan(Long planId, PlanUpdateRequestDto dto, UserResponseDto loginUser) {

		Plan findPlanById = planRepository.findByIdOrElseThrow(planId);

		findPlanById.update(dto);

		return PlanUpdateResponseDto.fromPlan(findPlanById);
	}

	/**
	 * 일정 삭제
	 * TODO loginUser는 어디에 쓰지..?
	 * @param planId
	 * @param loginUser
	 * @return
	 */
	@Transactional
	@Override
	public PlanDeleteResponseDto deletePlan(Long planId, UserResponseDto loginUser) {

		Plan findPlanById = planRepository.findByIdOrElseThrow(planId);

		planRepository.delete(findPlanById);

		return PlanDeleteResponseDto.fromPlan(findPlanById);
	}
}
