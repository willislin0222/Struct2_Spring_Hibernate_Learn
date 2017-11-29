package com.reservation.actions;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.member.model.MemberService;
import com.opensymphony.xwork2.ActionSupport;
import com.reservation.model.ReservationService;
import com.reservation.model.ReservationVO;

public class ReservationAction extends ActionSupport {
	private ReservationVO reservationVO;


	public ReservationVO getReservationVO() {
		return reservationVO;
	}

	public void setReservationVO(ReservationVO reservationVO) {
		this.reservationVO = reservationVO;
	}

	public String add() {
		ReservationService reservationSvc = new ReservationService();
		reservationSvc.addReservation(reservationVO);
		System.out.println("資料庫 insert 成功");
		return "success";
	}
	
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String requestURL = request.getParameter("requestURL"); // 送出修改的來源網頁路徑: 可能為【/reservation/listAllReservation.jsp】 或  【/member/listReservations_ByMemno.jsp】 或 【 /member/listAllMember.jsp】
		
		// Perform business logic
		ReservationService reservationSvc = new ReservationService();
		reservationSvc.updateReservation(reservationVO);
		System.out.println("資料庫 update 成功");
		
		// Send the Success view
		if(requestURL.equals("/reservation/listAllReservation.jsp"))
			return "success1";
		else if(requestURL.equals("/membert/listReservations_ByMemno.jsp")){
			MemberService memberSvc = new MemberService();
			request.setAttribute("listReservations_ByMemno",memberSvc.getReservarionsByMemno(reservationVO.getMemberVO().getMem_no())); // 資料庫取出的list物件,存入request
			return "success2";
		}else if(requestURL.equals("/member/listAllMember.jsp")){
			MemberService memberSvc = new MemberService();
			request.setAttribute("listReservations_ByMemno",memberSvc.getReservarionsByMemno(reservationVO.getMemberVO().getMem_no())); // 資料庫取出的list物件,存入request
			return "success3";
		}else return null;
	}

}
