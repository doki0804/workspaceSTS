package com.itwill.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.itwill.user.interceptor.LoginCheckInterceptor;

@Configuration

public class WebConfig implements WebMvcConfigurer{
	/********************WebMvcConfigurer재정의*********************/
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.jsp");
	}
	
	@Autowired
	LoginCheckInterceptor loginCheckInterceptor;
	
	public void addInterceptors(InterceptorRegistry registry)  {
		registry.addInterceptor(loginCheckInterceptor);
	}
	/*
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		 registry.jsp("/WEB-INF/views/",".jsp");
	}
	*/
	
	/*************************************************************/
	
	/*********************Spring MVC 빈객체등록*********************/
	// 1.ViewResolver객체등록
	/*
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver beanNameViewResolver=new BeanNameViewResolver();
		beanNameViewResolver.setOrder(0);
		return beanNameViewResolver;
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		internalResourceViewResolver.setOrder(1);
		return internalResourceViewResolver;
	}
	*/
	
	
}
