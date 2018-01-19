package com.ledmega.web1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ledmega.web1.common.CertificationInterceptor;

@Configuration
@EnableAutoConfiguration
//@MapperScan("com.**.mapper")
public class WebConfig extends WebMvcConfigurerAdapter {

	/*
	 * �α��� ���� Interceptor ����
	 */
	@Autowired
	CertificationInterceptor certificationInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(certificationInterceptor)
			//.addPathPatterns("/**/*.do");
			.addPathPatterns("/**");
	}
	
	@Bean
	public InternalResourceViewResolver setupViewResolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	
}
