package com.kdn.repository.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.kdn.model.Product;
import com.kdn.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private static Map<Long, Product> PRODUCT_MAP = new HashMap<>();
	static {

		PRODUCT_MAP.put(1L,
				new Product(1L, "Women's Tropical Print Tiered Midi Skirt - Tabitha Brown for Target Blue/Pink", 32.00,
						null));
		PRODUCT_MAP.put(2L, new Product(2L,
				"Women's Floral Print Puff Sleeve Tie-Back Midi Dress - Tabitha Brown for Target Orange/Blue", 12.50,
				null));
		PRODUCT_MAP.put(3L, new Product(3L, "Women's Margo Heels - A New Day™ Black", 12.50, null));
		PRODUCT_MAP.put(4L, new Product(4L, "Web Strap Patio Chair - Room Essentials™", 25.00, null));
		PRODUCT_MAP.put(5L, new Product(5L, "Backpack Beach Sand Chair - Blue - Sun Squad™", 30.00, null));
		PRODUCT_MAP.put(6L, new Product(6L, "24\" Jordan Counter Height Barstool Gray - Linon", 77.59, null));
		PRODUCT_MAP.put(7L, new Product(7L, "26\" Chevron Outdoor Wood Burning Fire Pit - Threshold™", 66.50, null));

	};

	@Override
	public Map<Long, Product> get() {
		return PRODUCT_MAP;
	}

	@Override
	public Product add(Product product) {
		if (product.getCreatedTs() == null) {
			product.setCreatedTs(new Date());
		}
		PRODUCT_MAP.put(product.getId(), product);
		return product;
	}

	@Override
	public Product update(Product product) {
		if (product.getUpdatedTs() == null) {
			product.setUpdatedTs(new Date());
		}
		PRODUCT_MAP.put(product.getId(), product);
		return product;
	}

	@Override
	public Product get(long id) {
		Product product = PRODUCT_MAP.get(id);
		return product;
	}

	@Override
	public Product delete(long id) {
		Product product = PRODUCT_MAP.get(id);
		Optional.ofNullable(product).ifPresent(p -> {
			if (product.getUpdatedTs() == null) {
				product.setUpdatedTs(new Date());
			}
			product.setUpdatedTs(new Date());
			p.setStatus("D");
		});
		return product;
	}

}
