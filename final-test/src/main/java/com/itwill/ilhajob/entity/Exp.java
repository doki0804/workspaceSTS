package com.itwill.ilhajob.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "exp")
public class Exp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exp_id_SEQ_gen")
	private Long id;
	
	private String expPosition;
	
	private String expCorpName;
	
	private Date expStartDate;
	
	private Date expEndDate;
	
	private String expContent;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}

