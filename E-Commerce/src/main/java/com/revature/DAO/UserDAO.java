package com.revature.DAO;

import java.util.List;

<<<<<<< HEAD
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.models.User;
import com.revature.utilities.HibernateUtil;
@Repository
public class UserDAO {
	private User u;
	
	@Autowired
	public UserDAO(User user){
		this.u = user;
	}
	
	
	public void createUser(User user) {
		try {
		Session ses = HibernateUtil.getSession();
		u = new User(user.getUsername(), user.getPassword());
		System.out.println(u.getUsername());
		System.out.println(u.getPassword());
		u.setId(2);
		HibernateUtil.getSession().save(user);
		ses.flush();
		HibernateUtil.closeSession();
		}catch(Exception e){
			System.out.println("User failed to add");
			e.printStackTrace();
		}
			
=======
import org.hibernate.Session;

import com.revature.models.User;
import com.revature.utilities.HibernateUtil;

public class UserDAO {
	public void createUser(User user) {
		Session ses = HibernateUtil.getSession();
		ses.save(user);
		HibernateUtil.closeSession();
>>>>>>> 42e1d4fb24d3bf17740b254bc5e523c5a2d36518
	}
	//gets user by username used for login authentication
	public User getUserByUsername(String username) {
		Session ses = HibernateUtil.getSession();
<<<<<<< HEAD
		Query q = ses.createQuery("FROM User use WHERE user.username = ?1");
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
		 u = ses.get(User.class, id);
		HibernateUtil.closeSession();
		return u;
=======
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
>>>>>>> 42e1d4fb24d3bf17740b254bc5e523c5a2d36518
	}
	//returns a list of all users
	public List<User> getAllUsers(){
		Session ses = HibernateUtil.getSession();
		List<User> userList = ses.createQuery("FROM User").list();
		HibernateUtil.closeSession();
		return userList;

	}
}
