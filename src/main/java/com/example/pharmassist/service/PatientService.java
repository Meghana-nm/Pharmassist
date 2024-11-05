package com.example.pharmassist.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.pharmassist.entity.Patient;
import com.example.pharmassist.entity.Pharmacy;
import com.example.pharmassist.exception.PharmacyNotFoundException;
import com.example.pharmassist.mapper.PatientMapper;
import com.example.pharmassist.repository.PatientRepository;
import com.example.pharmassist.repository.PharmacyRepository;
import com.example.pharmassist.requestdtos.PatientRequest;
import com.example.pharmassist.responsedtos.PatientResponse;

@Service
public class PatientService {
	
	private final PatientRepository patientRepository;
	private final PharmacyRepository pharmacyRepository;
	private final PatientMapper patientMapper;

	public PatientService(PatientRepository patientRepository,PharmacyRepository pharmacyRepository,PatientMapper patientMapper)
	{
		this.patientMapper=patientMapper;
		this.patientRepository=patientRepository;
		this.pharmacyRepository=pharmacyRepository;
	}

	public PatientResponse addPatient(PatientRequest patientRequest,String pharmacyId)
	{
		return pharmacyRepository.findById(pharmacyId)
				.map(pharmacy  ->{
					Patient patient=patientMapper.mapToPatient(patientRequest, new Patient());
					patient.setPharmacy(pharmacy);
					pharmacy.getPatients().add(patient);
					patientRepository.save(patient);
					return patientMapper.mapToPatientResponse(patient);
				}).orElseThrow(() ->new PharmacyNotFoundException("Failed to find Pharmacy"));
	}
	}
	
	


