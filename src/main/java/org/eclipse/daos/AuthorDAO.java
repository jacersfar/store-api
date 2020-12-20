package org.eclipse.daos;

import java.util.List;

import org.eclipse.IDAO.IDAO;
import org.eclipse.models.Author;
import org.eclipse.models.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDAO implements IDAO<Author>{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Author findById(long id) {
		return (Author) this.sessionFactory.getCurrentSession().get(Author.class, id);
	}

	@Override
	public List<Author> find() {
		return this.sessionFactory.getCurrentSession().createQuery("from Author").list();
	}

	@Override
	public Author add(Author object) {
		this.sessionFactory.getCurrentSession().save(object);
		return object;
	}

	@Override
	public Author delete(Author object) {
		this.sessionFactory.getCurrentSession().delete(object);
		return object;
	}

	@Override
	public Author update(Author object) {
		this.sessionFactory.getCurrentSession().update(object);
		return object;
	}
}
