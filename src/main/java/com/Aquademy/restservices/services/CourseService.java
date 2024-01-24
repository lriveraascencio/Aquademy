package com.Aquademy.restservices.services;

//@Service
//public class CourseService {
//	
//	@Autowired
//	private CourseRepository courseRepository;
//	
////	@Autowired
////	private OrderRepository orderRepository;
//	
//
//	//getAllCourses
//	public List<Course> getAllCourses() {
//		return courseRepository.findAll();
//	}
//	
//
//	//addCourse
//	public Course addCourse(Course course) {
//		return courseRepository.save(course);
//	}
//	
//	
//	//deleteCourse
//	public void deleteCourse(Long courseId) {
//		//check if course existing
//		Course existingCourse = courseRepository.findById(courseId)
//				.orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));
//		
//		courseRepository.delete(existingCourse);
//			
//	}
//	
//	//Sort courses by domain
//	public List<Course> filterCourses (String domain, String sortBy){
//        List<Course> courses;
//
//        if (domain != null && !domain.isEmpty()) {
//            courses = courseRepository.findByDomain(domain);
//        } else {
//            if ("desc".equalsIgnoreCase(sortBy)) {
//                courses = courseRepository.findByOrderByPriceDesc();
//            } else {
//                courses = courseRepository.findByOrderByPriceAsc();
//            }
//        } 
//
//        return courses;
//    }
//}
