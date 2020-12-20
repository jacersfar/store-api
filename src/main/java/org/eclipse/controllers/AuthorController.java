package org.eclipse.controllers;

import java.util.List;

import org.eclipse.models.Author;
import org.eclipse.models.Order;
import org.eclipse.services.IService;
import org.eclipse.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
@CrossOrigin(origins = "*")
public class AuthorController {
	@Autowired
	private IService<Author> authorService;
	

	@RequestMapping(value = "/find", method = RequestMethod.GET, produces = "application/json")
	public List<Author> find() {
		return this.authorService.find();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public Author add(@RequestBody Author author) {
		return this.authorService.add(author);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.PUT, produces = "application/json")
	public Author update (@RequestBody Author author) {
		return this.authorService.update(author);
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST, produces = "application/json")
	public Author delete(@RequestBody Author author) {
		return this.authorService.delete(author);
	}
	
	@RequestMapping(value="/find/{id}", method = RequestMethod.GET, produces = "application/json")
	public Author findById(@PathVariable long id) {
		return this.authorService.findById(id);
	}
}
