package com.itwill.ilhajob.user.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *  사용자관리를 위하여 필요한 도메인클래스(VO,DTO)
 *  USERINFO 테이블의 각컬럼에해당하는 멤버를 가지고있다
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	
	private int userSeq;
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
	private String userStatus;
	private String snsType;
	private String snsId;
	private String job;
	private int role;
	
	private List<AppDto> appList;
	private List<ExpDto> expList;
	private List<EduDto> eduList;
	private List<AwardsDto> awardsList;
	private List<ReviewDto> reviewList;
	
	/*
	 *패쓰워드 일치여부 검사 
	 */
	public boolean isMatchPassword(String password){
		boolean isMatch=false;
		if(this.userPassword.equals(password)){
			isMatch=true;
		}
		return isMatch;
	}


}







