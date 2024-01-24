package com.Aquademy.restservices.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue
	private Long cartId;

	private Long user_Id;

////	@Column(name="courses")
//	@OneToOne
	private Long course_Id;

	@Column(name = "total")
	private Double Total;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(Long cartId, Long user_Id, Long course_Id, Double total) {
		super();
		this.cartId = cartId;
		this.user_Id = user_Id;
		this.course_Id = course_Id;
		Total = total;
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

	public Long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}

	public Double getTotal() {
		return Total;
	}

	public Long getCourse_Id() {
		return course_Id;
	}

	public void setCourse_Id(Long course_Id) {
		this.course_Id = course_Id;
	}

	public void setTotal(Double total) {
		Total = total;
	}

}
