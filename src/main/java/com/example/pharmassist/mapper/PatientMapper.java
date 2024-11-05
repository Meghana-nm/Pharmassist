package com.example.pharmassist.mapper;

import org.springframework.stereotype.Component;

import com.example.pharmassist.entity.Patient;
import com.example.pharmassist.requestdtos.PatientRequest;
import com.example.pharmassist.responsedtos.PatientResponse;


@Component
public class PatientMapper {
	
	public Patient mapToPatient(PatientRequest request,Patient patient) {
		patient.setName(request.getName());
		patient.setPhoneNumber(request.getPhoneNumber());
		patient.setEmail(request.getEmail());
		patient.setGender(request.getGender());
		patient.setDateOfBirth(request.getDateOfBirth());
		
		return patient;
	}
	
	public PatientResponse mapToPatientResponse(Patient patient) {
		PatientResponse patientResponse=new PatientResponse();
		patientResponse.setPatientId(patient.getPatientId());
		patientResponse.setName(patient.getName());
		patientResponse.setPhoneNumber(patient.getPhoneNumber());
		patientResponse.setEmail(patient.getEmail());
		patientResponse.setGender(patient.getGender());
		patientResponse.setDateOfBirth(patient.getDateOfBirth());
		
		return patientResponse;
	}

}
