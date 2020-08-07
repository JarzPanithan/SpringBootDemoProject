package com.example.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.ConfirmationToken;
import com.example.model.Role;
import com.example.model.User;
import com.example.model.UserRegister;
import com.example.repository.ConfirmationTokenRepository;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private EmailService emailService;
	
	@Override
	@Transactional
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	@Transactional
	public void saveUser(UserRegister userRegister) {
		User user = new User();
		user.setFirstName(userRegister.getFirstName());
		user.setLastName(userRegister.getLastName());
		user.setEmail(userRegister.getEmail());
		user.setPassword(bCryptPasswordEncoder.encode(userRegister.getPassword()));
		user.setRoles(Arrays.asList(new Role("ROLE_USER")));
		user.setEnabled(userRegister.isEnabled());
		userRepository.save(user);
		ConfirmationToken confirmationToken = new ConfirmationToken(user);
		confirmationTokenRepository.save(confirmationToken);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(userRegister.getEmail());
		mailMessage.setFrom("official@gmail.com");
		mailMessage.setSubject("Verify Email");
		mailMessage.setText("To confirm your account, please click here: " + "http://localhost:8082/confirm-account?token=" +
							confirmationToken.getconfirmationToken());
		emailService.sendEmail(mailMessage);
	}
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isEnabled(), 
			   true, true, true, grantedAuthorities);
	}
	
	@Override
	@Transactional
	public void enabledRegisterUser(User user) {
		userRepository.save(user);
	}
	
	@Override
	@Transactional
	public ConfirmationToken findByConfirmationToken(String confirmationToken) {
		return confirmationTokenRepository.findByConfirmationToken(confirmationToken);
	}
	
	@Override
	@Transactional
	public void resetPassword(User user) {
		User existUser = userRepository.findByEmail(user.getEmail());
		ConfirmationToken confirmationToken = new ConfirmationToken(existUser);
		confirmationTokenRepository.save(confirmationToken);
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getEmail());
		mailMessage.setFrom("official@gmail.com");
		mailMessage.setSubject("Reset Password");
		mailMessage.setText("To complete the password reset process, please click here: " + "http://localhost:8082/confirm-reset?token=" +
							confirmationToken.getconfirmationToken());
		emailService.sendEmail(mailMessage);
	}
}
