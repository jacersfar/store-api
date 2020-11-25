package org.eclipse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.eclipse.services.UserService;

import java.util.List;

import org.eclipse.models.Admin;
import org.eclipse.models.Client;
import org.eclipse.models.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET, produces = "application/json")
	public List<User> find() {
		return this.userService.find();
	}
	
	@RequestMapping(value="/add/client", method=RequestMethod.POST)
	public void addUser(@RequestBody Client client) {
		this.userService.addUser(client);
	}
	
	@RequestMapping(value="/add/admin", method=RequestMethod.POST)
	public void addUser(@RequestBody Admin admin) {
		this.userService.addUser(admin);
	}
	
	@RequestMapping(value="/update/client", method=RequestMethod.PUT)
	public void updateUser(@RequestBody Client client) {
		this.userService.updateUser(client);
	}
	
	@RequestMapping(value="/update/admin", method=RequestMethod.PUT)
	public void updateUser(@RequestBody Admin admin) {
		this.userService.updateUser(admin);
	}
	
	@RequestMapping(value="/delete/client", method=RequestMethod.DELETE)
	public void deleteUser(@RequestBody Client client) {
		this.userService.deleteUser(client);
	}
	
	@RequestMapping(value="/delete/admin", method=RequestMethod.DELETE) 
	public void deleteUser(@RequestBody Admin admin ){
		this.userService.deleteUser(admin);
	}
	
	@RequestMapping(value="/authenticate", produces = "application/json", method=RequestMethod.GET)
	public boolean authenticate(@RequestParam String email, @RequestParam String password) {
		return this.userService.authenticate(email, password);
	}
}
