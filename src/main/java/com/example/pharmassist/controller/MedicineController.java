package com.example.pharmassist.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.pharmassist.service.MedicineService;
import com.example.pharmassist.util.AppResponseBuilder;
import com.example.pharmassist.util.SimpleResponseStructure;

@RestController
public class MedicineController {
	
	private AppResponseBuilder appResponseBuilder;
	private MedicineService medicineService;

	public MedicineController(AppResponseBuilder appResponseBuilder, MedicineService medicineService) {
		super();
		this.appResponseBuilder = appResponseBuilder;
		this.medicineService = medicineService;
	}
	
	@PostMapping("/pharmacies/{pharmacyId}/medicines")
	public ResponseEntity<SimpleResponseStructure> uploadMedicine(@RequestParam("medicine_info") MultipartFile file,@PathVariable String pharmacyId)
	{
		String message=medicineService.uploadMedicines(file,pharmacyId);
		return appResponseBuilder.success(HttpStatus.CREATED,message);
	}
}
