package com.revature.services;

import com.revature.models.User;	
import com.revature.DAO.UserDAO;

public class UserService {
UserDAO ud = new UserDAO();
	
	public User getUserByUsername(String username) {
		return ud.getUserByUsername(username);
	}
	public User getUserById(int id) {
		return ud.getUserById(id);
	}
}
