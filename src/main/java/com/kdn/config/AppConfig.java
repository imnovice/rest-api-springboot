package com.kdn.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kdn.filter.CustomURLFilter;
import com.kdn.filter.FilterOrder;

/**
 * A AppConfig class to customize the application configuration for fine tuning.
 */
@Configuration
public class AppConfig {

	@Bean
	public FilterRegistrationBean<CustomURLFilter> filterRegistrationBean() {
		FilterRegistrationBean<CustomURLFilter> registrationBean = new FilterRegistrationBean<>();
		CustomURLFilter customURLFilter = new CustomURLFilter();

		registrationBean.setFilter(customURLFilter);
		registrationBean.addUrlPatterns("/api/product/delete/*");
		registrationBean.setOrder(FilterOrder.TWO); // set precedence
		registrationBean.setName("CustomURLFilter");
		return registrationBean;
	}
}