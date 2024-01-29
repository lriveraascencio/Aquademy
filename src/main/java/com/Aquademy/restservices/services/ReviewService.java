package com.Aquademy.restservices.services;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aquademy.restservices.dtos.ReviewDTO;
import com.Aquademy.restservices.entities.Course;
import com.Aquademy.restservices.entities.Review;
import com.Aquademy.restservices.entities.User;
import com.Aquademy.restservices.repositories.CourseRepository;
import com.Aquademy.restservices.repositories.ReviewRepository;
import com.Aquademy.restservices.repositories.UserRepository;

@Service
public class ReviewService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	public Review addReviewToCourse(Long courseId, Long userId, ReviewDTO reviewDTO) {
		Course course = courseRepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

		Review review = new Review();
		review.setCourse(course);
		review.setUser(user);
		review.setRating(reviewDTO.getRating());
		review.setComment(reviewDTO.getComment());

		return reviewRepository.save(review);
	}
	
	
	public void removeReviewOfCourse(Long reviewId, Long userId) throws Exception{
		Review review = reviewRepository.findById(reviewId)
						.orElseThrow(() -> new ResourceNotFoundException("Review not found with id: " + reviewId));
		 if (!review.getUser().getUserId().equals(userId)) {
	            throw new Exception("User not authorized to delete this review");
	        }

	        
	        
	        Course course = review.getCourse();
	        course.getReviews().remove(review);
	        reviewRepository.delete(review);
	        courseRepository.save(course);

	}

}
