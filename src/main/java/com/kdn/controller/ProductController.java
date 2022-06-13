package com.kdn.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kdn.exception.ErrorCode;
import com.kdn.exception.ServiceException;
import com.kdn.model.Product;
import com.kdn.services.ProductService;

/**
 * My Product controller class
 * @author KDN
 *
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Resource
	private HttpServletRequest httpRequest;
	
	@Resource
	private HttpServletResponse httpResponse;

	@Autowired
	private ProductService productService;

	/**
	 * Get Api for Product controller.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProduct() {
		List<Product> products = productService.get();
		httpResponse.setIntHeader("product-count", products.size());
		return products;
	}
	
	@RequestMapping(path = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product getProduct(@PathVariable("id") Long id) {
		Product product = productService.get(id);
		return product;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product add(@RequestBody Product product) {
		return productService.add(product);

	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product update(@RequestBody Product product) {
		return productService.update(product);

	}
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product delete(@PathVariable("id") Long id) {
		String clientId = httpRequest.getHeader("client_id");
		if (StringUtils.isEmpty(clientId)) {
			throw new ServiceException(ErrorCode.MANDATORY_PARAMETER_MISSING_ERROR, HttpStatus.BAD_REQUEST, "Mandatory Header Param('client_id') is not found!");
		}
		return productService.delete(id);
	}

}
