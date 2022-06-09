package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.DAO.UserDAO;
import com.revature.models.User;
import com.revature.services.AuthService;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
//		UserDAO ud = new UserDAO();
//		User u = new User(1,"Tomcat","yay");
//		ud.createUser(u);
	}

}
