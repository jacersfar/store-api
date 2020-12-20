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
public class UserService{

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
	public User add(User user) {
		return this.userDAO.add(user);
	}
	@Transactional
	public User update(User user) {
		return this.userDAO.update(user);
	}
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public User delete(User user) {
		return this.userDAO.delete(user);
	}
	@Transactional
	public User authenticate(String email, String password) {
		for (User u: this.userDAO.find()) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password))
				return u;
		}
		return null;
	}
}
