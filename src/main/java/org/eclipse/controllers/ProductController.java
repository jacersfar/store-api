package org.eclipse.controllers;

import java.util.List;

import org.eclipse.models.Book;
import org.eclipse.models.Product;
import org.eclipse.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/all", produces = "application/json")
	public List<Product> find() {
		return this.productService.find();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/book/add")
	public void add(@RequestBody Book book) {
		this.productService.add(book);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/book/update")
	public void update(@RequestBody Book book) {
		this.productService.update(book);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/book/delete")
	public void delete(@RequestBody Book book) {
		this.productService.delete(book);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/get/{id}", produces = "application/json")
	public Product findById(@PathVariable long id) {
		return this.productService.findById(id);
	}
}
