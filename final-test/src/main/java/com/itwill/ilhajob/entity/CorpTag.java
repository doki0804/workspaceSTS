package com.itwill.ilhajob.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="corp_tag")
public class CorpTag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "corp_tag_id_SEQ_gen")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "tag_id")
	private Tag tag;
	
	@ManyToOne
	@JoinColumn(name = "corp_id")
	private Corp corp;
}
