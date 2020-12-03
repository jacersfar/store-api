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
	public IDAO<Product> getProductDAO() {
		return productDAO;
	}
	public void setProductDAO(IDAO<Product> productDAO) {
		this.productDAO = productDAO;
	}
	
}
