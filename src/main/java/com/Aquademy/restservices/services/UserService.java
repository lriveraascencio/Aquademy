package com.Aquademy.restservices.services;

//@Service
//public class UserService {
//	
//	@Autowired
//	private UserRepository userRepository;
//	
//	public List<User> getAllUsers() {
//		return userRepository.findAll();
//	}
//	
//	//addUser
//	public User addUser(User user) {
//		return userRepository.save(user);
//	}
//	
//	//get Details User by ID
//	public User getUserDetails(Long userId) {
//		User detailsU = userRepository.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException ("User not Found with id: " + userId));
//
//	    return detailsU;
//	    }
//	
//	
//	
//	//updateUser
//	public User updateUser(Long userId, User updatedUser) {
//		//User Exists?
//		User existingUser = userRepository.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("User not Found with id: " + userId));
//		
//		//updating fields
//		existingUser.setUserName(updatedUser.getUserName());
//		existingUser.setFirstName(updatedUser.getFirstName());
//		existingUser.setLastName(updatedUser.getLastName());
//		existingUser.setBio(updatedUser.getBio());
//		existingUser.setExperience(updatedUser.getExperience());
//		existingUser.setDomainExpertise(updatedUser.getDomainExpertise());
//		existingUser.setRole(updatedUser.getRole());
//		
//		//save and Return
//		return userRepository.save(existingUser);
//	}
//
//}
