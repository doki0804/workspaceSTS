package com.itwill.guest;




public class Guest {
	public  int guest_no;
	public String guest_name;
	public String guest_date;
	public String guest_email;
	public String guest_homepage;
	public String guest_title;
	public String guest_content;
	
	public Guest() {
	}
	public Guest(int guest_no, String guest_name, String guest_date, String guest_email, String guest_homepage,
			String guest_title, String guest_content) {
		super();
		this.guest_no = guest_no;
		this.guest_name = guest_name;
		this.guest_date = guest_date;
		this.guest_email = guest_email;
		this.guest_homepage = guest_homepage;
		this.guest_title = guest_title;
		this.guest_content = guest_content;
	}
	public int getGuest_no() {
		return guest_no;
	}
	public void setGuest_no(int guest_no) {
		this.guest_no = guest_no;
	}
	public String getGuest_name() {
		return guest_name;
	}
	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}
	public String getGuest_date() {
		return guest_date;
	}
	public void setGuest_date(String guest_date) {
		this.guest_date = guest_date;
	}
	public String getGuest_email() {
		return guest_email;
	}
	public void setGuest_email(String guest_email) {
		this.guest_email = guest_email;
	}
	public String getGuest_homepage() {
		return guest_homepage;
	}
	public void setGuest_homepage(String guest_homepage) {
		this.guest_homepage = guest_homepage;
	}
	public String getGuest_title() {
		return guest_title;
	}
	public void setGuest_title(String guest_title) {
		this.guest_title = guest_title;
	}
	public String getGuest_content() {
		return guest_content;
	}
	public void setGuest_content(String guest_content) {
		this.guest_content = guest_content;
	}
	@Override
	public String toString() {
		return "Guest [guest_no=" + guest_no + ", guest_name=" + guest_name + ", guest_date=" + guest_date
				+ ", guest_email=" + guest_email + ", guest_homepage=" + guest_homepage + ", guest_title=" + guest_title
				+ ", guest_content=" + guest_content + "]";
	}
	
	
}











