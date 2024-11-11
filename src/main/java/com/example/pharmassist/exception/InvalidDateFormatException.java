package com.example.pharmassist.exception;

public class InvalidDateFormatException extends RuntimeException 
{
	private String message;

	public InvalidDateFormatException(String message) 
	{
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
