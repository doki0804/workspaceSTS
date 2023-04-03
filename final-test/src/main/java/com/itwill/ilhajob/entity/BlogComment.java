package com.itwill.ilhajob.entity;

import java.util.Date;

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
@Table(name = "blog_comment")
public class BlogComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BlogComment_id_SEQ_gen")
	private Long id;
	
	private String commentContent;
	
	private Date commentDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "blog_id")
	private Blog blog;
}
