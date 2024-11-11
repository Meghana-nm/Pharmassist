package com.example.pharmassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pharmassist.entity.Medicine;


@Repository
public interface MedicineRepository extends JpaRepository<Medicine, String>{

}
