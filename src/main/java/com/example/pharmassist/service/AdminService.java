package com.example.pharmassist.service;

import org.springframework.stereotype.Service;

import com.example.pharmassist.entity.Admin;
import com.example.pharmassist.mapper.AdminMapper;
import com.example.pharmassist.repository.AdminRepository;
import com.example.pharmassist.requestdtos.AdminRequest;
import com.example.pharmassist.responsedtos.AdminResponse;
import com.example.pharmassist.util.AppResponseBuilder;

@Service
public class AdminService
{
	private final AdminRepository adminRepository;
	private final AdminMapper adminMapper;

	public AdminService(AdminRepository adminRepository,AppResponseBuilder appResponseBuilder,AdminMapper adminMapper)
	{
		this.adminRepository=adminRepository;
		this.adminMapper=adminMapper;
	}

	public AdminResponse addAdmin(AdminRequest adminRequest)
	{
		Admin admin=adminRepository.save(adminMapper.mapToAdmin(adminRequest, new Admin()));
		return adminMapper.mapToAdminResponse(admin);
	}

}
