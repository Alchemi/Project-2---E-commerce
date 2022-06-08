package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.User;
import com.revature.services.UserService;

@Controller
@ResponseBody
@RequestMapping(value="/user")
@CrossOrigin
public class UserController {
	private UserService us;
	
	@Autowired
	public UserController(UserService service) {
		this.us =service;
	}
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getAllUsers(){
		return us.getAllUsers();
		//this one works
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id){
		User u = us.getUserById(id);
		if(u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(u);
		}else {
			return ResponseEntity.ok(u);
		}
	}

}
