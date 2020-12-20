package org.eclipse.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.eclipse.IDAO.IDAO;
import org.eclipse.models.Admin;
import org.eclipse.models.Client;
import org.eclipse.models.User;

@Repository
public class UserDAO implements IDAO<User>{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> find() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from User").list();
		return userList;
	}
	@Override
	public User findById(long id) {
		return (User) this.sessionFactory.getCurrentSession().get(User.class, id);
	}
	@Override
	public User add(User object) {
		if (object instanceof Client)
			this.sessionFactory.getCurrentSession().save((Client) object);
		else if (object instanceof Admin) 
			this.sessionFactory.getCurrentSession().save((Admin) object);
		
		return object;
	}
	@Override
	public User delete(User object) {
		if (object instanceof Client)
			this.sessionFactory.getCurrentSession().delete((Client) object);
		else if (object instanceof Admin) 
			this.sessionFactory.getCurrentSession().delete((Admin) object);
		
		return object;
	}
	@Override
	public User update(User object) {
		if (object instanceof Client)
			this.sessionFactory.getCurrentSession().update((Client) object);
		else if (object instanceof Admin) 
			this.sessionFactory.getCurrentSession().update((Admin) object);
		return object;
	}
}
