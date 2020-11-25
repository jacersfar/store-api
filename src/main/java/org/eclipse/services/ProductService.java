package org.eclipse.services;

import java.util.List;

import javax.transaction.Transactional;

import org.eclipse.daos.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.eclipse.models.Book;
import org.eclipse.models.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	@Transactional
	public List<Product> find() {
		return this.productDAO.find();
	}
	
	@Transactional
	public void addProduct(Book book) {
		this.productDAO.addProduct(book);
	}
	
	@Transactional
	public void updateProduct(Book book) {
		this.productDAO.updateProduct(book);
	}
	
	@Transactional
	public void deleteProduct(Book book) {
		this.productDAO.deleteProduct(book);
	}
}
