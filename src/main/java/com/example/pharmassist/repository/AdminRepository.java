package com.example.pharmassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.pharmassist.entity.Admin;
import com.example.pharmassist.entity.Pharmacy;

public interface AdminRepository extends JpaRepository<Admin,String> 
{
	//HQL query to select the pharmacy associated with the admin

		@Query("SELECT a.pharmacy FROM Admin a WHERE a.id= :adminId")
		Pharmacy findPharmacyByAdminId(@Param("adminId")String adminId);

}
