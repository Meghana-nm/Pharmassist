package com.example.pharmassist.mapper;

import org.springframework.stereotype.Component;

import com.example.pharmassist.entity.Admin;
import com.example.pharmassist.requestdtos.AdminRequest;
import com.example.pharmassist.responsedtos.AdminResponse;

@Component
public class AdminMapper
{
	public Admin mapToAdmin(AdminRequest adminRequest,Admin admin)
	{
		admin.setEmail(adminRequest.getEmail());
		admin.setPhoneNumber(adminRequest.getPhoneNumber());
		admin.setPassword(adminRequest.getPassword());
		
		return admin;
	}
	
	public AdminResponse mapToAdminResponse(Admin admin)
	{
		AdminResponse adminResponse=new AdminResponse();
		adminResponse.setAdminId(admin.getAdminId());
		adminResponse.setEmail(admin.getEmail());
		adminResponse.setPhoneNumber(admin.getPhoneNumber());
		
		return adminResponse;
	}

}
