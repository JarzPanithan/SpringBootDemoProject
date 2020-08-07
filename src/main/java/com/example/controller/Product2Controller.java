package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Product2;
import com.example.service.Product2Service;

@Controller
@RequestMapping("/product2")
public class Product2Controller {
	@Autowired
	private Product2Service product2Service;
	
	@GetMapping("/productpage2")
	public ModelAndView viewProduct2Page() {
		List<Product2> product = product2Service.getAllProducts2();
		ModelAndView mv = new ModelAndView();
		mv.addObject("products", product);
		mv.setViewName("websites/product2/productpage");
		return mv;
	}
	
	@GetMapping("/addpage2")
	public ModelAndView viewProduct2AddPage() {
		Product2 product = new Product2();
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", product);
		mv.setViewName("websites/product2/addpage");
		return mv;
	}
	
	@PostMapping("/saveproduct2")
	public String saveProduct2(@Valid @ModelAttribute("product") Product2 product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "websites/product2/addpage";
		}
		product2Service.saveProduct2(product);
		return "websites/product2/success2";
	}
	
	@GetMapping("/save_success2")
	public String viewSaveSuccess2Page() {
		return "websites/product2/success2";
	}
	
	@GetMapping(value = "/edit", params = "id")
	public ModelAndView viewEditProduct2ById(@RequestParam("id") Long productId) {
		Optional<Product2> product = product2Service.getProduct2ById(productId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", product);
		mv.setViewName("websites/product2/editpage");
		return mv;
	}
	
	@GetMapping(value = "/edit", params = "name")
	public ModelAndView viewEditProduct2ByName(@RequestParam("name") String productName) {
		Product2 product = product2Service.getProduct2ByName(productName);
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", product);
		mv.setViewName("websites/product2/editpage");
		return mv;
	}
	
	@PostMapping("/updateproduct2")
	public String updateProduct(@Valid @ModelAttribute("product") Product2 product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "websites/product2/editpage";
		}
		product2Service.updateProduct2(product);
		return "websites/product2/success_update2";
	}
	
	@GetMapping("/update_success2")
	public String viewUpdateSuccess2Page() {
		return "websites/product2/success_update2";
	}
	
	@GetMapping("/remove/{id}")
	public String deleteProduct(@PathVariable("id") Long productId) {
		product2Service.deleteProduct2(productId);
		return "websites/product2/success_delete2";
	}
	
	@GetMapping("/delete_success2")
	public String viewDeleteSuccess2Page() {
		return "websites/product2/success_delete2";
	}
}
