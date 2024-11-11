package com.example.pharmassist.exception;

public class NoMedicinesFoundException extends RuntimeException {

	private final String message;

	public NoMedicinesFoundException(String message) 
	{
		super();
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}

}
