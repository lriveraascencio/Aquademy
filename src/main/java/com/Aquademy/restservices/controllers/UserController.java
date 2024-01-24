package com.Aquademy.restservices.controllers;

//@RestController
//@RequestMapping(value = "/api/users")
//public class UserController {
//
//	@Autowired
//	private UserService userService;
//	
//	@GetMapping
//	public List<User> getAllUsers() {
//		return userService.getAllUsers();
//	}
//	
//	//addUser
//	@PostMapping
//	public ResponseEntity<User> addUser(@RequestBody User user) {
//		User newUser = userService.addUser(user);
//		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
//	}
//	
//	//UserDetailsById
//	@GetMapping("/{userId}")
//	public ResponseEntity<User> getDetailsUser (@PathVariable Long userId) {
//		User userDetails = userService.getUserDetails(userId);
//		return new ResponseEntity<> (userDetails, HttpStatus.OK);
//	}
//	
//	
//	//updateUser
//	@PutMapping("/{userId}")
//	public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
//		User updatedUserData = userService.updateUser(userId, updatedUser);
//		return new ResponseEntity<>(updatedUserData, HttpStatus.OK);
//	}
//}
