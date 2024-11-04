package com.example.pharmassist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.pharmassist.entity.Pharmacy;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, String>{

}
