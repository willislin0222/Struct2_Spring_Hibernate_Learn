package com.reservation.model;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.member.model.MemberVO;


public class ReservationService {
	
	private ReservationDAO_interface dao;
	
	public ReservationService() {
		//dao = new EmpHibernateDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用Apache DBCP連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		dao =(ReservationDAO_interface) context.getBean("reservationDAO");
	}
	
	public ReservationVO addReservation(MemberVO memberVO, Date res_date,String res_content,String res_time) {
		ReservationVO reservationVO = new ReservationVO();
		reservationVO.setMemberVO(memberVO);
		reservationVO.setRes_date(res_date);
		reservationVO.setRes_content(res_content);
		reservationVO.setRes_time(res_time);
		dao.insert(reservationVO);
		return reservationVO;
	}
	
	// 預留給 Struts 2 用的
	public void addReservation(ReservationVO reservationVO) {
		dao.insert(reservationVO);
	}
		
	public ReservationVO updateReservation(String res_no, MemberVO memberVO, Date res_date,String res_content,String res_time) {
		ReservationVO reservationVO = new ReservationVO();
		reservationVO.setRes_no(res_no);
		reservationVO.setMemberVO(memberVO);
		reservationVO.setRes_date(res_date);
		reservationVO.setRes_content(res_content);
		reservationVO.setRes_time(res_time);
		dao.insert(reservationVO);
		return reservationVO;
	}
	
	// 未使用
	public ReservationVO updateReservation(ReservationVO reservationVO) {
		dao.update(reservationVO);
		return dao.findByPrimaryKey(reservationVO.getRes_no());
	}
	
		
	public void deletet(String res_no) {
		dao.delete(res_no);
	}
		
	public ReservationVO getOneReservation(String res_no) {
		return dao.findByPrimaryKey(res_no);
	}
		
	public List<ReservationVO> getAll() {
		return dao.getAll();
	}
		

}
