package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Product2 {
	private Long productId;
	@NotEmpty(message = "Product code must insert.")
	@Size(min = 5, max = 12, message = "Product code must be equal or grater than 5 characters and less than 12 characters.")
	private String productCode;
	@NotEmpty(message = "Product name must insert.")
	@Size(min = 5, max = 50, message = "Product name must be equal or grater than 5 characters and less than 50 characters.")
	private String productName;
	@NotNull(message = "Product price must insert.")
	@Positive(message = "Product price must greater than 0.")
	private float productPrice;
	@NotEmpty(message = "Product address must insert.")
	@Size(min = 5, max = 50, message = "Product address must be equal or grater than 5 characters and less than 50 characters.")
	private String productAddress;
	
	public Product2() {
		super();
	}

	public Product2(Long productId, String productCode, String productName, float productPrice, String productAddress) {
		super();
		this.productId = productId;
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productAddress = productAddress;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductAddress() {
		return productAddress;
	}

	public void setProductAddress(String productAddress) {
		this.productAddress = productAddress;
	}
}
