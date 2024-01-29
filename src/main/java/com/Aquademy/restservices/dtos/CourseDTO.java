package com.Aquademy.restservices.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.Aquademy.restservices.entities.Course;

public class CourseDTO {

	private Long courseId;
	private String name;
	private String domain;
    private String description;
    private String author;
    private double price;
    private int duration;
	private List<ReviewDTO> reviews;

	public CourseDTO() {
		
		// TODO Auto-generated constructor stub
	}


	public CourseDTO(Course course) {
		this.courseId = course.getCourseId();
		this.name = course.getName();
		this.domain = course.getDomain();
		this.description = course.getDescription();
		this.author = course.getAuthor();
		this.price = course.getPrice();
		this.duration = course.getDuration();
		this.reviews = course.getReviews().stream()
						.map(ReviewDTO::new)
						.collect(Collectors.toList());
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public List<ReviewDTO> getReviews() {
		return reviews;
	}


	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}
	
	

}
