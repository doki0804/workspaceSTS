package com.itwill.jpa.relation.repository;

import java.time.LocalDateTime;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Category;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.Provider;

class ProductRepositoryTest extends SpringJpaRelationApplicationTests{
	
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProviderRepository providerRepository;
	@Autowired
	CategoryRepository categoryRepository;

	
	@Test
	void productSaveAndUpdate() {
		Product product=Product.builder()
						.name("JPA일주일만하면")
						.price(3000)
						.stock(1000)
						.build();
		productRepository.save(product);
		
		product.setName("JSP하루만하면");
		productRepository.save(product);
		
	}
	
	@Test
	void productProviderSaveRead() {
		
		Provider provider = new Provider();
		provider.setName("XX출판사");
		providerRepository.save(provider);
		
		Product product1 = new Product();
		product1.setName("비문학");
		product1.setPrice(12000);
		product1.setStock(100);
		
		Product product2 = new Product();
		product2.setName("XX책");
		product2.setPrice(9000);
		product2.setStock(100);
		
		/*********연관설정 Product -> Provider*********
		product1.setProvider(provider);
		product2.setProvider(provider);
		**********************************************/
		productRepository.save(product1);
		productRepository.save(product2);
		
		/********연관설정 Provider -> Product**********/
		Provider provider2 = providerRepository.findById(1L).get();
		//provider2.getProductList().addAll(Arrays.asList(product1,product2));
		
//		System.out.println("Product: "+productRepository.findById(2L).get());
//		System.out.println("Product: "+productRepository.findById(2L).get().getProvider());
		
		providerRepository.findById(1L).get();
		//provider.getProductList().addAll(Arrays.asList(product1,product2));
	}
	
	@Test
	void productSaveAndUpdateCategory() {
		Category category = new Category("c1","컴퓨터");
		categoryRepository.save(category);
		
		Product product1 = Product.builder().name("일손컴").price(500000).stock(100).build();
		Product product2 = Product.builder().name("이손컴").price(600000).stock(100).build();
		Product product3 = Product.builder().name("삼손컴").price(700000).stock(100).build();
		
		product1.setCategory(category);
		product2.setCategory(category);
		product3.setCategory(category);
		
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		System.out.println("-----------------------------READ-------------------------------");
		System.out.println("product : "+productRepository.findById(6L).get().getCategory());
	}

}
