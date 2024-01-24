package com.Aquademy.restservices.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue
	private Long orderId;

	private Long user_Id;

	private List<Integer> courseId;

	private Double total;

	private Date date;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	

	public Order(Long orderId, Long user_Id, List<Integer> courseId, Double total, Date date) {
		super();
		this.orderId = orderId;
		this.user_Id = user_Id;
		this.courseId = courseId;
		this.total = total;
		this.date = date;
	}



	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public List<Course> getCourses() {
//		return courses;
//	}
//
//	public void setCourses(List<Course> courses) {
//		this.courses = courses;
//	}

	

	public List<Integer> getCourseId() {
		return courseId;
	}

	public Long getUser_Id() {
		return user_Id;
	}



	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}



	public void setCourseId(List<Integer> courseId) {
		this.courseId = courseId;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
