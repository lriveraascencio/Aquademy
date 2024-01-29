package com.Aquademy.restservices.entities;

import java.util.List;
import java.util.stream.Collectors;

import com.Aquademy.restservices.dtos.CourseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;

	@OneToOne
	@JsonIgnore
	private User user;

	@OneToMany
	private List<Course> courses;

	@Column(name = "total", nullable = true, columnDefinition = "double precision default 0.0")
	private Double total;

	@JsonProperty("courses")
	public List<CourseDTO> getCourseDTOs() {
		if (courses == null) {
			return null;
		}
		return courses.stream().map(CourseDTO::new).collect(Collectors.toList());
	}

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	@JsonIgnore
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
