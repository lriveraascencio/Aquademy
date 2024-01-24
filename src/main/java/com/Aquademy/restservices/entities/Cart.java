package com.Aquademy.restservices.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue
	private Long cartId;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@OneToMany
	private List<Course> courses;

	@Column(name = "total")
	private Double Total;

	public Cart(Long cartId, User user, List<Course> courses, Double total) {
		super();
		this.cartId = cartId;
		this.user = user;
		this.courses = courses;
		Total = total;
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

//	public Course getCourses() {
//		return courses;
//	}
//
//	public void setCourses(Course courses) {
//		this.courses = courses;
//	}

	public Double getTotal() {
		return Total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void setTotal(Double total) {
		Total = total;
	}

}
