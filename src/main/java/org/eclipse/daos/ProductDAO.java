package org.eclipse.daos;

import java.util.List;

import org.eclipse.IDAO.IDAO;
import org.eclipse.models.Book;
import org.eclipse.models.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO implements IDAO<Product> {
	@Autowired
	SessionFactory sessionFactory;
	public ProductDAO() {}
	public ProductDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Product> find() {
		return this.sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	public Product findById(long id) {
		return (Product) this.sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public void add(Product object) {
		if (object instanceof Book)
			this.sessionFactory.getCurrentSession().save((Book)object);
		
	}

	@Override
	public void delete(Product object) {
		if (object instanceof Book)
			this.sessionFactory.getCurrentSession().delete((Book)object);
	}

	@Override
	public void update(Product object) {
		if (object instanceof Book)
			this.sessionFactory.getCurrentSession().update((Book)object);
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
