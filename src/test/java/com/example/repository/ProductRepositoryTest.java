package com.example.repository;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.SpringBootDemoApplicationTests;
import com.example.model.Product;

public class ProductRepositoryTest extends SpringBootDemoApplicationTests {
	@Autowired
	private ProductRepository productRepository;
	
//	@Test
//	public void testGetAllProducts() {
//		productRepository.findAll();
//		System.out.println("====> " + "Products: " + productRepository.findAll().size());
//	}
	
//	@Test
//	public void testGetProductById() {
//		long testProductId = 1;
//		if (productRepository.findById(testProductId).isPresent()) {
//			System.out.println("====> " + "Product: " + testProductId + " was found!!");
//		} else {
//			System.out.println("====> " + "Product: " + testProductId + " was not found!!");
//		}
//	}
	
//	@Test
//	public void testGetProductByName() {
//		String testProductName = "CODE VEIN";
//		if (productRepository.findByName(testProductName) != null) {
//			System.out.println("====> " + "Product: " + testProductName + " was found!!");
//		} else {
//			System.out.println("====> " + "Product: " + testProductName + " was not found!!");
//		}
//	}
	
//	@Test
//	public void testSaveProduct() {
//		Product newProduct = new Product();
//		newProduct.setName("Persona 4 Golden");
//		newProduct.setPrice(559);
//		newProduct.setDeveloper("ATLUS");
//		newProduct.setPublisher("SEGA Inc.");
//		productRepository.save(newProduct);
//		System.out.println("====> " + "Product was saved!!");
//	}
	
//	@Test
//	public void testUpdateProductById() {
//		long testProductId = 65;
//		Optional<Product> product = productRepository.findById(testProductId);
//		if (product.isPresent()) {
//			Product editProduct = product.get();
//			editProduct.setName("Resident Evil 3 Remake");
//			editProduct.setPrice(1809);
//			editProduct.setDeveloper("Capcom Co, Ltd.");
//			editProduct.setPublisher("Capcom Co, Ltd.");
//			productRepository.save(editProduct);
//			System.out.println("====> " + "Product " + testProductId + " was changed!!");
//		} else {
//			System.out.println("====> " + "Product " + testProductId + " does not exist!!");
//		}
//	}
	
//	@Test
//	public void testUpdateProductByName() {
//		String testProductName = "Persona 4 Golden";
//		Product product = productRepository.findByName(testProductName);
//		if (product != null) {
//			product.setName("Horizon Zero Dawn");
//			product.setPrice(1799);
//			product.setDeveloper("Guerrilla");
//			product.setPublisher("PlayStation Mobile, Inc.");
//			productRepository.save(product);
//			System.out.println("====> " + "Product " + testProductName + " was changed!!");
//		} else {
//			System.out.println("====> " + "Product " + testProductName + " does not exist!!");
//		}
//	}
	
//	@Test
//	public void testDeleteProduct() {
//		long testProductId = 65;
//		if (productRepository.findById(testProductId).isPresent()) {
//			productRepository.deleteById(testProductId);
//			System.out.println("====> " + "Product " + testProductId + " was deleted!!");
//		} else {
//			System.out.println("===> " + "Product " + testProductId + " does not exist!!");
//		}
//	}
}
