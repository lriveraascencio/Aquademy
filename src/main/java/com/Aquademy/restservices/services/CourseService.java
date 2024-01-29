package com.Aquademy.restservices.services;

import java.util.List;
import java.util.Optional;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Aquademy.restservices.dtos.CourseDTO;
import com.Aquademy.restservices.entities.Course;
import com.Aquademy.restservices.exceptions.CourseExistsException;
import com.Aquademy.restservices.exceptions.CourseNotFoundException;
import com.Aquademy.restservices.repositories.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

//	@Autowired
//	private OrderRepository orderRepository;

	// getAllCourses
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}
	
	
	//findCourseById
	
	public CourseDTO getCourseById(Long courseId) {
		Course course = courseRepository.findById(courseId)
				.orElseThrow( () -> new ResourceNotFoundException("Course not found with Id: " + courseId));
		return new CourseDTO(course);
	}

	// addCourse
	public Course addCourse(Course course) throws CourseExistsException {
		// if course exists using courseName
		Course existingCourse = courseRepository.findByname(course.getName());
		// if not exists throw CourseExistsException
		if (existingCourse != null) {
			throw new CourseExistsException("Course already exists in repository");
		}
		return courseRepository.save(course);
	}

	// deleteCourseById
	public void deleteCourseById(Long courseId) throws CourseNotFoundException {
		// check if course existing
		Optional<Course> optionalCourse = courseRepository.findById(courseId);

		if (!optionalCourse.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"Course not found in course Repository, Provide the correct course id");
		}
		courseRepository.deleteById(courseId);
	}
	
	
	// Sort courses by domain
	public List<Course> filterCourses(String domain, String sortBy) {
		List<Course> courses;

		if (domain != null && !domain.isEmpty()) {
			courses = courseRepository.findByDomain(domain);
		} else {
			if ("desc".equalsIgnoreCase(sortBy)) {
				courses = courseRepository.findByOrderByPriceDesc();
			} else {
				courses = courseRepository.findByOrderByPriceAsc();
			}
		}

		return courses;
	}
}
