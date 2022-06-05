package com.revature.repositories;

import java.util.List;


import org.hibernate.Session;

import com.revature.model.User;
import com.revature.utilities.HibernateUtil;

public class UserDAO {

	public void createUser(User user) {
		Session ses = HibernateUtil.getSession();
		ses.save(user);
		HibernateUtil.closeSession();
	}
	public User getUserByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		User user = ses.get(User.class, username);
		HibernateUtil.closeSession();
		return user;
	}
	public User getUserById(int id) {
		Session ses = HibernateUtil.getSession();
		User user = ses.get(User.class, id);
		HibernateUtil.closeSession();
		return user;
	}
	public List<User> getAllUsers(){
		Session ses = HibernateUtil.getSession();
		List<User> userList = ses.createQuery("FROM User").list();
		HibernateUtil.closeSession();
		return userList;

	}

}
