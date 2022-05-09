package com.account.springjwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.springjwt.payload.request.LoginRequest;
import com.account.springjwt.security.services.ForgotPasswordService;

@RestController
@RequestMapping("/api")
public class ForgotPasswordController {
	
	@Autowired
	private ForgotPasswordService forgotPasswordService;
	
	@PutMapping("/rest/password")
	public ResponseEntity<Boolean> forgotPassword(@RequestBody LoginRequest request){
		Boolean response = forgotPasswordService.resetPassword(request);
		return new ResponseEntity<Boolean>(response,HttpStatus.OK);
	}   
}
