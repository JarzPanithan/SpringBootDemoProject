package com.example.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.model.ConfirmationToken;
import com.example.model.User;
import com.example.model.UserRegister;

public interface UserService extends UserDetailsService {
	public User findByEmail(String email);
	
	public void saveUser(UserRegister userRegister);
	
	public void enabledRegisterUser(User user);
	
	public ConfirmationToken findByConfirmationToken(String confirmationToken);
	
	public void resetPassword(User user);
}
