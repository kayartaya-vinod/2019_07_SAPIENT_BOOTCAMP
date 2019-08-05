package com.publicissapient.training.entity;

public class InvalidNameException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidNameException() {
		super("Invalid name");
	}

	public InvalidNameException(String message) {
		super(message);
	}

	public InvalidNameException(Throwable cause) {
		super(cause);
	}

}
