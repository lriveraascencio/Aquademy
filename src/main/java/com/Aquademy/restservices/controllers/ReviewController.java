package com.Aquademy.restservices.controllers;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Aquademy.restservices.dtos.ReviewDTO;
import com.Aquademy.restservices.entities.Review;
import com.Aquademy.restservices.services.ReviewService;

@RestController
@RequestMapping("/api/courses")
public class ReviewController {
	
	@Autowired
    private ReviewService reviewService;

	  @PostMapping("/{courseId}/reviews")
	    public ResponseEntity<ReviewDTO> addReviewToCourse(
	            @PathVariable Long courseId, 
	            @RequestParam Long userId, 
	            @RequestBody ReviewDTO reviewDTO) {
	        Review review = reviewService.addReviewToCourse(courseId, userId, reviewDTO);
	        ReviewDTO responseDTO = new ReviewDTO(review);
	        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
	    }
	  
	  
	  @DeleteMapping("/{courseId}/reviews/{reviewId}")
	  public ResponseEntity<?> removeReviewFromCourse(@PathVariable Long courseId, @PathVariable Long reviewId, @RequestParam Long userId) throws Exception {
		  try {
	            reviewService.removeReviewOfCourse(reviewId, userId);
	            return ResponseEntity.ok("Review successfully removed from Course ID: " + courseId);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	  }
	}
