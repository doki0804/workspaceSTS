package com.itwill.ilhajob.entity;

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
@Table(name = "manager")
public class Manager {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "manager_id_SEQ_gen")
	private Long id;
	
	private String managerEmail;
	
	private String managerName;
	
	private String managerPosition;
	
	private String managerPhone;
	
	@ManyToOne
	@JoinColumn(name = "corp_id")
	private Corp corp;
}
