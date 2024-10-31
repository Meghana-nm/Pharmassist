package com.example.pharmassist.requestdtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PharmacyRequest {

	@NotNull(message = "name cannot be null")
	@NotBlank(message = "name cannot be blank")
	@Pattern(regexp = "^[A-Za-z\\s.]{1,50}$",message = "Invalid name")
	private String name;
	
	@NotNull(message = "gstNo cannot be null")
	@NotBlank(message = "gst cannot be blank")
	@Pattern(regexp = "^\\d{2}[A-Z]{5}\\d{4}[A-Z]{1}\\d{1}[A-Z]{1}[A-Z\\d]{1}$",message = "Invalid gstNo")
	private String gstNo;
	
	@NotNull(message = "licence number cannoyt be null")
	@NotBlank(message = "licence number cannot be blank")
	@Pattern(regexp = "^[A-Z]{2}-\\d{5}-[A-Z]{2}$",message = "Invalid licenceNo")
	private String licenceNo;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	
	
}
