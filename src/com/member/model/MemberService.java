package com.member.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.reservation.model.ReservationVO;

public class MemberService {
	
	private MemberDAO_interface dao;
	
	public MemberService(){
		//dao = new DeptHibernateDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		dao =(MemberDAO_interface) context.getBean("memberDAO");
	}
	
	public MemberVO addMember(String mem_name, String mem_id, String mem_psw, Date mem_birthday
							 , String mem_mobile, byte[] mem_image) {
		MemberVO memberVO = new MemberVO();
		memberVO.setMem_name(mem_name);
		memberVO.setMem_id(mem_id);
		memberVO.setMem_psw(mem_psw);
		memberVO.setMem_birthday(mem_birthday);
		memberVO.setMem_mobile(mem_mobile);
		memberVO.setMem_image(mem_image);
		dao.insert(memberVO);
		return memberVO;
	}
	
	public MemberVO updateMember(String mem_no,String mem_name, String mem_id, String mem_psw, Date mem_birthday
			 , String mem_mobile, byte[] mem_image) {
		MemberVO memberVO = new MemberVO();
		memberVO.setMem_no(mem_no);
		memberVO.setMem_name(mem_name);
		memberVO.setMem_id(mem_id);
		memberVO.setMem_psw(mem_psw);
		memberVO.setMem_birthday(mem_birthday);
		memberVO.setMem_mobile(mem_mobile);
		memberVO.setMem_image(mem_image);
		dao.insert(memberVO);
		return memberVO;
	}
	
	public void deletet(String mem_no) {
		dao.delete(mem_no);
	}
	
	public MemberVO getOneMember(String mem_no) {
		return dao.findByPrimaryKey(mem_no);
	}
	
	public List<MemberVO> getAll() {
		return dao.getAll();
	}
	
	public Set<ReservationVO> getReservarionsByMemno(String mem_no) {
		return dao.getReservationsByMemno(mem_no);
	}
}
