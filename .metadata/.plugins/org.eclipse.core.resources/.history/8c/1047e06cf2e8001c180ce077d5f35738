package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.User;
import com.revature.services.AuthService;
@Controller
@ResponseBody
@RequestMapping(value="/authcontroller")
@CrossOrigin
public class AuthController {

	private AuthService as;
	
	
	@Autowired
	public AuthController(AuthService service) {
		this.as = service;
	}
	
	
	@PostMapping
	public ResponseEntity<User> register(@RequestBody User user){
		System.out.println(user.getPassword());
		
		if(user.getUsername() == null) {
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(user);
		}else {
			
			as.register(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}
	}
}
