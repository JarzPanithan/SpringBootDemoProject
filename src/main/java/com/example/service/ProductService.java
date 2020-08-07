package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.exception.MyExceptionHandler;
import com.example.exception.ProductNotFoundHandler;
import com.example.model.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProducts() throws ProductNotFoundHandler, MyExceptionHandler {
		return productRepository.findAll();
	}
	
//	public Product getProductById(@RequestParam("id") Long id) throws ProductNotFoundHandler, MyExceptionHandler {
//		return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundHandler(id));
//	}
	
	public Optional<Product> getProductById(@RequestParam("id") Long id) throws ProductNotFoundHandler, MyExceptionHandler {
		return productRepository.findById(id);
	}
	
	public Product getProductByName(@RequestParam("name") String name) throws ProductNotFoundHandler, MyExceptionHandler {
		return productRepository.findByName(name);
	}
	
	public Product saveProduct(Product product) throws MyExceptionHandler {
		return productRepository.save(product);
	}
	
	public Product updateProduct(Product product) throws MyExceptionHandler {
		return productRepository.save(product);
	}
	
	public void deleteProduct(@PathVariable("id") Long id) throws MyExceptionHandler {
		productRepository.deleteById(id);
	}
	
	public Product getNullProduct() throws ProductNotFoundHandler {
		return null;
	}
	
	public Product getProductException() throws MyExceptionHandler {
		throw new MyExceptionHandler();
	}
}
