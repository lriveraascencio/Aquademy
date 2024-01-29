package com.Aquademy.restservices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

import com.Aquademy.restservices.dtos.UserDTO;
import com.Aquademy.restservices.entities.User;
import com.Aquademy.restservices.exceptions.UserExistsException;
import com.Aquademy.restservices.exceptions.UserNameNotFoundException;
import com.Aquademy.restservices.exceptions.UserNotFoundException;
import com.Aquademy.restservices.services.UserService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@Validated
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
	public ResponseEntity<Void> addUser(@Valid @RequestBody User user, UriComponentsBuilder builder) throws UserExistsException {
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
    public ResponseEntity<UserDTO> getUserDetailsById(@PathVariable("userId") @Min(1) Long userId) {
        try {
            UserDTO userDTO = userService.getUserDetailsById(userId);
            return ResponseEntity.ok(userDTO);
        } catch (UserNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
//	@GetMapping("/{userId}")
//	public Optional<User> getUserDetailsById(@PathVariable("userId") @Min(1) Long userId) throws UserNotFoundException {
//
//		try {
//			return userService.getUserDetailsById(userId);
//		} catch (UserNotFoundException ex) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
//		}
//
//	}

	// deleteUserById
	@DeleteMapping("/{userId}")
	public void deleteUserById(@PathVariable("userId") Long userId) throws UserNotFoundException {
		userService.deleteUserById(userId);
	}
	
	
	//getUserByUsername
	@GetMapping("/byusername/{userName}")
	public User getUserByUserName(@PathVariable("userName") String userName) throws UserNameNotFoundException {
		User user =  userService.getUserByUsername(userName);
		if(user==null)
			throw new UserNameNotFoundException("UserName: '" + userName + "'not found in User Repository");
		return user;
	}
	
	
	
	
	
	

}
