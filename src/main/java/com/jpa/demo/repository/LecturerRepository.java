package com.jpa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.demo.entity.Lecture;

public interface LecturerRepository extends JpaRepository<Lecture, Long> {

}
