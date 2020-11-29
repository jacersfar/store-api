package org.eclipse.services;

import java.util.List;

import javax.transaction.Transactional;

import org.eclipse.daos.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.eclipse.models.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	@Transactional
	public List<Product> find() {
		return this.productDAO.find();
	}
	
	public Product findById(long id) {
		return this.productDAO.findById(id);
	}
	
	@Transactional
	public void add(Product product) {
		this.productDAO.add(product);
	}
	
	@Transactional
	public void update(Product product) {
		this.productDAO.update(product);
	}
	
	@Transactional
	public void delete(Product product) {
		this.productDAO.delete(product);
	}
}
