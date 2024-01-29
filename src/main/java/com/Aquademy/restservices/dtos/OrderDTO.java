package com.Aquademy.restservices.dtos;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.Aquademy.restservices.entities.Order;

public class OrderDTO {

	private Long orderId;
	private Date date;
	private Double total;
	private List<CourseDTO> courses;

	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(Order order) {
		super();
		this.orderId = order.getOrderId();
		this.date = order.getDate();
		this.total = order.getTotal();
		this.courses = order.getCourses().stream().map(CourseDTO::new).collect(Collectors.toList());

//        if (order.getCart() != null) {
//            this.total = order.getCart().getTotal();
//            this.courses = order.getCart().getCourses().stream()
//                                 .map(CourseDTO::new)
//                                 .collect(Collectors.toList());
//        }
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
