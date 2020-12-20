package org.eclipse.controllers;

import java.util.List;

import org.eclipse.models.Book;
import org.eclipse.models.Product;
import org.eclipse.services.IService;
import org.eclipse.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	private IService<Product> productService;

	@RequestMapping(method = RequestMethod.GET, value = "/all", produces = "application/json")
	public List<Product> find() {
		return this.productService.find();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/book/add", produces = "application/json")
	public Product add(@RequestBody Book book) {
		return this.productService.add(book);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/book/update", produces = "application/json")
	public Product update(@RequestBody Book book) {
		return this.productService.update(book);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/book/delete", produces = "application/json")
	public Product delete(@RequestBody Book book) {
		return this.productService.delete(book);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/get/{id}", produces = "application/json")
	public Product findById(@PathVariable long id) {
		return this.productService.findById(id);
	}
}
