package org.eclipse.controllers;

import java.util.List;

import org.eclipse.models.Book;
import org.eclipse.models.Product;
import org.eclipse.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
	public void addProduct(@RequestBody Book book) {
		this.productService.addProduct(book);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/book/update")
	public void updateProduct(@RequestBody Book book) {
		this.productService.updateProduct(book);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/book/delete")
	public void deleteProduct(@RequestBody Book book) {
		this.productService.deleteProduct(book);
	}
}
