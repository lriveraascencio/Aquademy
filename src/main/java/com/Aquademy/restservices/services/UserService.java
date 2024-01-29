package com.Aquademy.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Aquademy.restservices.dtos.UserDTO;
import com.Aquademy.restservices.entities.User;
import com.Aquademy.restservices.exceptions.UserExistsException;
import com.Aquademy.restservices.exceptions.UserNotFoundException;
import com.Aquademy.restservices.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// addUser
	public User addUser(User user) throws UserExistsException {
		// if user exists using username
		User existingUser = userRepository.findByUserName(user.getUserName());
		// if not exists throw UserExistsException
		if (existingUser != null) {
			throw new UserExistsException("User already exists in repository");
		}

		return userRepository.save(user);
	}

	// updateUserById
	public User updateUserById(Long userId, User user) throws UserNotFoundException {
		// User Exists?
		Optional<User> optionalUser = userRepository.findById(userId);

		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("User not found in user Repository, Provide the correct user id");
		}
		user.setUserId(userId);
		return userRepository.save(user);
	}

	// get Details User by ID
	public UserDTO getUserDetailsById(Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));

        return new UserDTO(user); // Assuming you have a constructor in UserDTO that takes a User
    }
//	public Optional<User> getUserDetailsById(Long userId) throws UserNotFoundException {
//		Optional<User> user = userRepository.findById(userId);
//
//		if (!user.isPresent()) {
//			throw new UserNotFoundException("User not found in user Repository");
//		}
//		return user;
//	}

	// deleteUserById
	public void deleteUserById(Long userId) throws UserNotFoundException {
		Optional<User> optionalUser = userRepository.findById(userId);

		if (!optionalUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"User not found in user Repository, Provide the correct user id");
		}
		userRepository.deleteById(userId);

	}

	// getUserByUsername
	public User getUserByUsername(String userName) {
		return userRepository.findByUserName(userName);
	}

}
