package com.jpa.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpa.demo.service.LecturerService;
import com.jpa.demo.service.MyClassService;

@SpringBootApplication
public class JpaDemoApplication {

	@Autowired  MyClassService myClassService;
	@Autowired  LecturerService lecturerService;
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Bean
	ApplicationRunner init() {
		return args -> {
//			myClassService.createCourses();
//			myClassService.insertStudentWithCourse();
//			myClassService.insertPhoneForStudent();
//			myClassService.insertIdentityCardForStudent();
			
			
			lecturerService.insertLecturerCourse();
		};
	}
}
