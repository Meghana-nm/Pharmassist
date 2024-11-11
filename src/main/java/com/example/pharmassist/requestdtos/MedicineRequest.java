package com.example.pharmassist.requestdtos;

import java.time.LocalDate;

import com.example.pharmassist.enums.Form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class MedicineRequest {
	
	@NotNull(message="name cannot be null")
	@NotBlank(message="name cannot be blank")
	@Pattern(regexp = "^[A-Za-z][A-Za-z0-9 _-]*[A-Za-z0-9]$",message = "Invalid medicine name")
	private String name;
	
	@NotNull(message="category cannot be null")
	@NotBlank(message="category cannot be blank")
	@Pattern(regexp = "^(?!\\s*$)[a-zA-Z- ]+$",message = "Invalid category")
	private String category;
	
	@NotNull(message="ingredients cannot be null")
	@NotBlank(message = "ingredinets cannot be blank")
	@Pattern(regexp = "^[a-zA-Z0-9]+([-'.,\\s][a-zA-Z0-9]+)*$",message = "Invalid ingredients")
	private String ingredients;
	
	@NotNull(message="dosage cannot be null")
	@NotBlank(message="dosage cannot be blank")
	@Min(value=1,message="dosage must be atleast 1 mg")
	private int dosageInMg;
	
	@NotNull(message="form cannot be null")
	@NotBlank(message="form cannot be blank")
	private Form form;
	
	@NotNull(message="manufacturer cannot be null")
	@NotBlank(message="manufacturer cannot be blank")
	@Pattern(regexp = "^(?!\\s*$)[a-zA-Z0-9.,' ]+$",message = "Invalid manufacture")
	private String manufacturer;
	
	@NotNull(message="stockQuantity cannot be null")
	@NotBlank(message="stockQuantity cannot be blank")
	@Min(value = 1,message="atleast one medicine should be there")
	private int stockQuantity;
	
	
	private LocalDate expiryDate;
	
	@NotNull(message="price cannot be null")
	@NotBlank(message="price cannot be blank")
	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public int getDosageInMg() {
		return dosageInMg;
	}

	public void setDosageInMg(int dosageInMg) {
		this.dosageInMg = dosageInMg;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
}
