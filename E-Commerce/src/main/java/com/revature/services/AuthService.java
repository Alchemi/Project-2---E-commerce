package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class AuthService {
UserDAO ud = new UserDAO();
	
	//User enters username and password, user is grabbed by username if password matches password in database successful login
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
	//Allow user to create acount if username does not already exist
	public void register(User userToBeRegistered) {
		if(ud.getUserByUsername(userToBeRegistered.getUsername()) != null) {
			throw new NullPointerException("Username is already taken");
		}
		ud.createUser(userToBeRegistered);
		System.out.println("User successfully registered");
		
	}

}
