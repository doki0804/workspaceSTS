package com.itwill.ilhajob.user.entity;

import java.util.ArrayList;
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
@Table(name = "cv")
public class Cv {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cv_id_SEQ_gen")
	private Long id;
	
	private String cvName;
	
	private String cvDescription;
	
	private String cvPortfolio;
		
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "cv",
			   cascade = CascadeType.PERSIST,
			   fetch = FetchType.EAGER)
	private List<App> applist = new ArrayList<App>();
	
}
