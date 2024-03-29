package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.relation.SpringJpaRelationApplicationTests;
import com.itwill.jpa.relation.entity.Product;
import com.itwill.jpa.relation.entity.ProductDetail;

class ProductDetailRepositoryTest extends SpringJpaRelationApplicationTests {

	@Autowired
	ProductDetailRepository productDetailRepository;
	@Autowired
	ProductRepository productRepository;

	@Test
	void productDetailProductSaveRead() {
		Product product = new Product();
		product.setName("스프링시큐리티");
		product.setPrice(80000);
		product.setStock(500);
		productRepository.save(product);
		
		ProductDetail productDetail = new ProductDetail();
		productDetail.setDescription("아주좋은책이여요!!!!");
		productDetail.setProduct(product);
		productDetailRepository.save(productDetail);
		
		ProductDetail productDetail2 = productDetailRepository.findById(2L).get();
		Product product2 = productDetailRepository.findById(2L).get().getProduct();
		
		System.out.println(productDetail2);
		System.out.println(product2);
		
	}
	
	
}
