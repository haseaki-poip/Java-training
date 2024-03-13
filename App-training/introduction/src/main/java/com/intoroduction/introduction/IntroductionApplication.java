package com.intoroduction.introduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// @ComponentScan(basePackages = {"com.intoroduction.controller", "com.intoroduction.servise",
// "com.intoroduction.repository"})
@EntityScan(basePackages = "com.intoroduction.entity")
// @EnableJpaRepositories("com.intoroduction.repository")
@EnableJpaRepositories(basePackages = "com.intoroduction.repository")
public class IntroductionApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroductionApplication.class, args);
	}



}
