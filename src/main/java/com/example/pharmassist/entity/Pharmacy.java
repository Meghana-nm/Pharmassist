package com.example.pharmassist.entity;

import com.example.pharmassist.config.GenerateCustomId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Pharmacy {
	@Id
	@GenerateCustomId
	private String pharmacyId;
	private String name;
	private String gstNo;
	private String licenceNo;
	
	@OneToOne(mappedBy = "pharmacy")
	private Admin admin;
	
	public String getPharmacyId() {
		return pharmacyId;
	}
	public void setPharmacyId(String pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
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
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	
	

}
