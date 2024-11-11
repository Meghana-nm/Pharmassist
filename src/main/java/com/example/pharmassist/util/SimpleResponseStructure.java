package com.example.pharmassist.util;

import org.springframework.http.HttpStatus;


public class SimpleResponseStructure 
{
	private  int status;
	private String message;
	
	public int getStatus() 
	{
		return status;
	}
	public void setStatus(int statusCode) 
	{
		this.status = statusCode;
	}
	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
	}

	public static  SimpleResponseStructure create(HttpStatus status, String message)
	{
		SimpleResponseStructure response = new SimpleResponseStructure();
		response.setMessage(message);
		response.setStatus(status.value());

		return response;

	}
}
