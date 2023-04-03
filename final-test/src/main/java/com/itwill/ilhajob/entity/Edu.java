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
@Table(name = "edu")
public class Edu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edu_id_SEQ_gen")
	private Long id;
	
	private String eduMajor;
	
	private String eduName;
	
	private Date eduStartDate;
	
	private Date eduEndDate;
	
	private String eduScore;
	
	private String eduContent;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
