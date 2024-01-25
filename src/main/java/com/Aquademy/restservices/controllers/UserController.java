package com.Aquademy.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.Aquademy.restservices.entities.User;
import com.Aquademy.restservices.exceptions.UserExistsException;
import com.Aquademy.restservices.exceptions.UserNotFoundException;
import com.Aquademy.restservices.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// addUser
	@PostMapping
	public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder builder) throws UserExistsException {
		try {
			 userService.addUser(user);
			 HttpHeaders headers = new HttpHeaders();
			 headers.setLocation(builder.path("/users/{userId}").buildAndExpand(user.getUserId()).toUri());
			 return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		} catch (UserExistsException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
			
		}
	}

	// updateUser
	@PutMapping("/{userId}")
	public User updateUserById(@PathVariable Long userId, @RequestBody User user) throws UserNotFoundException {
		try {
			return userService.updateUserById(userId, user);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}
	}

	// UserDetailsById
	@GetMapping("/{userId}")
	public Optional<User> getUserDetailsById(@PathVariable Long userId) throws UserNotFoundException {

		try {
			return userService.getUserDetailsById(userId);
		} catch (UserNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}

	}

	// deleteUserById
	@DeleteMapping("/{userId}")
	public void deleteUserById(@PathVariable("userId") Long userId) throws UserNotFoundException {
		userService.deleteUserById(userId);
	}
	
	
	//getUserByUsername
	@GetMapping("/byusername/{userName}")
	public User getUserByUserName(@PathVariable("userName") String userName) {
		return userService.getUserByUsername(userName);
	}

}
