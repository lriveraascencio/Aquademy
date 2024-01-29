package com.Aquademy.restservices.dtos;

import com.Aquademy.restservices.entities.Review;

public class ReviewDTO {

	private Long reviewId;
	private int rating;
	private String comment;
	private String userName; // Assuming you want to include the user's name

	public ReviewDTO(Review review) {
		this.reviewId = review.getReviewId();
		this.rating = review.getRating();
		this.comment = review.getComment();
		this.userName = review.getUser().getUserName();
	}

	public ReviewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public int getRating() {
		return rating;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
