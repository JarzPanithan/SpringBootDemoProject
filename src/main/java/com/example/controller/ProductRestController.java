package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.MyExceptionHandler;
import com.example.exception.ProductNotFoundHandler;
import com.example.model.Product;
import com.example.service.ProductService;

@RestController
public class ProductRestController {
	@Autowired
	private ProductService productService;
	
//	@GetMapping("/product")
//	public ResponseEntity<List<Product>> allProducts() throws ProductNotFoundHandler, MyExceptionHandler {
//		List<Product> products = productService.getProducts();
//		try {
//			if (products == null) {
//				throw new ProductNotFoundHandler();
//			}
//		} catch (MyExceptionHandler ex) {
//			throw new MyExceptionHandler();
//		}
//		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
//	}
	
	@PostMapping("/product")
	public List<Product> allProducts() {
		List<Product> products = productService.getProducts();
		System.out.println("Product Size: " + products.size());
		return products;
	}
	
//	@GetMapping(value = "/product", params = "id")
//	public ResponseEntity<Product> productById(@RequestParam("id") Long id) throws ProductNotFoundHandler, MyExceptionHandler {
//		Product product = productService.getProductById(id);
//		try {
//			if (product == null) {
//				throw new ProductNotFoundHandler();
//			}
//		} catch (MyExceptionHandler ex) {
//			throw new MyExceptionHandler();
//		}
//		return new ResponseEntity<Product>(product, HttpStatus.OK);
//	}
	
//	@GetMapping(value = "/product", params = "id")
//	public ResponseEntity<Optional<Product>> productById(@RequestParam("id") Long id) throws ProductNotFoundHandler, MyExceptionHandler {
//		Optional<Product> product = productService.getProductById(id);
//		try {
//			if (product == null) {
//				throw new ProductNotFoundHandler();
//			}
//		} catch (MyExceptionHandler ex) {
//			throw new MyExceptionHandler();
//		}
//		return new ResponseEntity<Optional<Product>>(product, HttpStatus.OK);
//	}
	
//	@GetMapping(value = "/product", params = "name")
//	public ResponseEntity<Product> productByName(@RequestParam("name") String name) throws ProductNotFoundHandler, MyExceptionHandler {
//		Product product = productService.getProductByName(name);
//		try {
//			if (product == null) {
//				throw new ProductNotFoundHandler();
//			}
//		} catch (MyExceptionHandler ex) {
//			throw new MyExceptionHandler();
//		}
//		return new ResponseEntity<Product>(product, HttpStatus.OK);
//	}
	
//	@PostMapping("/saveproduct")
//	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product newProduct) {
//		productService.saveProduct(newProduct);
//		return new ResponseEntity<Product>(newProduct, HttpStatus.OK);
//	}
	
//	@PutMapping(value = "/edit", params = "id")
//	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product editProduct) throws ProductNotFoundHandler {
//		try {
//			Product product = productService.getProductById(id);
//			product.setName(editProduct.getName());
//			product.setPrice(editProduct.getPrice());
//			product.setDeveloper(editProduct.getDeveloper());
//			product.setPublisher(editProduct.getPublisher());
//			productService.saveProduct(product);
//			return new ResponseEntity<Product>(product, HttpStatus.OK);
//		} catch (ProductNotFoundHandler ex) {
//			throw new ProductNotFoundHandler(id);
//		}
//	}
	
//	@PutMapping(value = "/edit", params = "id")
//	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product editProduct) throws ProductNotFoundHandler {
//		try {
//			Optional<Product> oldProduct = productService.getProductById(id);
//			Product product = oldProduct.get();
//			product.setName(editProduct.getName());
//			product.setPrice(editProduct.getPrice());
//			product.setDeveloper(editProduct.getDeveloper());
//			product.setPublisher(editProduct.getPublisher());
//			productService.saveProduct(product);
//			return new ResponseEntity<Product>(product, HttpStatus.OK);
//		} catch (ProductNotFoundHandler ex) {
//			throw new ProductNotFoundHandler(id);
//		}
//	}
	
//	@PutMapping("/edit/{name}")
//	public ResponseEntity<Product> updateProduct(@PathVariable("name") String name, @RequestBody Product editProduct) throws ProductNotFoundHandler {
//		try {
//			Product product = productService.getProductByName(name);
//			product.setName(editProduct.getName());
//			product.setPrice(editProduct.getPrice());
//			product.setDeveloper(editProduct.getDeveloper());
//			product.setPublisher(editProduct.getPublisher());
//			productService.saveProduct(product);
//			return new ResponseEntity<Product>(product, HttpStatus.OK);
//		} catch (ProductNotFoundHandler ex) {
//			throw new ProductNotFoundHandler(name);
//		}
//	}
	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) throws MyExceptionHandler {
//		try {
//			productService.deleteProduct(id);
//		} catch (MyExceptionHandler ex) {
//			throw new MyExceptionHandler();
//		}
//		return new ResponseEntity<Product>(HttpStatus.OK);
//	}
	
//	@GetMapping("/nullproduct")
//	public ResponseEntity<Product> getNullProduct() throws ProductNotFoundHandler, MyExceptionHandler {
//		Product product = productService.getNullProduct();
//		try {
//			if (product == null) {
//				throw new ProductNotFoundHandler();
//			}
//		} catch (MyExceptionHandler ex) {
//			throw new MyExceptionHandler();
//		}
//		return new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND);
//	}
	
//	@GetMapping("/productexception")
//	public ResponseEntity <Product> getProductException() throws ProductNotFoundHandler, MyExceptionHandler {
//		Product product = productService.getProductException();
//		try {
//			if (product == null) {
//				throw new ProductNotFoundHandler();
//			}
//		} catch (MyExceptionHandler ex) {
//			throw new MyExceptionHandler();
//		}
//		return new ResponseEntity<Product>(product, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}
