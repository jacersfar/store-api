package org.eclipse.daos;

import java.util.List;

import org.eclipse.models.Book;
import org.eclipse.models.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Product> find() {
		return this.sessionFactory.getCurrentSession().createQuery("from Product").list();
	}
	
	public void addProduct(Book book) {
		this.sessionFactory.getCurrentSession().save(book);
	}
	
	public void updateProduct(Book book) {
		this.sessionFactory.getCurrentSession().update(book);
	}
	
	public void deleteProduct(Book book) {
		this.sessionFactory.getCurrentSession().delete(book);
	}
}
