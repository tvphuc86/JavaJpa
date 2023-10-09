package com.jpa.demo.service;

import org.springframework.stereotype.Service;

import com.jpa.demo.entity.Course;
import com.jpa.demo.entity.Lecture;
import com.jpa.demo.repository.CourseRepository;
import com.jpa.demo.repository.LecturerRepository;



@Service
public class LecturerService {

	private LecturerRepository lecturerRepository;
	private CourseRepository courseRepository;
	private  LecturerService(LecturerRepository _LecturerRepository,CourseRepository _courseRepository) {
		this.lecturerRepository = _LecturerRepository;
		this.courseRepository = _courseRepository;
	}
	
	public void insertLecturerCourse() {
		
		Course course = courseRepository.findById((long)1).orElseThrow();
		
		Lecture lecture = new Lecture();
		lecture.setFullName("Vu Duy Linh");
		lecture.setTechnologySpec("Java");
		lecture.setCourse(course);
		
		lecturerRepository.save(lecture);
		
	}
	
}
