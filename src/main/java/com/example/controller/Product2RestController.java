package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product2;
import com.example.service.Product2Service;

@RestController
public class Product2RestController {
	@Autowired
	private Product2Service product2Service;
	
	@PostMapping("/product2")
	public List<Product2> allProducts() {
		List<Product2> products = product2Service.getAllProducts2();
		System.out.println("Product2 Size: " + products.size());
		return products;
	}
}
