package com.example.pharmassist.exception;

@SuppressWarnings("serial")
public class PatientNotFoundException extends RuntimeException
{
	private String message;

	public PatientNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}


}
