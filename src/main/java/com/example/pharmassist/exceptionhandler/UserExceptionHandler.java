package com.example.pharmassist.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pharmassist.exception.AdminNotFoundByIdException;
import com.example.pharmassist.exception.InvalidDataException;
import com.example.pharmassist.exception.InvalidDateFormatException;
import com.example.pharmassist.exception.InvalidFileFormatException;
import com.example.pharmassist.exception.NoAdminsFoundException;
import com.example.pharmassist.exception.NoMedicinesFoundException;
import com.example.pharmassist.exception.PatientNotFoundException;
import com.example.pharmassist.exception.PharmacyNotFoundByAdminIdException;
import com.example.pharmassist.exception.PharmacyNotFoundException;
import com.example.pharmassist.util.AppResponseBuilder;
import com.example.pharmassist.util.ErrorStructure;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class UserExceptionHandler 
{
	private final AppResponseBuilder appResponseBuilder;

	public UserExceptionHandler(AppResponseBuilder appResponseBuilder) 
	{
		super();
		this.appResponseBuilder = appResponseBuilder;
	}

	@ExceptionHandler(AdminNotFoundByIdException.class)
	public static <T> ResponseEntity<ErrorStructure<String>> handleAdminNotFoundById(AdminNotFoundByIdException ex) {
		return AppResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"Admin not found by Id");
	}

	@ExceptionHandler(NoAdminsFoundException.class)
	public static ResponseEntity<ErrorStructure<String>> handleNoUsersFound(NoAdminsFoundException ex){
		return AppResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"Admin not found under requested criteria");
	}
	
	@ExceptionHandler(PharmacyNotFoundByAdminIdException.class)
	public static ResponseEntity<ErrorStructure<String>> handlePharmacyNotFoundByAdminId(PharmacyNotFoundByAdminIdException ex) {
	    return AppResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"Pharmacy not found by adminId");
	}
	
	@ExceptionHandler(PharmacyNotFoundException.class)
	public static ResponseEntity<ErrorStructure<String>> handlePharmacyNotFound(PharmacyNotFoundByAdminIdException ex) {
	    return AppResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"Pharmacy not found");
	}
	
	@ExceptionHandler(PatientNotFoundException.class)
	public static <T> ResponseEntity<ErrorStructure<String>> handlePatientNotFound(PatientNotFoundException ex) {
		return AppResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"Pharmacy not found by Id");
	}
	
	@ExceptionHandler(InvalidDataException.class)
	public static <T> ResponseEntity<ErrorStructure<String>> handleInvalidData(InvalidDataException ex) {
		return AppResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"Data Is Invalid");
	}

	@ExceptionHandler(InvalidDateFormatException.class)
	public static <T> ResponseEntity<ErrorStructure<String>> handleInvalidDateFormat(InvalidDateFormatException ex) {
		return AppResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"Date Format is Invalid");
	}

	@ExceptionHandler(InvalidFileFormatException.class)
	public static <T> ResponseEntity<ErrorStructure<String>> handleInvalidFileFormat(InvalidFileFormatException ex) {
		return AppResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"File Format is Inavlid");
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public static <T> ResponseEntity<ErrorStructure<String>> handleConstraintViolationException(ConstraintViolationException ex) {
		return AppResponseBuilder.error(HttpStatus.BAD_REQUEST, ex.getMessage(),"Invalid Data Format");
	}
	
	@ExceptionHandler(NoMedicinesFoundException.class)
	public static <T> ResponseEntity<ErrorStructure<String>> handleNoMedicineFound(NoMedicinesFoundException ex) {
		return AppResponseBuilder.error(HttpStatus.BAD_REQUEST, ex.getMessage(),"No Medicine Found");
	}

}
