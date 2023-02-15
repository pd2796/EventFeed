package com.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.model.Product;

@Component
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernate;

	@Transactional
	public void createProduct(Product product) {
		this.hibernate.saveOrUpdate(product);
	}

	public List<Product> getProducts() {
		List<Product> products = this.hibernate.loadAll(Product.class);
		return products;

	}

	@Transactional
	public void deleteProduct(int pid) {
		Product p = this.hibernate.load(Product.class, pid);
		this.hibernate.delete(p);
	}

	public Product getProduct(int pid) {
		return this.hibernate.get(Product.class, pid);

	}

}
