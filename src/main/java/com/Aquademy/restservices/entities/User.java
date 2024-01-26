package com.Aquademy.restservices.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

//ss
@Entity
@Table(name = "base")
public class User {

	@Id
	@GeneratedValue
	private Long userId;
	
	@NotEmpty(message="Username is mandatory field. please provide username")
	@Column(name = "userName", length = 50, nullable = false, unique = true)
	private String userName;
	
	@Size(min=2, message="FirstName should have arleast 2 characters")
	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;

	@Column(name = "bio")
	private String bio;

	@Column(name = "experience", length = 500, nullable = false)
	private String experience;

	@Column(name = "domain_expertise", length = 50, nullable = false)
	private String domainExpertise;

	@Column(name = "role", length = 50, nullable = false)
	private String role;

//	@OneToMany
//	private List<Course> courses;

//	//@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//	private Cart cart;
//
//	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
//	private List<Order> orders;

	

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Long userId, String userName, String firstName, String lastName, String bio, String experience,
			String domainExpertise, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bio = bio;
		this.experience = experience;
		this.domainExpertise = domainExpertise;
		this.role = role;
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

//	public List<Course> getCourses() {
//		return courses;
//	}
//
//	public void setCourses(List<Course> courses) {
//		this.courses = courses;
//	}

//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}
//
//	public List<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}

}
