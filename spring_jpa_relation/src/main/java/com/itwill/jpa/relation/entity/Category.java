package com.itwill.jpa.relation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Builder
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	@Column(unique = true)
	private String code;
	
	@NonNull
	private String name;
	/***************case1[@ManyToOne]*****************/
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private List<Product> products = new ArrayList<Product>();
	
	/**************case2[@OneToMany]******************
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private List<Product> products = new ArrayList<Product>();
	**************************************/
}
