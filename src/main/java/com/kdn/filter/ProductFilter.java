package com.kdn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(FilterOrder.ONE)
public class ProductFilter implements Filter {
	
	private static final String BLANK = " | ";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;		
		
		String reqStr = new StringBuilder().append(httpRequest.getRequestURI()).append(BLANK )
		.append(httpRequest.getHeader("User-Agent")).append(BLANK )
		.append(httpRequest.getMethod()).append(BLANK )
		.append(httpRequest.getProtocol()).append(BLANK )
		.append(httpRequest.getQueryString()).toString();

		System.out.println("ProductFilter -> " + reqStr);

		chain.doFilter(request, response);
	}

}
