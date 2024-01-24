package com.Aquademy.restservices.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Aquademy.restservices.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
//	
//	List<Course> findByDomain(String domain);
//    List<Course> findByOrderByPriceDesc();
//    List<Course> findByOrderByPriceAsc();

}
