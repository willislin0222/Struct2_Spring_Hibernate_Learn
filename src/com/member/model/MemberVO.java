package com.member.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import com.reservation.model.ReservationVO;

public class MemberVO {
	private String mem_no;
	private String mem_name;
	private String mem_id;
	private String mem_psw;
	private Date mem_birthday;
	private String mem_mobile;
	private byte[] mem_image;
	private Set<ReservationVO> reservations = new HashSet<ReservationVO>();
	public String getMem_no() {
		return mem_no;
	}
	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_psw() {
		return mem_psw;
	}
	public void setMem_psw(String mem_psw) {
		this.mem_psw = mem_psw;
	}
	public Date getMem_birthday() {
		return mem_birthday;
	}
	public void setMem_birthday(Date mem_birthday) {
		this.mem_birthday = mem_birthday;
	}
	public String getMem_mobile() {
		return mem_mobile;
	}
	public void setMem_mobile(String mem_mobile) {
		this.mem_mobile = mem_mobile;
	}
	public byte[] getMem_image() {
		return mem_image;
	}
	public void setMem_image(byte[] mem_image) {
		this.mem_image = mem_image;
	}
	public Set<ReservationVO> getReservations() {
		return reservations;
	}
	public void setReservations(Set<ReservationVO> reservations) {
		this.reservations = reservations;
	}	
}
