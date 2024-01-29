package com.Aquademy.restservices.dtos;

import java.util.List;

import com.Aquademy.restservices.entities.Cart;

public class CartDTO {

	private Long cartId;
	private Double total;
	private List<CourseDTO> courses;

	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDTO(Cart cart) {
		super();
		this.cartId = cart.getCartId();
		this.total = cart.getTotal();
		this.courses = cart.getCourseDTOs();
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDTO> courses) {
		this.courses = courses;
	}

}
