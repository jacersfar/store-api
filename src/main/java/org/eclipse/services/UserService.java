package org.eclipse.services;

import java.util.List;

import org.eclipse.IDAO.IDAO;
import org.eclipse.daos.UserDAO;
import org.eclipse.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IService<User>{

	@Autowired
	IDAO<User> userDAO;
	
	public UserService(IDAO<User> userDAO) {
		this.userDAO = userDAO;
	}
	public UserService() {}
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
	public IDAO<User> getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(IDAO<User> userDAO) {
		this.userDAO = userDAO;
	}
	
}
