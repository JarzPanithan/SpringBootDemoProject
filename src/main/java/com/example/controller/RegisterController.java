package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.ConfirmationToken;
import com.example.model.User;
import com.example.model.UserRegister;
import com.example.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public ModelAndView viewRegisterPage() {
		ModelAndView model = new ModelAndView();
		UserRegister userRegister = new UserRegister();
		model.addObject("user", userRegister);
		model.setViewName("security/register");
		return model;
	}
	
//	@PostMapping("/register")
//	public String registerUser(@ModelAttribute("user") @Valid UserRegister userRegister, BindingResult result) {
//		User existing = userService.findByEmail(userRegister.getEmail());
//		if (existing != null) {
//			result.rejectValue("error", null, "This email is already use.");
//		}
//		if (result.hasErrors()) {
//			return "security/register";
//		}
//		userService.saveUser(userRegister);
//		return "redirect:/register?success";
//	}
	
	@PostMapping("/register")
	public ModelAndView registerUser(@Valid @ModelAttribute("user") UserRegister userRegister, BindingResult result) {
		ModelAndView model = new ModelAndView();
		User existing = userService.findByEmail(userRegister.getEmail());
		if (existing != null) {
			model.addObject("errorMessage", "This email is already use.");
			model.setViewName("errors/registerError");
			return model;
		}
		if (result.hasErrors()) {
			model.setViewName("security/register");
			return model;
		} else {
			userService.saveUser(userRegister);
			model.addObject("email", userRegister.getEmail());
			model.setViewName("security/registerSuccess");
		}
		return model;
	}
	
	@RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView confirmUserAccount(@RequestParam("token") String confirmationToken) {
		ModelAndView model = new ModelAndView();
		ConfirmationToken token = userService.findByConfirmationToken(confirmationToken);
		if (token != null) {
			User user = userService.findByEmail(token.getUser().getEmail());
			user.setEnabled(true);
			userService.enabledRegisterUser(user);
			model.setViewName("security/verify");
			return model;
		} else {
			model.addObject("errorMessage", "This link is invalid or broken!!");
			model.setViewName("errors/registerError");
		}
		return model;
	}
}
