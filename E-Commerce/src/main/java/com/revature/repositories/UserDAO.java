package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.utilities.HibernateUtil;
@Repository
public class UserDAO {
	public void createUser(User user) {
		Session ses = HibernateUtil.getSession();
		ses.save(user);
		HibernateUtil.closeSession();
	}
	//gets user by username used for login authentication
	public User getUserByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		Query q = ses.createQuery("FROM User user WHERE user.username = ?0");
		q.setParameter(0, username);
		try {
		List<User> userList = q.getResultList();
		HibernateUtil.closeSession();
		User user = userList.get(0);
		System.out.println("user exists");
		return user;
		} catch(Exception e) {
			return null;
		}
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
