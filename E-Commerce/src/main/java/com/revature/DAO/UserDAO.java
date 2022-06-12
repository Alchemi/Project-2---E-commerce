package com.revature.DAO;

import java.util.ArrayList;

import java.util.List;


import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utilities.HibernateUtil;
@Repository
public class UserDAO {
	
//	private User u;
//	@Autowired
//	public UserDAO(User user) {
//		this.u = user;
//		
//	}
	
			
	public int register(User user) {
//		String pass = user.getPassword();
//		System.out.println(pass);
		try(Session session = HibernateUtil.getSession()) {
//			Query q = session.createQuery("INSERT INTO User (username, password)"+"SELECT(username,password) FROM User");
//			q.setParameter(0, user.getUsername());
//			q.setParameter(1,user.getPassword());
//			q.executeUpdate();
			//System.out.println(user.getUsername());
			user.setRole(Role.customer);
			session.save(user);
			//System.out.println(user.getUsername());

			HibernateUtil.closeSession();
			return 1;
		} catch(HibernateException e) {
			System.out.println("There was an error inserting the User");
			e.printStackTrace();
			return 0;
		}//look into insert

	}
	//gets user by username used for login authentication
	public User getUserByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		Query q = ses.createQuery("FROM User WHERE username = ?1");
		q.setParameter(1, username);
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
		User u = ses.get(User.class, id);
		HibernateUtil.closeSession();
		return u;

	}
	//returns a list of all users
	public List<User> getAllUsers(){
		Session ses = HibernateUtil.getSession();
		List<User> userList = ses.createQuery("FROM User").list();
		HibernateUtil.closeSession();
		return userList;

	}
}