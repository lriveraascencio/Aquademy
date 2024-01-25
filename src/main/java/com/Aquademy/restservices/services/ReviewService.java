package com.Aquademy.restservices.services;

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
