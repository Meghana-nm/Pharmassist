package com.example.pharmassist.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.pharmassist.entity.Patient;
import com.example.pharmassist.entity.Pharmacy;
import com.example.pharmassist.exception.PatientNotFoundException;
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
	
	public List<PatientResponse> findAllPatientByPharmacyId(String pharmacyId)
	{
		Pharmacy pharmacy=pharmacyRepository.findById(pharmacyId)
				.orElseThrow(() ->new PharmacyNotFoundException("Failed to find Pharmacy"));

		List<Patient> patients=patientRepository.findPatientByPharmacyId(pharmacyId);
		if(patients.isEmpty())
		{
			throw new PatientNotFoundException("No patients associated with the pharmacyID:"+pharmacyId);
		}
		return patients.stream()
				.map(patientMapper::mapToPatientResponse)
				.collect(Collectors.toList());
	}
}


	
	


