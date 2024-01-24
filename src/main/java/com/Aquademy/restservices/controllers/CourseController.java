package com.Aquademy.restservices.controllers;

//@RestController
//@RequestMapping ("/api/courses")
//public class CourseController {
//	
//	@Autowired
//	private CourseService courseService;
//	
//	
//	//getAllCourses
//	@GetMapping
//	public List<Course> getAllCourses() {
//		return courseService.getAllCourses();
//	}
//	
//	//addCourse
//	@PostMapping
//	public ResponseEntity<Course> addCourse (@RequestBody Course course) {
//		Course newCourse = courseService.addCourse(course);
//		return new ResponseEntity<>(newCourse, HttpStatus.CREATED);	
//	}
//	
//	
//	//deleteCourse
//	@DeleteMapping("/{courseId}")
//	public ResponseEntity<Void> deleteCourse(@PathVariable Long courseId) {
//		courseService.deleteCourse(courseId);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//	
//	//Sort
//	@GetMapping("/filter")
//    public ResponseEntity<List<Course>> filterCourses(
//            @RequestParam(name= "domain", required = false) String domain,
//            @RequestParam(name= "sortBy", defaultValue = "asc") String sortBy) {
//
//        List<Course> courses = courseService.filterCourses(domain,sortBy);
//        return ResponseEntity.ok(courses);
//    }
//	
//
//
//}
