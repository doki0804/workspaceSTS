package com.springboot.security.oauth.common.service;

import java.util.List;

import com.springboot.security.oauth.common.dto.ProductDto;


public interface ProductService {
	
	//상품 번호로 상품 1개 찾기
	ProductDto selectById(long id) throws Exception;
	
	//p_div로 상품 리스트 불러오기
	List<ProductDto> selectByDiv(String pDiv) throws Exception;
	
	//update Product
	int updateProduct(ProductDto productDto) throws Exception;
	
	//delete Product
	int deleteProduct(int pNo) throws Exception;
	
	
}
