package org.eclipse.daos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.eclipse.IDAO.IDAO;
import org.eclipse.models.Order;

@Repository
public class OrderDAO implements IDAO<Order>{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Order> find() {
		return this.sessionFactory.getCurrentSession().createQuery("from Order").list();
	}
	@Override
	public Order findById(long id) {
		return (Order) this.sessionFactory.getCurrentSession().get(Order.class, id);
	}
	@Override
	public void add(Order object) {
		this.sessionFactory.getCurrentSession().save(object);
		
	}
	@Override
	public void delete(Order object) {
		this.sessionFactory.getCurrentSession().delete(object);
		
	}
	@Override
	public void update(Order object) {
		this.sessionFactory.getCurrentSession().update(object);
	}
}
