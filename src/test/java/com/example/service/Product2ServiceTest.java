package com.example.service;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.SpringBootDemoApplicationTests;
import com.example.model.Product2;

public class Product2ServiceTest extends SpringBootDemoApplicationTests {
	@Autowired
	private Product2Service product2Service;
	
// 	@Test
// 	public void testGetAllProducts() {
// 		product2Service.getAllProducts2();
// 		System.out.println("====> " + "Products: " + product2Service.getAllProducts2().size());
// 	}
	
// 	@Test
// 	public void testGetProductById() {
// 		long testProductId = 74;
// 		Optional<Product2> product = product2Service.getProduct2ById(testProductId);
// 		if (product.isPresent()) {
// 			System.out.println("====> " + "Product: " + testProductId + " was found!!");
// 		} else {
// 			System.out.println("====> " + "Product: " + testProductId + " does not exists!!");
// 		}
// 	}
	
// 	@Test
// 	public void testGetProductByName() {
// 		String testProductName = "IPhone X";
// 		if (product2Service.getProduct2ByName(testProductName) != null) {
// 			System.out.println("====> " + "Product: " + testProductName + " was found!!");
// 		} else {
// 			System.out.println("====> " + "Product: " + testProductName + " does not exists!!");
// 		}
// 	}
	
// 	@Test
// 	public void testSaveProduct() {
// 		Product2 newProduct = new Product2();
// 		newProduct.setProductCode("J01-722");
// 		newProduct.setProductName("Huawei Nova 7I");
// 		newProduct.setProductPrice(25000);
// 		newProduct.setProductAddress("Udon-Thani");
// 		product2Service.saveProduct2(newProduct);
// 		System.out.println("====> " + "Product was saved!!");
// 	}
	
// 	@Test
// 	public void testUpdateProductById() {
// 		long testProductId = 75;
// 		Optional<Product2> oldProduct = product2Service.getProduct2ById(testProductId);
// 		if (oldProduct.isPresent()) {
// 			Product2 editProduct = oldProduct.get();
// 			editProduct.setProductCode("X57-694");
// 			editProduct.setProductName("Oppo A5 2020");
// 			editProduct.setProductPrice(23000);
// 			editProduct.setProductAddress("Udon-Thani");
// 			product2Service.updateProduct2(editProduct);
// 			System.out.println("====> " + "Product: " + testProductId + " was changed!!");
// 		} else {
// 			System.out.println("====> " + "Product: " + testProductId + " does not exists!!");
// 		}
// 	}
	
// 	@Test
// 	public void testUpdateProductByName() {
// 		String testProductName = "Huawei Nova 7I";
// 		Product2 editProduct = product2Service.getProduct2ByName(testProductName);
// 		if (editProduct != null) {
// 			editProduct.setProductCode("X57-694");
// 			editProduct.setProductName("Oppo A5 2020");
// 			editProduct.setProductPrice(23000);
// 			editProduct.setProductAddress("Udon-Thani");
// 			product2Service.updateProduct2(editProduct);
// 			System.out.println("====> " + "Product: " + testProductName + " was changed!!");
// 		} else {
// 			System.out.println("====> " + "Product: " + testProductName + " does not exists!!");
// 		}
// 	}
	
// 	@Test
// 	public void testDeleteProduct() {
// 		long testProductId = 77;
// 		Optional<Product2> product = product2Service.getProduct2ById(testProductId);
// 		if (product.isPresent()) {
// 			product2Service.deleteProduct2(testProductId);
// 			System.out.println("====> " + "Product: " + testProductId + " was deleted!!");
// 		} else {
// 			System.out.println("====> " + "Product: " + testProductId + " does not exists!!");
// 		}
// 	}
}
