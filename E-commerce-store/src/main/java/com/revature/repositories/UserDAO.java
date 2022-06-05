package com.revature.repositories;

import java.util.List;


import org.hibernate.Session;

import com.revature.model.User;
import com.revature.utilities.HibernateUtil;

public class UserDAO {
	//creates user passed in from authservice register method
	public void createUser(User user) {
		Session ses = HibernateUtil.getSession();
		ses.save(user);
		HibernateUtil.closeSession();
	}
	//gets user by username used for login authentication
	public User getUserByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		User user = ses.get(User.class, username);
		HibernateUtil.closeSession();
		return user;
	}
	//gets user by id
	public User getUserById(int id) {
		Session ses = HibernateUtil.getSession();
		User user = ses.get(User.class, id);
		HibernateUtil.closeSession();
		return user;
	}
	//returns a list of all users
	public List<User> getAllUsers(){
		Session ses = HibernateUtil.getSession();
		List<User> userList = ses.createQuery("FROM User").list();
		HibernateUtil.closeSession();
		return userList;

	}

}
