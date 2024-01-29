package com.Aquademy.restservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Aquademy.restservices.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	
	Course findByname(String name);

	List<Course> findByDomain(String domain);

	List<Course> findByOrderByPriceDesc();

	List<Course> findByOrderByPriceAsc();

}
