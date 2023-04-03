package com.itwill.ilhajob.user.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.itwill.ilhajob.corp.entity.Corp;
import com.itwill.ilhajob.corp.entity.Recruit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "app")
public class App {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "app_id_SEQ_gen")
	private Long id;
	
	private char app_status = '0';
	
	@ManyToOne
	@JoinColumn(name = "recruit_id")
	private Recruit recruit;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "corp_id")
	private Corp corp;
	
	@OneToMany(mappedBy = "app",
			   fetch = FetchType.EAGER)
	private List<Message> messageList = new ArrayList<Message>();
}