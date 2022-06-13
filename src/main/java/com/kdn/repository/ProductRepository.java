package com.kdn.repository;

import java.util.Map;

import com.kdn.model.Product;

public interface ProductRepository {
	
	public Map<Long, Product> get();	
	public Product add(Product product);
	public Product update(Product product);	
	public Product get(long id);	
	public Product delete(long id);

}
