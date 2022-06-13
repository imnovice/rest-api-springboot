package com.kdn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

public class CustomURLFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("CustomURLFilter");
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		if ("ABC".equalsIgnoreCase(httpServletResponse.getHeader("client_id"))) {

			httpServletResponse.addHeader("REQUEST", "REVOKED");
			httpServletResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			response.getOutputStream().flush();
			response.getOutputStream().println("-- Output by filter error --");
			return;
		}

		chain.doFilter(request, response);
	}

}
