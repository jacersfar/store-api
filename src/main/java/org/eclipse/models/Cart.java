package org.eclipse.models;

import java.util.ArrayList;

public class Cart {
	private ArrayList<OrderLine> cartItems;
	
	public Cart(ArrayList<OrderLine> cartItems) {
		this.cartItems = cartItems;
	}
	
	public Cart() {
		this.cartItems = new ArrayList<OrderLine>();
	}
	
	public ArrayList<OrderLine> getCartItems() {
		return this.cartItems;
	}
	
	public void addProduct(Product product, int quantity) {
		for (OrderLine cartItem: this.cartItems) {
			if (cartItem.getProduct().equals(product)) {
				cartItem.getProduct().setQuantity(cartItem.getProduct().getQuantity() + quantity);
				return;
			}
		}
		this.cartItems.add(new OrderLine(product ,quantity));
	}
	
	public void deleteProduct(Product product) {
		for (OrderLine cartItem: this.cartItems) {
			if (cartItem.getProduct().equals(product)) {
				this.cartItems.remove(cartItem);
				return;
			}
		}
	}
}
