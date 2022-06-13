package com.kdn.services;

import java.util.List;

import com.kdn.model.Product;

public interface ProductService {

	public List<Product> get();
	public Product get(long id);
	public Product add(Product product);
	public Product update(Product product);
	public Product delete(long id);
}
