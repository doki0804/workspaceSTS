package com.itwill.ilhajob.common.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tag")
public class Tag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tag_id_SEQ_gen")
	private Long id;
	
	private String tagName;
	
	@OneToMany(mappedBy = "tag",
			   fetch = FetchType.LAZY)
	private List<RecruitTag> recruitTag;
	
	@OneToMany(mappedBy = "tag",
			   fetch = FetchType.LAZY)
	private List<CorpTag> corpTag;
}
