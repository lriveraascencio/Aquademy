package com.Aquademy.restservices.exceptions;

import java.util.Date;

//Simple custom error details bean
public class CustomErrorDetails {
	
	private Date timeStamp;
	private String message;
	private String errorDetails;
	
	//Fields Constructor
	public CustomErrorDetails(Date timeStamp, String message, String errorDetails) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.errorDetails = errorDetails;
	}
	
	//Getters
	public Date getTimeStamp() {
		return timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getErrorDetails() {
		return errorDetails;
	}
	
	

}
