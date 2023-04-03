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
@Table(name="corp_image")
public class CorpImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "corp_image_id_SEQ_gen")
	private Long id;
	
	private String corpImage;
	
	@ManyToOne
	@JoinColumn(name = "corp_id")
	private Corp corp;
}
