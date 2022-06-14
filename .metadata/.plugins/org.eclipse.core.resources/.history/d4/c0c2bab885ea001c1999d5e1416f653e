package com.revature.models;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


	@Entity
	public class Cart implements Serializable {

		
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		private int id;
		@Column(name = "grand_total")
		private double grandTotal;
		@Column(name = "cart_lines")
		private int cartLines;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public double getGrandTotal() {
			return grandTotal;
		}

		public void setGrandTotal(double grandTotal) {
			this.grandTotal = grandTotal;
		}

		public int getCartLines() {
			return cartLines;
		}

		public void setCartLines(int cartLines) {
			this.cartLines = cartLines;
		}

		@Override
		public String toString() {
			return "Cart [id=" + id + ", grandTotal=" + grandTotal + ", cartLines=" + cartLines + "]";
		}
		
		// linking the cart with a user
		@OneToOne
		private User user;
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + cartLines;
			long temp;
			temp = Double.doubleToLongBits(grandTotal);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + id;
			result = prime * result + ((user == null) ? 0 : user.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cart other = (Cart) obj;
			if (cartLines != other.cartLines)
				return false;
			if (Double.doubleToLongBits(grandTotal) != Double.doubleToLongBits(other.grandTotal))
				return false;
			if (id != other.id)
				return false;
			if (user == null) {
				if (other.user != null)
					return false;
			} else if (!user.equals(other.user))
				return false;
			return true;
		}
		
}

