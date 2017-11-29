package com.reservation.actions;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.member.model.MemberService;
import com.opensymphony.xwork2.ActionSupport;
import com.reservation.model.ReservationService;
import com.reservation.model.ReservationVO;

public class ResnoAction extends ActionSupport {
	private String res_no;

	

	public String getRes_no() {
		return res_no;
	}

	public void setRes_no(String res_no) {
		this.res_no = res_no;
	}

	public String getOne_For_Display() {
		if (getOne()) {
			System.out.println("資料庫 getOne_For_Display 成功");
			return "success";
		} else {
			super.addFieldError("res_no", "查無資料");
			return "input";
		}
	}

	public String getOne_For_Update() {
		if (getOne()) {
			System.out.println("資料庫 getOne_For_Update 成功");
			return "success";
		} else {
			super.addFieldError("res_no", "查無資料");   //事實上, getOne_For_Update時, 並不會發生查無資料的情況
			return "input";
		}
	}

	public boolean getOne() {
		ReservationService reservationSvc = new ReservationService();
		ReservationVO reservationVO = reservationSvc.getOneReservation(res_no);
		if (reservationVO != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("reservationVO", reservationVO);
			return true;
		} else
			return false;
	}

	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String requestURL = request.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/reservation/listAllReservation.jsp】 或  【/member/listReservations_ByMemno.jsp】 或 【 /member/listAllMember.jsp】
		System.out.println("requestURL="+requestURL);
		
		// Perform business logic
		ReservationService reservationSvc = new ReservationService();
		ReservationVO reservationVO = reservationSvc.getOneReservation(res_no);
		reservationSvc.deletet(res_no);
		System.out.println("資料庫 delete 成功");
		
		// Send the Success view
		if(requestURL.equals("/reservation/listAllReservation.jsp"))
			return "success1";
		else if(requestURL.equals("/member/listReservations_ByMemno.jsp")){
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
