package org.eclipse.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="client")
public class Client extends User {
	@Column(name="name")
	private String name;
	
	private boolean admin = false;
	
	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="client", updatable = false, insertable =false)
	private List<Order> orderList;
	
	@Transient
	private Cart cart;
	
	public Client(long id, String email, String password, String name, List<Order> orderList, Cart cart) {
		super(id, email, password);
		this.name = name;
		this.orderList = orderList;
		this.cart = cart;
	}
	

	public Client() {
		super();
	}


	public Client(long id, String email, String password) {
		super(id, email, password);
	}


	public Client(long id, String email, String password, String name) {
		super(id, email, password);
		this.name = name;
		this.orderList = new ArrayList<Order>();
		this.cart = new Cart();
	}

	public void submitCart() {
		this.orderList.add(new Order(
					Calendar.getInstance(),
					"PENDING",
					this,
					this.cart.getCartItems()
				));
		this.cart = new Cart();
	}
	public void AddToCart(Product product, int quantity) {
		this.cart.addProduct(product, quantity);
	}
	public void deleteFromCart(Product product) {
		this.cart.deleteProduct(product);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	public void addOrder(Order order) {
		this.orderList.add(order);
	}
	public void removeOrder(int idOrder) {
		for(Order f: this.orderList) {
			if (f.getId() == idOrder) {
				this.orderList.remove(f);
				return;
			}
		}
	}
	public void removeOrder(Order order) {
		for (Order f: this.orderList) {
			if (f.getId() == order.getId()) {
				this.orderList.remove(f);
				return;
			}
		}
	}

	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	@Override
	public String toString() {
		return "Client [name=" + name + ", orderList=" + orderList + ", cart=" + cart + ", id=" + id + ", email="
				+ email + ", password=" + password + "]";
	}
	
	
}
