package com.Aquademy.restservices.exceptions;

public class UserExistsException extends Exception {

	private static final long serialVersionUID = 2424232817339783476L;

	public UserExistsException(String message) {
		super(message);

	}

}
