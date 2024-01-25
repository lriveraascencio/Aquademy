package com.Aquademy.restservices.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "cart")
//public class Cart {
//	
//
//	@Id
//	@GeneratedValue
//	private Long cartId;
//
//	@OneToOne
//	@JoinColumn(name="userId")
//	private User user;
//	
//
////	@OneToMany
////	private List<Course> courses;
//	
//
//	@Column(name = "total", nullable = true, columnDefinition = "double precision default 0.0")
//	private Double total;
//
//
//
//
//	public Cart(Long cartId, User user, Double total) {
//	super();
//	this.cartId = cartId;
//	this.user = user;
//	this.total = total;
//}
//
//	public Cart() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Long getCartId() {
//		return cartId;
//	}
//
//	public void setCartId(Long cartId) {
//		this.cartId = cartId;
//	}
//
//
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Double getTotal() {
//		return total;
//	}
//
//	public void setTotal(Double total) {
//		this.total = total;
//	}
//
//	
//
//
//}
