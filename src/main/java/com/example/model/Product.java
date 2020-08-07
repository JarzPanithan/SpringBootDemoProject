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
public class Product {
	private Long id;
	@NotEmpty(message = "Product name must insert.")
	@Size(min = 5, max = 50, message = "Product name must be equal or grater than 5 characters and less than 50 characters.")
	private String name;
	@NotNull(message = "Product price must insert.")
	@Positive(message = "Product price must greater than 0.")
	private float price;
	@NotEmpty(message = "Product developer must insert.")
	@Size(min = 5, max = 50, message = "Product developer must be equal or grater than 5 characters and less than 50 characters.")
	private String developer;
	@NotEmpty(message = "Product publisher must insert.")
	@Size(min = 5, max = 50, message = "Product publisher must be equal or grater than 5 characters and less than 50 characters.")
	private String publisher;
	
	public Product() {
		super();
	}
	
	public Product(String name, float price, String developer, String publisher) {
		super();
		this.name = name;
		this.price = price;
		this.developer = developer;
		this.publisher = publisher;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
