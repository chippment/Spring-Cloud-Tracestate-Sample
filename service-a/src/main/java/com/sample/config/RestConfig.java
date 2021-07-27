package com.sample.config;

import com.sample.HeaderLoggingRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RestConfig implements WebMvcConfigurer {

	@Autowired
	private HeaderLoggingRequestInterceptor headerLoggingRequestInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(headerLoggingRequestInterceptor).addPathPatterns("/preference");
	}
}