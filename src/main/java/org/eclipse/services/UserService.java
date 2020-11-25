package org.eclipse.services;

import java.util.List;


import org.eclipse.daos.UserDAO;
import org.eclipse.models.Admin;
import org.eclipse.models.Client;
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
		return userDAO.find();
	}
	
	@Transactional
	public void addUser(Client user) {
		userDAO.addUser(user);
	}
	
	@Transactional
	public void addUser(Admin user) {
		userDAO.addUser(user);
	}
	
	@Transactional
	public void updateUser(Client user) {
		userDAO.updateUser(user);
	}
	
	@Transactional
	public void updateUser(Admin user) {
		userDAO.updateUser(user);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public void deleteUser(Client user) {
		userDAO.deleteUser(user);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public void deleteUser(Admin user) {
		userDAO.deleteUser(user);
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
