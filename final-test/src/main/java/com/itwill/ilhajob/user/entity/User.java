package com.itwill.ilhajob.user.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.itwill.ilhajob.common.entity.Blog;
import com.itwill.ilhajob.common.entity.BlogComment;
import com.itwill.ilhajob.common.entity.Payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "userinfo")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "user_id_SEQ_gen")
	private Long id;
	
	private String userEmail;
	
	private String userPassword;
	
	private String userName;
	
	private String userPhone;
	
	private String userSex;
	
	private String userAddress;
		
	private String userCareer;
	
	private int userAge;
	
	private String userFinalEducation;
	
	private String userLanguage;
	
	private String userSkills;
	
	private String userImage;
	
	@Column(columnDefinition = "CHAR(1) DEFAULT '0'")
	private char userStatus;
	
	private String snsType;
	
	private String snsId;
	
	private String job;
	
	@Column(columnDefinition = "NUMBER(1) DEFAULT 1")
	private int role;
	
	@OneToMany(mappedBy = "user",
			   cascade = CascadeType.PERSIST,
			   fetch = FetchType.LAZY)
	private List<App> appList = new ArrayList<App>();
	
	@OneToMany(mappedBy = "user",
			   cascade = CascadeType.PERSIST,
			   fetch = FetchType.LAZY)
	private List<Cv> cvList = new ArrayList<Cv>();
	
	@OneToMany(mappedBy = "user",
			   cascade = CascadeType.PERSIST,
			   fetch = FetchType.LAZY)
	private List<Exp> expList = new ArrayList<Exp>();
	
	@OneToMany(mappedBy = "user",
			   cascade = CascadeType.PERSIST,
			   fetch = FetchType.LAZY)
	private List<Edu> eduList = new ArrayList<Edu>();
	
	@OneToMany(mappedBy = "user",
			   cascade = CascadeType.PERSIST,
			   fetch = FetchType.LAZY)
	private List<Awards> awardsList = new ArrayList<Awards>();
	
	@OneToMany(mappedBy = "user",
			   cascade = CascadeType.PERSIST,
			   fetch = FetchType.LAZY)
	private List<Review> reviewList = new ArrayList<Review>();
	
	@OneToMany(mappedBy = "user",
			   cascade = CascadeType.PERSIST,
			   fetch = FetchType.LAZY)
	private List<CorpBookmark> corpBookmarkList = new ArrayList<CorpBookmark>();
	
	@OneToMany(mappedBy = "user",
			   cascade = CascadeType.PERSIST,
			   fetch = FetchType.LAZY)
	private List<Blog> blogList = new ArrayList<Blog>();
	
	@OneToMany(mappedBy = "user",
			   cascade = CascadeType.PERSIST,
			   fetch = FetchType.LAZY)
	private List<BlogComment> blogCommentList = new ArrayList<BlogComment>();
	
	@OneToMany(mappedBy = "user",
			   cascade = CascadeType.PERSIST,
			   fetch = FetchType.LAZY)
	private List<Message> messageList = new ArrayList<Message>();
	
	@OneToMany(mappedBy = "user",
			   cascade = CascadeType.PERSIST,
			   fetch = FetchType.LAZY)
	private List<Payment> paymentList = new ArrayList<Payment>();
}
