package com.itwill.jpa.relation.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "product")
public class Product extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NonNull
	@Column(nullable = false)
	private String name;
	@NonNull
	@Column(nullable = false)
	private Integer price;
	@NonNull
	@Column(nullable = false)
	private Integer stock;
	
	@OneToOne(mappedBy = "product")
	@ToString.Exclude
	private ProductDetail productDetail;
	
	@ManyToOne
	@JoinColumn(name = "provider_id")
	@ToString.Exclude
	private Provider provider;
	
	/******case1[@manyToOne]*********/
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	/**********case2[@oneToMany]*******
	product테이블에 category_id FK컬럼이 생성
	***********************************/
}
