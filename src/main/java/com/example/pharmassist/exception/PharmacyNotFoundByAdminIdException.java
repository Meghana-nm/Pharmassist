package com.example.pharmassist.exception;

@SuppressWarnings("serial")
public class PharmacyNotFoundByAdminIdException extends RuntimeException {

	private String message;

	public PharmacyNotFoundByAdminIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
