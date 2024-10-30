package com.example.pharmassist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pharmassist.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,String> 
{

}
