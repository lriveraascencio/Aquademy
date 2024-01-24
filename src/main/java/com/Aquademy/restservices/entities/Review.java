package com.Aquademy.restservices.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId;

	private Long course_Id;

	private Long user_Id;

	@Column(name = "rating")
	private int rating;

	@Column(name = "comment")
	private String comment;

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Review(Long reviewId, Long course_Id, Long user_Id, int rating, String comment) {
		super();
		this.reviewId = reviewId;
		this.course_Id = course_Id;
		this.user_Id = user_Id;
		this.rating = rating;
		this.comment = comment;
	}



	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	
	

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}



	public int getRating() {
		return rating;
	}

	public Long getCourse_Id() {
		return course_Id;
	}



	public void setCourse_Id(Long course_Id) {
		this.course_Id = course_Id;
	}



	public Long getUser_Id() {
		return user_Id;
	}



	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}



//	public Course getCourse() {
//		return course;
//	}
//
//	public void setCourse(Course course) {
//		this.course = course;
//	}

}
