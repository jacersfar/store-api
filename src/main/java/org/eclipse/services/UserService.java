package org.eclipse.services;

import java.util.List;


import org.eclipse.daos.UserDAO;
import org.eclipse.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;
	
	@Transactional
	public List<User> find() {
		return this.userDAO.find();
	}
	
	@Transactional
	public User findById(long id) {
		return this.userDAO.findById(id);
	}
	
	@Transactional
	public void add(User user) {
		this.userDAO.add(user);
	}
	
	@Transactional
	public void update(User user) {
		this.userDAO.update(user);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void delete(User user) {
		this.userDAO.delete(user);
	}
	
	@Transactional
	public boolean authenticate(String email, String password) {
		for (User u: this.userDAO.find()) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password))
				return true;
		}
		return false;
	}
}
