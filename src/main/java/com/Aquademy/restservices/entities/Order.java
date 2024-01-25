package com.Aquademy.restservices.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "orders")
//public class Order {
//
//	@Id
//	@GeneratedValue
//	private Long orderId;
//
//	
//	@ManyToOne
//	@JoinColumn(name="userId")
//	private User user;
//	
//	
//	private Double total;
//
//	
//	private Date date;
//
//	public Order() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Order(Long orderId, User user, Double total, Date date) {
//		super();
//		this.orderId = orderId;
//		this.user = user;
//		this.total = total;
//		this.date = date;
//	}
//
//	public Long getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(Long orderId) {
//		this.orderId = orderId;
//	}
//
////	public User getUser() {
////		return user;
////	}
////
////	public void setUser(User user) {
////		this.user = user;
////	}
////
////	public List<Course> getCourses() {
////		return courses;
////	}
////
////	public void setCourses(List<Course> courses) {
////		this.courses = courses;
////	}
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
//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
//
//
//}
