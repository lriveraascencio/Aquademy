package com.Aquademy.restservices.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue
	private Long courseId;

	@Column(name = "name")
	private String name;

	@Column(name = "domain")
	private String domain;

	@Column(name = "description")
	private String description;

	@Column(name = "author")
	private String author;

	@Column(name = "price")
	private double price;

	@Column(name = "duration")
	private int duration;

	@OneToMany(mappedBy = "course")
	private List<Review> reviews;

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(Long courseId, String name, String domain, String description, String author, double price,
			int duration, List<Review> reviews) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.domain = domain;
		this.description = description;
		this.author = author;
		this.price = price;
		this.duration = duration;
		this.reviews = reviews;
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

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	// Getters and setters

}
