package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/login")
	public String viewLoginPage() {
		return "/security/login";
	}
	
	@GetMapping("/logout")
	public String viewLogoutPage() {
		return "/security/logout";
	}
	
	@GetMapping("/")
	public String viewHomePage() {
		return "/websites/homepage";
	}
}
