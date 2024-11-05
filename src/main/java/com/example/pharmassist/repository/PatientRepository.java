package com.example.pharmassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pharmassist.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String>{

}
