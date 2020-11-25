package org.eclipse.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.eclipse.models.Admin;
import org.eclipse.models.Client;
import org.eclipse.models.User;

@Repository
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<User> find() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from User").list();
		return userList;
	}
	
	public void addUser(Client user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
	}
	
	public void addUser(Admin admin) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(admin);
	}
	
	public void updateUser(Client client) {
		this.sessionFactory.getCurrentSession().update(client);
	}
	
	public void updateUser(Admin admin) {
		this.sessionFactory.getCurrentSession().update(admin);
	}
	
	public void deleteUser(Client client) {
		this.sessionFactory.getCurrentSession().delete(client);
	}
	
	public void deleteUser(Admin admin) {
		this.sessionFactory.getCurrentSession().delete(admin);
	}
}
