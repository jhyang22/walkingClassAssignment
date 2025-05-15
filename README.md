# 프로젝트 개요
- 댓글 CRUD 및 대댓글 CRUD 구현

- 프로젝트 기간 : 2025-04-30 ~ 2025-05-14

---
# 개발환경
- jdk : 17.0.1
- Framework : Spring Boot 3.4.5
- Build Tool : Gradle
- IDE : IntelliJ
---

# ERD
![img_3.png](img_3.png)

---
# API 명세서

![image](https://github.com/user-attachments/assets/d933eec0-d733-4b84-a846-9443bcb5ffd7)
![image](https://github.com/user-attachments/assets/87fa32a0-3fbf-4900-88f8-abea2fb1acb1)
![image](https://github.com/user-attachments/assets/7a432a14-1c9b-4cb6-b643-343e2071a47b)
![image](https://github.com/user-attachments/assets/a55af8e2-9c29-4371-98ee-b4b2e7d0e26f)


---
# 구현 기능


## 0. 공통 부문

- GlobalExceptionHandler를 통해 예외처리를 하였습니다
- JPA Auditing을 활용하기 위해 BaseEntity를 설정하고 생성일과 수정일을 필드로 설정하였습니다
- 로그인 기능 구현을 위해 filter 및 session을 적용하였습니다

## 1. 유저 부문

- 프로젝트 요구 사항에 따라 유저 부문은 최소화 하였으며 filter 및 session 연습을 위해 그 부분만 구현하였습니다 
- 회원가입 기능 구현
- 로그인 기능 구현

## 2. 일정 부문

- 일정 생성 기능 구현
- 전체 일정 조회 기능 구현
  - Pageable을 적용하여 페이징 하였습니다
- 단일 일정 조회 기능 구현
  - 댓글도 함께 조회하도록 구현하였습니다
- 일정 수정 기능 구현
- 일정 삭제 기능 구현

## 3. 댓글 부문

 - 댓글 생성 기능 구현
 - 댓글 조회 기능 구현
 - 댓글 수정 기능 구현
 - 댓글 삭제 기능 구현
   - 대댓글 조회 시 NPE 방지를 위해 soft delete 형식으로 구현하였습니다

## 4. 대댓글 부문

- 대댓글의 경우 요구사항에는 연관관계를 맺으라고 하였지만 튜터님과 상담 하에 연관관계 없이 진행하였습니다
- 대댓글의 경우 댓글과 같은 Entity를 공유하기 때문에 API도 공유하여 사용하였습니다  
- 대댓글 생성 기능 구현
  - 대댓글 생성 시에 필요한 parentCommentId는 dto를 통해 body로 받아오도록 구현하였습니다
- 대댓글 조회 기능 구현
  - 댓글과 트리 형식으로 출력이 가능하도록 하기 위해 Map을 활용하였습니다
- 대댓글 수정 기능 구현
- 대댓글 삭제 기능 구현

---
# 트러블 슈팅
- 관련 내용은 블로그를 참고해주시기 바랍니다
  - https://couchpo.tistory.com/
 
# API 동작 캡처본
## 회원 가입
![image](https://github.com/user-attachments/assets/f6bab845-7db9-4dcf-9440-d5e9437a7856)

## 로그인
![image](https://github.com/user-attachments/assets/1687a0d0-843c-48f4-92c9-bdf17c1bfac6)

## 일정 생성
![image](https://github.com/user-attachments/assets/57b01b6b-ccd7-4481-af37-64e655a0d0f9)

## 전체 일정 조회
![image](https://github.com/user-attachments/assets/f0a89fa1-9731-4675-bace-00d74f4cbf43)

## 단일 일정 조회
![image](https://github.com/user-attachments/assets/dee9ad4b-af5e-4aaa-9ad5-ff0a0b52ec41)

## 일정 수정
![image](https://github.com/user-attachments/assets/bb293b31-a43b-44a3-a386-60217f059e55)

## 일정 삭제
![image](https://github.com/user-attachments/assets/90b8e06e-a93d-4537-9b48-a228df4d0609)

## 댓글 생성
![image](https://github.com/user-attachments/assets/226c600b-a411-4ec8-9142-226c86e78af5)

## 대댓글 생성
![image](https://github.com/user-attachments/assets/e314a6c3-390a-40bf-96f6-0cf13fd82dc3)

## 댓글 및 대댓글 조회
![image](https://github.com/user-attachments/assets/ac3d982b-8c6f-41c1-aec7-58919a47a5cb)

## 댓글 및 대댓글 수정
![image](https://github.com/user-attachments/assets/21439718-88f6-4735-a916-b1e0e01c2529)

## 댓글 및 대댓글 삭제
![image](https://github.com/user-attachments/assets/ec5ec49a-7e9a-47d6-859e-39266c0b154f)
