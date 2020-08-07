package com.example.repository;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.SpringBootDemoApplicationTests;
import com.example.model.Product2;

public class Product2RepositoryTest extends SpringBootDemoApplicationTests {
	@Autowired
	private Product2Repository product2Repository;
	
//	@Test
//	public void testGetAllProducts() {
//		product2Repository.findAll();
//		System.out.println("====> " + "Products: " + product2Repository.findAll().size());
//	}
	
//	@Test
//	public void testGetProductById() {
//		long testProductId = 66;
//		if (product2Repository.findById(testProductId).isPresent()) {
//			System.out.println("====> " + "Product: " + testProductId + " was found!!");
//		} else {
//			System.out.println("====> " + "Product: " + testProductId + " was not found!!");
//		}
//	}
	
//	@Test
//	public void testGetProductByName() {
//		String testProductName = "IPhone X";
//		if (product2Repository.findByProductName(testProductName) != null) {
//			System.out.println("====> " + "Product: " + testProductName + " was found!!");
//		} else {
//			System.out.println("====> " + "Product: " + testProductName + " was not found!!");
//		}
//	}
	
//	@Test
//	public void testSaveProduct() {
//		Product2 newProduct = new Product2();
//		newProduct.setProductCode("M81-514");
//		newProduct.setProductName("IPhone 8 Plus");
//		newProduct.setProductPrice(19000);
//		newProduct.setProductAddress("Udon-Thani");
//		product2Repository.save(newProduct);
//		System.out.println("====> " + "Product was saved!!");
//	}
	
//	@Test
//	public void testUpdateProductById() {
//		long testProductId = 67;
//		Optional<Product2> product = product2Repository.findById(testProductId);
//		if (product.isPresent()) {
//			Product2 editProduct = product.get();
//			editProduct.setProductCode("C01-136");
//			editProduct.setProductName("Macbook Air 2020");
//			editProduct.setProductPrice(50000);
//			editProduct.setProductAddress("Udon-Thani");
//			product2Repository.save(editProduct);
//			System.out.println("====> " + "Product " + testProductId + " was changed!!");
//		} else {
//			System.out.println("====> " + "Product " + testProductId + " does not exist!!");
//		}
//	}
	
//	@Test
//	public void testUpdateProductByName() {
//		String testProductName = "Macbook Air 2020";
//		Product2 editProduct = product2Repository.findByProductName(testProductName);
//		if (editProduct != null) {
//			editProduct.setProductCode("G02-475");
//			editProduct.setProductName("Samsung Galaxy Note 10");
//			editProduct.setProductPrice(42000);
//			editProduct.setProductAddress("Udon-Thani");
//			product2Repository.save(editProduct);
//			System.out.println("====> " + "Product " + testProductName + " was changed!!");
//		} else {
//			System.out.println("====> " + "Product " + testProductName + " does not exist!!");
//		}
//	}
	
//	@Test
//	public void testDeleteProduct() {
//		long testProductId = 67;
//		if (product2Repository.findById(testProductId).isPresent()) {
//			product2Repository.deleteById(testProductId);
//			System.out.println("====> " + "Product " + testProductId + " was deleted!!");
//		} else {
//			System.out.println("====> " + "Product " + testProductId + " does not exist!!");
//		}
//	}
}
