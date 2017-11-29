package com.member.model;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.reservation.model.ReservationVO;

@Transactional
public interface MemberDAO_interface {
	public void insert(MemberVO memberVO);
	public void update(MemberVO memberVO);
	public void delete(String mem_no);
	public MemberVO findByPrimaryKey(String mem_no);
	public List<MemberVO> getAll();
	
	//查詢某會員的預約紀錄從會員編號(一對多)(回傳 Set)
    public Set<ReservationVO> getReservationsByMemno(String mem_no);
}
