package com.itwill.ilhajob.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "recruit")
public class Recruit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recruit_id_SEQ_gen")
	private Long id;
	
	private String rcTitle; 
	
	private String rcPosition;
	
	private String rcContent;
	
	private String rcQualification;
	
	private int rcSalary;
	
	private Date rcDate;
	
	private Date rcDeadline;
	
	private int rcReadCount;
	
	@ManyToOne
	@JoinColumn(name = "corp_id")
	private Corp corp;
	
	@OneToMany(mappedBy = "recruit",
			   cascade = CascadeType.PERSIST,
			   fetch = FetchType.LAZY)
	private List<App> appList = new ArrayList<App>();
}

