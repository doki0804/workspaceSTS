package com.itwill.jpa.relation.repository;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.Provider;

class ProviderRepositoryTest extends SpringJpaRelationApplicationTests {
	@Autowired
	ProviderRepository providerRepository;
	@Autowired
	ProductRepository productRepository;
	
	@Disabled
	@Test
	void providerProductSaveRead() {
		
		Provider provider=newProvider("오릴리출판사");
		
		providerRepository.save(provider);
		
		Product product1=newProduct("파이썬", 10000, 100);
		Product product2=newProduct("머신러닝", 30000, 300);
		Product product3=newProduct("인공지능", 89000, 50);
	
		/*****연관설정 Product-->Provider*****/
		product1.setProvider(provider);
		product2.setProvider(provider);
		product3.setProvider(provider);
		
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		
		
		System.out.println("Provider:"+providerRepository.findById(1L).get());
		System.out.println("Provider --> ProductList:"+providerRepository.findById(1L).get().getProductList());
		
	}
	/**********************case1 CascadeType.PERSIST*************************/
	//@Test
	void providerProductSaveAndReadCasCadeTypePERSIST() {
		Provider provider = new Provider("한빛미디어");
		
		Product product1 = new Product("파이썬",15000,20);
		Product product2 = new Product("AI",25000,10);
		Product product3 = new Product("코틀린",20000,15);
		
		product1.setProvider(provider);
		product1.setProvider(provider);
		product1.setProvider(provider);
		
		provider.getProductList().addAll(Lists.newArrayList(product1,product2,product3));
		
		providerRepository.save(provider);
		
	}
	
	private Provider newProvider(String name) {
		Provider provider=new Provider(name);
		return provider;
	}
	private Product newProduct(String name,Integer price,Integer stock) {
		Product product=new Product(name,price,stock);
		return product;
	}

}