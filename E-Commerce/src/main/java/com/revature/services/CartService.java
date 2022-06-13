package com.revature.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.DAO.ProductDAO;
import com.revature.DAO.UserDAO;
import com.revature.controllers.AuthController;
import com.revature.models.Product;

public class CartService {
	UserDAO ud;
	private ProductDAO pd;
	@Autowired
	public CartService(ProductDAO pDAO) {
		this.pd = pDAO;
	}

	ArrayList<Product> cartList;
	public ArrayList<Product> addToCart(int id){
		Product p = pd.getProductById(id);
		if(p.getProductName()!=null) {
		cartList.add(p);
		AuthController.u.setCart(cartList);
		ud.update(AuthController.u);
		return cartList;
		
		}else {
			return cartList;
		}
				
	}
}
