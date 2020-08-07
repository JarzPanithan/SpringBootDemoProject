package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Product2;
import com.example.repository.Product2Repository;

@Service
public class Product2Service {
	@Autowired
	private Product2Repository product2Repository;
	
	public List<Product2> getAllProducts2() {
		return product2Repository.findAll();
	}
	
//	public Product2 getProduct2ById(@RequestParam("id") Long productId) {
//		return product2Repository.findById(productId).get();
//	}
	
	public Optional<Product2> getProduct2ById(@RequestParam("id") Long productId) {
		return product2Repository.findById(productId);
	}
	
	public Product2 getProduct2ByName(@RequestParam("name") String productName) {
		return product2Repository.findByProductName(productName);
	}
	
	public Product2 saveProduct2(Product2 product) {
		return product2Repository.save(product);
	}
	
	public Product2 updateProduct2(Product2 product) {
		return product2Repository.save(product);
	}
	
//	public void deleteProduct2(@PathVariable("productId") Long productId) {
//		product2Repository.deleteById(productId);
//	}
	
	public Optional<Product2> deleteProduct2(@PathVariable("productId") Long productId) {
		product2Repository.deleteById(productId);
		return null;
	}
}
