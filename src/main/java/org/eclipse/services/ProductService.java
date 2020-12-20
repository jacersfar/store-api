package org.eclipse.services;

import java.util.List;

import javax.transaction.Transactional;

import org.eclipse.IDAO.IDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.eclipse.models.Product;

@Service
public class ProductService implements IService<Product>{
	@Autowired
	private IDAO<Product> productDAO;
	public ProductService() {}
	public ProductService(IDAO<Product> productDAO) {
		this.productDAO = productDAO;
	}
	
	@Transactional
	public List<Product> find() {
		return this.productDAO.find();
	}
	
	public Product findById(long id) {
		return this.productDAO.findById(id);
	}
	
	@Transactional
	public Product add(Product product) {
		return this.productDAO.add(product);
	}
	
	@Transactional
	public Product update(Product product) {
		return this.productDAO.update(product);
	}
	
	@Transactional
	public Product delete(Product product) {
		return this.productDAO.delete(product);
	}

	
}
