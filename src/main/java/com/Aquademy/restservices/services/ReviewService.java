package com.Aquademy.restservices.services;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aquademy.restservices.entities.Course;
import com.Aquademy.restservices.entities.Review;
import com.Aquademy.restservices.entities.User;
import com.Aquademy.restservices.repositories.CourseRepository;
import com.Aquademy.restservices.repositories.ReviewRepository;
import com.Aquademy.restservices.repositories.UserRepository;

//@Service
//public class ReviewService {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Autowired
//	private CourseRepository courseRepository;
//	
//	@Autowired
//	private ReviewRepository reviewRepository;
//	
//	
//	public void addReview(Long userId, Long courseId, Review review) {
//		User user = userRepository.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
//		
//		Course course = courseRepository.findById(courseId)
//				.orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));
//		
//		//set th user and course for the review
////		review.setUser(user);
//		
//		
//	}
//
//}
