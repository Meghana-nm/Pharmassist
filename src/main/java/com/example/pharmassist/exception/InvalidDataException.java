package com.example.pharmassist.exception;

public class InvalidDataException extends RuntimeException
{
	String message;

	public InvalidDataException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}


}
