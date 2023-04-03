package com.itwill.ilhajob.entity;

import java.time.LocalDateTime;

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
@Table(name = "awards")
public class Awards {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "awards_id_SEQ_gen")
	private Long id;
	
	private String awardsName;
	
	private LocalDateTime awardsDate;
	
	private String awardsContent;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
