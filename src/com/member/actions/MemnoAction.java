package com.member.actions;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.member.model.MemberService;
import com.opensymphony.xwork2.ActionSupport;
import com.reservation.model.ReservationVO;

public class MemnoAction extends ActionSupport {
	private String mem_no;

	public String getMem_no() {
		return mem_no;
	}

	public void setMem_no(String mem_no) {
		this.mem_no = mem_no;
	}

	public String listReservations_ByMemno() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String action = request.getParameter("action");
		
		// Perform business logic
		MemberService memberSvc = new MemberService();
		Set<ReservationVO> set = memberSvc.getReservarionsByMemno(mem_no);
		request.setAttribute("listReservations_ByMemno", set);
		
		// Send the Success view
		if ("listReservations_ByMemno_A".equals(action))
			return "success1";              // 來自select_page.jsp的請求, 成功轉交 member/listReservations_ByMemno.jsp
		else if ("listReservations_ByMemno_B".equals(action))
			return "success2";               // 來自member/listAllMember.jsp的請求, 成功轉交 member/listAllMember.jsp
	    else return null;
		
	}

	public String delete_Member() {
		// Perform business logic
		MemberService memberSvc = new MemberService();
		memberSvc.deletet(mem_no);
		return "success";
	}

}
