package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Category;
import com.itwill.jpa.relation.entity.Product;

class CategoryRepositoryTest extends SpringJpaRelationApplicationTests{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void category() {
		/*********case1[ManyToOne]**********/
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
		System.out.println("category : "+categoryRepository.findById(1L).get());
		System.out.println("category : "+categoryRepository.findById(1L).get().getProducts());
		
		/*********case2[oneToMany]**********
		
		
		Product product1 = Product.builder().name("일손컴").price(500000).stock(100).build();
		Product product2 = Product.builder().name("이손컴").price(600000).stock(100).build();
		Product product3 = Product.builder().name("삼손컴").price(700000).stock(100).build();
		
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);

		Category category = new Category("c1","컴퓨터");
		category.getProducts().add(product1);
		category.getProducts().add(product2);
		category.getProducts().add(product3);
		
		categoryRepository.save(category);
		
		
		
		System.out.println("-----------------------------READ-------------------------------");
		System.out.println("category : "+categoryRepository.findById(4L).get());
		System.out.println("category : "+categoryRepository.findById(4L).get().getProducts());
		*************************/
		
		
	}

}
