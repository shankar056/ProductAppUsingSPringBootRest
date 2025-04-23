package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "products_info")
@Data
public class Product {
	@Id
	@Column(name = "pid")
	@GeneratedValue
	private int productId;
	@NotBlank(message="Product name cannot be null or blank")
	private String productName;
	@Column(name = "price")
	@Min(value=100,message="Product price cannot be lower than 100")
	@Max(value=100000,message="Product price cannot be higher than 1 lakh")
	private int productPrice;
	@Size(min=4,max=12,message="Category length must be between(4,12)")
	private String productCategory;
	@Positive(message="Quantity cannot be zero or negetive")
	private int productQuantity;

	public Product() {
		System.out.println("Default");
	}

	public Product(String productName, int productPrice, String productCategory, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

	
}
