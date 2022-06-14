package com.revature.services;

<<<<<<< HEAD
import java.util.List;
=======
import com.revature.models.User;	
import com.revature.DAO.UserDAO;
>>>>>>> 42e1d4fb24d3bf17740b254bc5e523c5a2d36518

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.DAO.UserDAO;
import com.revature.models.User;

@Service
public class UserService {
private UserDAO ud;
	@Autowired
	public UserService(UserDAO uDAO) {
		this.ud= uDAO;
	}
	
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
