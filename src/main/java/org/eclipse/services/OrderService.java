package org.eclipse.services;

import java.util.List;

import org.eclipse.daos.OrderDAO;
import org.eclipse.models.Order;
import org.eclipse.models.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService implements IService<Order>{
	@Autowired
	private OrderDAO orderDAO;
	
	@Transactional
	public List<Order> find() {
		return this.orderDAO.find();
	}
	
	@Transactional
	public Order findById(long id) {
		return this.orderDAO.findById(id);
	}
	
	@Transactional
	public void add(Order order) {
		this.orderDAO.add(order);
	}
	
	@Transactional
	public void update(Order order) {
		this.orderDAO.update(order);
	}
	
	@Transactional
	public void delete(Order order) {
		this.orderDAO.delete(order);
	}
	
	@Transactional
	public double getTotalPriceOfOrder(long orderId) {
		double sum = 0;
		for (OrderLine orderLine: this.orderDAO.findById(orderId).getOrderLines())
			sum += orderLine.getProduct().getPrice() * orderLine.getQuantity();
		return sum;
	}
}
