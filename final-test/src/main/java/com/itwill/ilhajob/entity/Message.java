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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "message")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_id_SEQ_gen")
	private Long id;

	private String messageTitle;
	
	private String messageContents;
	
	private Date messageDate;
	
	@ManyToOne
	@JoinColumn(name = "app_id")
	private App app;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
