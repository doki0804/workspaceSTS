package com.itwill.ilhajob.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "blog")
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog_id_SEQ_gen")
	private Long id;
	
	@NonNull
	@Column(nullable = false)
	private String blogTitle;
	
	@NonNull
	@Column(nullable = false)
	private String blogContent;
	
	private String blogImage;
	
	private Date blogDate;
	
	private int blogReadCount;
	
	private int blogLike;
	
	private int blogCate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "blog",
			   cascade = CascadeType.PERSIST,
			   fetch = FetchType.EAGER)
	private List<BlogComment> blogCommentList;
}
