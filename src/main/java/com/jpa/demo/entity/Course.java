package com.jpa.demo.entity;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name ="course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String courseName ;
	
	@ManyToMany(fetch =FetchType.LAZY, mappedBy = "courses")
	private Set<Student> students = new HashSet<>();
	
	

	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}



	public Course () {
		
	}
}
