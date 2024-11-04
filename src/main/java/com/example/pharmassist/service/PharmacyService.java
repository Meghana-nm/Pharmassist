package com.example.pharmassist.service;

import org.springframework.stereotype.Service;

import com.example.pharmassist.entity.Admin;
import com.example.pharmassist.entity.Pharmacy;
import com.example.pharmassist.exception.AdminNotFoundByIdException;
import com.example.pharmassist.exception.PharmacyNotFoundByAdminIdException;
import com.example.pharmassist.mapper.PharmacyMapper;
import com.example.pharmassist.repository.AdminRepository;
import com.example.pharmassist.repository.PharmacyRepository;
import com.example.pharmassist.requestdtos.PharmacyRequest;
import com.example.pharmassist.responsedtos.PharmacyResponse;

@Service
public class PharmacyService {
	private final PharmacyRepository pharmacyRepository;
	private final PharmacyMapper pharmacyMapper;
	private final AdminRepository adminRepository;


	public PharmacyService(PharmacyRepository pharmacyRepository, PharmacyMapper pharmacyMapper,
			AdminRepository adminRepository) {
		super();
		this.pharmacyRepository = pharmacyRepository;
		this.pharmacyMapper = pharmacyMapper;
		this.adminRepository = adminRepository;
	}


	public PharmacyResponse addPharmacy(PharmacyRequest pharmacyRequest,String adminId) {

		return  adminRepository.findById(adminId).map(admin -> {
			 Pharmacy pharmacy=pharmacyMapper.mapToPharmacy(pharmacyRequest,new Pharmacy());
			 pharmacy=pharmacyRepository.save(pharmacy);
			 admin.setPharmacy(pharmacy);
			 adminRepository.save(admin);
			 return pharmacyMapper.mapToPharmacyResponse(pharmacy);
			 
		 })
		 .orElseThrow(() -> new AdminNotFoundByIdException("admin with requested id is not found"));
		 	
	}
	
	public PharmacyResponse findPharmacyByAdminId(String adminId)
	{
		Admin admin=adminRepository.findById(adminId)
				.orElseThrow(() -> new AdminNotFoundByIdException("Failed to Find Admin"));

		Pharmacy pharmacy=adminRepository.findPharmacyByAdminId(adminId);
		if(pharmacy==null)
		{
			throw new PharmacyNotFoundByAdminIdException("No Pharmacy associated with admin ID:"+adminId);
		}
		return pharmacyMapper.mapToPharmacyResponse(pharmacy);
	}
}




