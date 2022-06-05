package com.revature.services;

import com.revature.model.User;
import com.revature.repositories.UserDAO;

public class AuthService {
	UserDAO ud = new UserDAO();
	
	public User login(String username, String password) {
		User user;
		
		try {
			user = ud.getUserByUsername(username);
			if(user!=null && password.equals(user.getPassword())) {
				System.out.println("Logged in Successfully!");
				return user;
			}
			else if(user!=null && !password.equals(user.getPassword())) {
				System.out.println("Wrong Password");
				return null;
			}
			else {
				System.out.println("User does not exist");
				return null;
			}
			
			
		} catch(Exception e) {
			System.out.println("Login Unsuccesfull");
			e.printStackTrace();
		}
		return null;
	}
	
	public void register(User userToBeRegistered) {
		if(ud.getUserByUsername(userToBeRegistered.getUsername()) != null) {
			throw new NullPointerException("Username is already taken");
		}
		ud.createUser(userToBeRegistered);
		System.out.println("User successfully registered");
		
	}

}
