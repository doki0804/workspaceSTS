package com.itwill.ilhajob.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.itwill.ilhajob.corp.entity.Corp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "corp_bookmark")
public class CorpBookmark {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookmark_id_SEQ_gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "corp_id")
	private Corp corp;
}
