package com.itwill.sns.naver;

import java.math.BigInteger;

public class ProductBuilder {
	public static void main(String[] args) {
		Product product1 = new Product(1, "tv", BigInteger.valueOf(4123432423L));
		
		Product product2 =
				Product.builder()
				.no(1)
				.name("computer")
				.price(BigInteger.valueOf(453215321655L))
				.build();
	}
}
