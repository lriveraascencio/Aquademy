package com.Aquademy.restservices.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.Aquademy.restservices.entities.User;

public class UserDTO {
	
	private Long userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String bio;
    private String experience;
    private String domainExpertise;
    private String role;
    private CartDTO cart;
    private List<OrderDTO> orders;
    private List<CourseDTO> enrolledCourses;
    
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(User user) {
		super();
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.bio = user.getBio();
		this.experience = user.getExperience();
		this.domainExpertise = user.getDomainExpertise();
		this.role = user.getRole();
		
		if (user.getCart() != null) {
            this.cart = new CartDTO(user.getCart()); // Assuming CartDTO has a constructor that takes a Cart entity
        }
		


        if (user.getOrders() != null) {
        	this.orders = user.getOrders().stream()
                    .map(OrderDTO::new) // Assuming OrderDTO has a suitable constructor
                    .collect(Collectors.toList());
        }

        if (user.getCourses() != null) {
            this.enrolledCourses = user.getCourses().stream()
                .map(course -> new CourseDTO(course)) // Assuming CourseDTO has a constructor that takes a Course entity
                .collect(Collectors.toList());
        }
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDomainExpertise() {
		return domainExpertise;
	}

	public void setDomainExpertise(String domainExpertise) {
		this.domainExpertise = domainExpertise;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public CartDTO getCart() {
		return cart;
	}

	public void setCart(CartDTO cart) {
		this.cart = cart;
	}

	public List<OrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}

	public List<CourseDTO> getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(List<CourseDTO> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
	
}
