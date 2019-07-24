package com.publicissapient.training.entity;

public class InvalidNameException extends Exception {

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
