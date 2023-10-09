package com.jpa.demo.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.jpa.demo.entity.Course;
import com.jpa.demo.entity.IdentityCard;
import com.jpa.demo.entity.Phone;
import com.jpa.demo.entity.Student;
import com.jpa.demo.repository.CourseRepository;
import com.jpa.demo.repository.IdentityCardRepository;
import com.jpa.demo.repository.PhoneRepository;
import com.jpa.demo.repository.StudentRepository;

@Service
public class MyClassService {

	private CourseRepository courseRopository;
	private StudentRepository studentRepository;
	private PhoneRepository phoneRepository;
	private IdentityCardRepository identityCardRepository;
	private MyClassService(CourseRepository _courseRepository
			,StudentRepository _studentRepository
			,PhoneRepository __phoneRepository
			, IdentityCardRepository _identityCardRepository) {
		
				studentRepository = _studentRepository;
				phoneRepository = __phoneRepository;
				identityCardRepository = _identityCardRepository;
				courseRopository = _courseRepository;
	}
	
	public void createCourses () {
		Course course = new Course("Java Web");

		courseRopository.save(course);
	}
	
	public void insertStudentWithCourse() {
		Set<Course> courses = new HashSet<Course>();
		courses.add(courseRopository.findById((long)1).get());
		Student student = new Student();
		student.setCourse(courses);
		student.setFirstName("Tran Van");
		student.setLastName("Phuc");
		student.setEmail("tvphuc86-@asdada.com");
		studentRepository.save(student);
	}
	
	public void insertPhoneForStudent() {
		Phone phone = new Phone();
		phone.setPhoneNumber("0932115270");
		Student student = studentRepository.findById((long)1).get();
		phone.setStudent(student);
		phoneRepository.save(phone);

		
		
		
	}
	
	public void insertIdentityCardForStudent() {
		
		Student student  = studentRepository.findById((long)1).orElseThrow();
		student.toString();
		IdentityCard identityCard = new IdentityCard();
		
		identityCard.setId((long)1);
		identityCard.setNationality("Viet Nam");
		identityCard.setNumber("0931023109");
		
		identityCard.setStudent(new Student());
		identityCardRepository.save(identityCard);
	}
}
