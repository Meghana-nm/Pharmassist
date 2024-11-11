package com.example.pharmassist.service;

import org.apache.poi.ss.usermodel.Sheet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.pharmassist.entity.Medicine;
import com.example.pharmassist.entity.Pharmacy;
import com.example.pharmassist.enums.Form;
import com.example.pharmassist.exception.InvalidDataException;
import com.example.pharmassist.exception.InvalidDateFormatException;
import com.example.pharmassist.exception.InvalidFileFormatException;
import com.example.pharmassist.exception.PharmacyNotFoundException;
import com.example.pharmassist.repository.MedicineRepository;
import com.example.pharmassist.repository.PharmacyRepository;

import jakarta.validation.Valid;

@Service
public class MedicineService {
	
	private MedicineRepository medicineRepository;
	private final PharmacyRepository pharmacyRepository;

	public MedicineService(MedicineRepository medicineRepository, PharmacyRepository pharmacyRepository) {
		super();
		this.medicineRepository = medicineRepository;
		this.pharmacyRepository = pharmacyRepository;
	}

	public String uploadMedicines(MultipartFile file,String pharmacyId) 
	{

		Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId)
				.orElseThrow(()-> new PharmacyNotFoundException("Failed to find pharmacy with Id"+pharmacyId));

		try(XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) 
		{
			for(Sheet sheet : workbook) 
			{
				for(Row row : sheet) 
				{
					if(row.getRowNum()!=0)
					{		
						Medicine medicine = getMedicine(row);

						medicine.setPharmacy(pharmacy);

						saveMedicine(medicine);
					}
				}
			}

		}
		catch ( NotOfficeXmlFileException | IOException e)
		{
			throw new InvalidFileFormatException("Invalid file format");
		}

		return "Medicines Added";
	}
	
	public Medicine getMedicine(Row row) 
	{
		Medicine medicine = new Medicine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try
		{
			medicine.setName(row.getCell(0).getStringCellValue());
			medicine.setCategory(row.getCell(1).getStringCellValue());
			medicine.setDosageInMg((int) row.getCell(2).getNumericCellValue());
			medicine.setForm(Form.valueOf(row.getCell(3).getStringCellValue().toUpperCase()));
			medicine.setIngredients(row.getCell(4).getStringCellValue());
			medicine.setManufacturer(row.getCell(5).getStringCellValue());
			medicine.setPrice((double)row.getCell(6).getNumericCellValue());
			medicine.setExpiryDate(LocalDate.parse(row.getCell(7).getStringCellValue(), formatter));
			medicine.setStockQuantity((int) row.getCell(8).getNumericCellValue());
		}
		catch(NumberFormatException e) 
		{
			throw new InvalidDataException("Data is in invalid format in row "+row.getRowNum()+"in cell");
		}
		catch(IllegalStateException e) 
		{
			throw new InvalidDataException("Data is in invalid format in row "+row.getRowNum());
		}
		catch(DateTimeParseException ex) 
		{
			throw new InvalidDateFormatException("Invalid date format in row "+row.getRowNum());
		}	
		return medicine;
	}



	public void saveMedicine(@Valid Medicine medicine) 
	{

		medicineRepository.save(medicine);

	}
	

}
