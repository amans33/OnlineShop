package com.account.springjwt.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.account.springjwt.models.User;
import com.account.springjwt.payload.request.LoginRequest;
import com.account.springjwt.repository.UserRepository;



@Service
public class ForgotPasswordService {
	@Autowired
	private UserRepository userRepo;

	public Boolean resetPassword(LoginRequest request) {
		Optional<User> user = userRepo.findByUsername(request.getUsername());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (user.isPresent()) {
			user.get().setPassword(passwordEncoder.encode(request.getPassword()));
			userRepo.save(user.get());
			return true;
		} else {
			throw new UsernameNotFoundException("User is Not Present With UserName : " + request.getUsername());
		}
	}

}
