package com.jpa.demo.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	private String lastName;
	private String firstName;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinTable(name= "student_course",
	joinColumns = {@JoinColumn(name ="student_id")},
	inverseJoinColumns = {@JoinColumn(name ="course_id")})
	private Set<Course> courses = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL,mappedBy="student")
	private List<Phone> phone = new ArrayList<Phone>();
	


	@Override
	public String toString() {
		return "Student [lastName=" + lastName + "]";
	}

	public void addPhone(Phone phone) {
		this.phone.add(phone);
		phone.setStudent(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Set<Course> getCourse() {
		return courses;
	}

	public void setCourse(Set<Course> course) {
		this.courses = course;
	}

	public Student() {
	}

	
}
