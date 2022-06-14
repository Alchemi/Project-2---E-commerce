package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.DAO.UserDAO;
import com.revature.models.User;

@Service
public class UserService {
UserDAO ud = new UserDAO();
	
	public User getUserByUsername(String username) {
		return ud.getUserByUsername(username);
	}
	public User getUserById(int id) {
		return ud.getUserById(id);
	}
	public List<User> getAllUsers(){
		return ud.getAllUsers();
	}
}
