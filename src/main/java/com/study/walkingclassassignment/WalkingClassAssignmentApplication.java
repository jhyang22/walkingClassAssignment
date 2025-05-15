package com.study.walkingclassassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WalkingClassAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalkingClassAssignmentApplication.class, args);
	}

}
