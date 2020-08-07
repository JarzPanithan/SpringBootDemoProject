package com.example.service;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.SpringBootDemoApplicationTests;
import com.example.model.Product;

public class ProductServiceTest extends SpringBootDemoApplicationTests {
	@Autowired
	private ProductService productService;
	
// 	@Test
// 	public void testGetAllProducts() {
// 		productService.getProducts();
// 		System.out.println("====> " + "Products: " + productService.getProducts().size());
// 	}
	
// 	@Test
// 	public void testGetProductById() {
// 		long testProductId = 65;
// 		Optional<Product> product = productService.getProductById(testProductId);
// 		if (product.isPresent()) {
// 			System.out.println("====> " + "Product: " + testProductId + " was found!!");
// 		} else {
// 			System.out.println("====> " + "Product: " + testProductId + " does not exist!!");
// 		}
// 	}
	
// 	@Test
// 	public void testGetProductByName() {
// 		String testProductName = "CODE VEIN";
// 		if (productService.getProductByName(testProductName) != null) {
// 			System.out.println("====> " + "Product: " + testProductName + " was found!!");
// 		} else {
// 			System.out.println("====> " + "Product: " + testProductName + " does not exist!!");
// 		}
// 	}
	
// 	@Test
// 	public void testSaveProduct() {
// 		Product newProduct = new Product();
// 		newProduct.setName("Persona 4 Golden");
// 		newProduct.setPrice(559);
// 		newProduct.setDeveloper("ATLUS");
// 		newProduct.setPublisher("SEGA Inc.");
// 		productService.saveProduct(newProduct);
// 		System.out.println("====> " + "Product was saved!!");
// 	}
	
// 	@Test
// 	public void testUpdateProductById() {
// 		long testProductId = 76;
// 		Optional<Product> oldProduct = productService.getProductById(testProductId);
// 		if (oldProduct.isPresent()) {
// 			Product editProduct = oldProduct.get();
// 			editProduct.setName("Horizon Zero Dawn");
// 			editProduct.setPrice(1799);
// 			editProduct.setDeveloper("Guerrilla");
// 			editProduct.setPublisher("PlayStation Mobile, Inc.");
// 			productService.updateProduct(editProduct);
// 			System.out.println("====> " + "Product: " + testProductId + " was changed!!");
// 		} else {
// 			System.out.println("====> " + "Product: " + testProductId + " does not exist!!");
// 		}
// 	}
	
// 	@Test
// 	public void testUpdateProductByName() {
// 		String testProductName = "Horizon Zero Dawn";
// 		Product editProduct = productService.getProductByName(testProductName);
// 		if (editProduct != null) {
// 			editProduct.setName("Sea Of Thieves");
// 			editProduct.setPrice(469);
// 			editProduct.setDeveloper("Rare Ltd.");
// 			editProduct.setPublisher("Xbox Game Studios");
// 			productService.updateProduct(editProduct);
// 			System.out.println("====> " + "Product: " + testProductName + " was changed!!");
// 		} else {
// 			System.out.println("====> " + "Product: " + testProductName + " does not exist!!");
// 		}
// 	}
	
// 	@Test
// 	public void testDeleteProduct() {
// 		long testProductId = 76;
// 		Optional<Product> product = productService.getProductById(testProductId);
// 		if (product.isPresent()) {
// 			productService.deleteProduct(testProductId);
// 			System.out.println("====> " + "Product " + testProductId + " was deleted!!");
// 		} else {
// 			System.out.println("===> " + "Product " + testProductId + " does not exist!!");
// 		}
// 	}
}
