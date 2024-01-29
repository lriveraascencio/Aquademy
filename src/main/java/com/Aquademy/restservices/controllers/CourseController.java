package com.Aquademy.restservices.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.Aquademy.restservices.dtos.CourseDTO;
import com.Aquademy.restservices.entities.Course;
import com.Aquademy.restservices.exceptions.CourseExistsException;
import com.Aquademy.restservices.exceptions.CourseNotFoundException;
import com.Aquademy.restservices.repositories.CourseRepository;
import com.Aquademy.restservices.services.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CourseRepository courseRepository;

	// getAllCourses
	@GetMapping
	public ResponseEntity<List<CourseDTO>> getAllCourses() {
	    List<Course> courses = courseRepository.findAll();
	    List<CourseDTO> courseDTOs = courses.stream()
	        .map(CourseDTO::new)
	        .collect(Collectors.toList());
	    return ResponseEntity.ok(courseDTOs);
	}
	
	//getCourseById
	@GetMapping("/{courseId}")
	public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long courseId) {
		CourseDTO courseDTO = courseService.getCourseById(courseId);
		return ResponseEntity.ok(courseDTO);
	}
	
//	@GetMapping
//	public List<Course> getAllCourses() {
//		return courseService.getAllCourses();
//	}

	// addCourse
	@PostMapping
	public ResponseEntity<Void> addCourse(@RequestBody Course course, UriComponentsBuilder builder)
			throws CourseExistsException {
		try {
			courseService.addCourse(course);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/courses/{courseId}").buildAndExpand(course.getCourseId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (CourseExistsException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}

	// deleteCourse
	@DeleteMapping("/{courseId}")
	public void deleteCourseById(@PathVariable Long courseId) throws CourseNotFoundException {
		courseService.deleteCourseById(courseId);
	}
	
	//Sort
	@GetMapping("/filter")
    public ResponseEntity<List<Course>> filterCourses(
            @RequestParam(name= "domain", required = false) String domain,
            @RequestParam(name= "sortBy", defaultValue = "asc") String sortBy) {

        List<Course> courses = courseService.filterCourses(domain,sortBy);
        return ResponseEntity.ok(courses);
    }

}
