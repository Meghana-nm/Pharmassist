package com.example.pharmassist.mapper;

	import org.springframework.stereotype.Component;

	import com.example.pharmassist.entity.Medicine;
	import com.example.pharmassist.requestdtos.MedicineRequest;
	import com.example.pharmassist.responsedtos.MedicineResponse;
	
@Component
public class MedicineMapper {

		public Medicine mapToMedicine(MedicineRequest medicineRequest, Medicine medicine) {
			medicine.setName(medicineRequest.getName());
			medicine.setCategory(medicineRequest.getCategory());
			medicine.setIngredients(medicineRequest.getIngredients()); // Stored as a single string
			medicine.setDosageInMg(medicineRequest.getDosageInMg());
			medicine.setForm(medicineRequest.getForm());
			medicine.setManufacturer(medicineRequest.getManufacturer());
			medicine.setStockQuantity(medicineRequest.getStockQuantity());
			medicine.setExpiryDate(medicineRequest.getExpiryDate());
			medicine.setPrice(medicineRequest.getPrice());
			return medicine;
		}

		public MedicineResponse mapToMedicineResponse(Medicine medicine) {
			MedicineResponse response = new MedicineResponse();
			response.setMedicineId(medicine.getMedicineId());
			response.setName(medicine.getName());
			response.setCategory(medicine.getCategory());
			response.setIngredients(medicine.getIngredients());
			response.setDosageInMg(medicine.getDosageInMg());
			response.setForm(medicine.getForm());
			response.setManufacturer(medicine.getManufacturer());
			response.setStockQuantity(medicine.getStockQuantity());
			response.setExpiryDate(medicine.getExpiryDate());
			response.setPrice(medicine.getPrice());
			return response;
		}
	}

