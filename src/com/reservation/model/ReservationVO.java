package com.reservation.model;

import java.sql.Date;

import com.member.model.MemberVO;

public class ReservationVO {
	private String res_no;
	private MemberVO memberVO;
	private Date res_date;
	private String res_content;
	private String res_time;
	public String getRes_no() {
		return res_no;
	}
	public void setRes_no(String res_no) {
		this.res_no = res_no;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	public Date getRes_date() {
		return res_date;
	}
	public void setRes_date(Date res_date) {
		this.res_date = res_date;
	}
	public String getRes_content() {
		return res_content;
	}
	public void setRes_content(String res_content) {
		this.res_content = res_content;
	}
	public String getRes_time() {
		return res_time;
	}
	public void setRes_time(String res_time) {
		this.res_time = res_time;
	}
	
	
}
