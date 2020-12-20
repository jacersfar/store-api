package org.eclipse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.eclipse.services.IService;
import org.eclipse.services.UserService;

import java.util.List;

import org.eclipse.models.Admin;
import org.eclipse.models.Client;
import org.eclipse.models.User;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET, produces = "application/json")
	public List<User> find() {
		return this.userService.find();
	}
	
	@RequestMapping(value="/get/{id}", method = RequestMethod.GET, produces = "application/json")
	public User findById(@PathVariable long id) {
		return this.userService.findById(id);
	}
	
	@RequestMapping(value="/add/client", method=RequestMethod.POST, produces = "application/json")
	public Client add(@RequestBody Client client) {
		return (Client) this.userService.add(client);
	}
	
	@RequestMapping(value="/add/admin", method=RequestMethod.POST, produces = "application/json")
	public User add(@RequestBody Admin admin) {
		return this.userService.add(admin);
	}
	
	@RequestMapping(value="/update/client", method=RequestMethod.PUT, produces = "application/json")
	public Client update(@RequestBody Client client) {
		return (Client) this.userService.update(client);
	}
	
	@RequestMapping(value="/update/admin", method=RequestMethod.PUT, produces = "application/json")
	public User update(@RequestBody Admin admin) {
		return this.userService.update(admin);
	}
	
	@RequestMapping(value="/delete/client", method=RequestMethod.DELETE, produces = "application/json")
	public Client delete(@RequestBody Client client) {
		return (Client) this.userService.delete(client);
	}
	
	@RequestMapping(value="/delete/admin", method=RequestMethod.DELETE, produces = "application/json") 
	public User delete(@RequestBody Admin admin ){
		return this.userService.delete(admin);
	}
	
	@RequestMapping(value="/authenticate", produces = "application/json", method=RequestMethod.GET)
	public User authenticate(@RequestParam String email, @RequestParam String password) {
		return this.userService.authenticate(email, password);
	}
}
