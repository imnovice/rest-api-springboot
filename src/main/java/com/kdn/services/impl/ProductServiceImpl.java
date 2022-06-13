package com.kdn.services.impl;

import static com.kdn.exception.ErrorCode.DUPLICATE_DATA_ERROR;
import static com.kdn.exception.ErrorCode.RECORD_NOT_FOUND_ERROR;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kdn.exception.ServiceException;
import com.kdn.model.Product;
import com.kdn.repository.ProductRepository;
import com.kdn.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> get() {
		return new ArrayList<Product>(productRepository.get().values());
	}

	@Override
	public Product get(long id) {
		//return productRepository.get(id);
		return Optional.ofNullable(productRepository.get(id))
				.orElseThrow(() -> new ServiceException(RECORD_NOT_FOUND_ERROR, NOT_FOUND, "Record not exist!"));
	}

	@Override
	public Product add(Product product) {
		Long id = product.getId();
		if (id == null) {
			product.setId(new Random().nextLong());
		} else {
			Map<Long, Product> map = productRepository.get();
			if (map.containsKey(product.getId())) {
				throw new ServiceException(DUPLICATE_DATA_ERROR, BAD_REQUEST, "Product ID already exist!");
			}
		}
		product.setCreatedTs(new Date());
		return productRepository.add(product);
	}

	@Override
	public Product update(Product product) {
		Product product2 = productRepository.get().get(product.getId());
		if (product2 != null) {
			BeanUtils.copyProperties(product, product2);
			product2.setUpdatedTs(new Date());
			return productRepository.update(product);
		}
		throw new ServiceException(RECORD_NOT_FOUND_ERROR, NOT_FOUND, "Record not exist!");
	}

	@Override
	public Product delete(long id) {
		return Optional.ofNullable(productRepository.delete(id))
				.orElseThrow(() -> new ServiceException(RECORD_NOT_FOUND_ERROR, NOT_FOUND, "Record not exist!"));
	}

}
