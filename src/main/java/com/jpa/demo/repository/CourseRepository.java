package com.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.demo.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
