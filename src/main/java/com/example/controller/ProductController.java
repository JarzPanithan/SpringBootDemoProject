package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import com.example.model.Product;
import com.example.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/productpage")
	public ModelAndView viewProductPage() {
		List<Product> product = productService.getProducts();
		ModelAndView mv = new ModelAndView();
		mv.addObject("products", product);
		mv.setViewName("websites/product/productpage");
		return mv;
	}
	
	@GetMapping("/addpage")
	public ModelAndView viewAddPage() {
		Product product = new Product();
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", product);
		mv.setViewName("websites/product/addpage");
		return mv;
	}
	
	@PostMapping("/save")
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/websites/product/addpage";
		}
		productService.saveProduct(product);
		return "websites/product/success";
	}
	
	@GetMapping("/save_success")
	public String viewSaveSuccessPage() {
		return "websites/product/success";
	}
	
	@GetMapping(value = "/edit", params = "id")
	public ModelAndView viewEditPageById(@RequestParam("id") Long id) {
		Optional<Product> product = productService.getProductById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", product);
		mv.setViewName("websites/product/editpage");
		return mv;
	}
	
	@GetMapping(value = "/edit", params = "name")
	public ModelAndView viewEditPageByName(@RequestParam("name") String name) {
		Product product = productService.getProductByName(name);
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", product);
		mv.setViewName("websites/product/editpage");
		return mv;
	}
	
	@PostMapping("/update")
	public String updateProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/websites/product/editpage";
		}
		productService.saveProduct(product);
		return "websites/product/success_update";
	}
	
	@GetMapping("/update_success")
	public String viewUpdateSuccessPage() {
		return "websites/product/success_update";
	}
	
	@GetMapping("/remove/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return "websites/product/success_delete";
	}
	
	@GetMapping("/delete_success")
	public String viewDeletePage() {
		return "websites/product/success_delete";
	}
}
