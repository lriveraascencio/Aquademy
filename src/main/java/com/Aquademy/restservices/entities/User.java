package com.Aquademy.restservices.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//ss
@Entity
@Table(name = "base")
public class User {

	@Id
	@GeneratedValue
	private Long userId;

	@Column(name = "userName", length = 50, nullable = false, unique = true)
	private String userName;

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

	@OneToOne(mappedBy = "user")
	private Cart cart;

	public User() {
		// TODO Auto-generated constructor stub
	}
//
//	public User(Long userId, String userName, String firstName, String lastName, String bio, String experience,
//			String domainExpertise, String role, Cart cart) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.bio = bio;
//		this.experience = experience;
//		this.domainExpertise = domainExpertise;
//		this.role = role;
//		this.cart = cart;
//	}

	public Long getUserId() {
		return userId;
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

}
