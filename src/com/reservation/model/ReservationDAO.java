package com.reservation.model;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class ReservationDAO implements ReservationDAO_interface{
	
	private static final String GET_ALL_STMT = "from ReservationVO order by res_no";
	
	private HibernateTemplate hibernateTemplate;    
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) { 
        this.hibernateTemplate = hibernateTemplate;
    }

	@Override
	public void insert(ReservationVO reservationVO) {
		hibernateTemplate.saveOrUpdate(reservationVO);
		
	}

	@Override
	public void update(ReservationVO reservationVO) {
		hibernateTemplate.update(reservationVO);
		
	}

	@Override
	public void delete(String res_no) {
//		ReservationVO reservationVO =(ReservationVO) hibernateTemplate.get(ReservationVO.class, res_no);
		ReservationVO reservationVO = new ReservationVO(); //●●●去除關聯關係後，再刪除
		reservationVO.setRes_no(res_no);
		hibernateTemplate.delete(reservationVO);
	}

	@Override
	public ReservationVO findByPrimaryKey(String res_no) {
		ReservationVO reservationVO =(ReservationVO) hibernateTemplate.get(ReservationVO.class, res_no);
		return reservationVO;
	}

	@Override
	public List<ReservationVO> getAll() {
		List<ReservationVO> list = null;
		list = (List<ReservationVO>) hibernateTemplate.find(GET_ALL_STMT);
		return list;
	}
	
	public static void main(String[] args) {

		//EmpHibernateDAO dao = new EmpHibernateDAO();
		//為方便一般應用程式main方的測試,所以底下的model-config1-DriverManagerDataSource.xml內部dataSource設定是採用org.springframework.jdbc.datasource.DriverManagerDataSource
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config1-DriverManagerDataSource.xml");
        
        // 建立DAO物件
		ReservationDAO_interface dao =(ReservationDAO_interface) context.getBean("reservationDAO");

		//● 新增
		com.member.model.MemberVO memberVO = new com.member.model.MemberVO(); // 會員POJO
		memberVO.setMem_no("MEM00000009");

//		ReservationVO reservationVO1 = new ReservationVO();
//		reservationVO1.setMemberVO(memberVO);
//		reservationVO1.setRes_date(java.sql.Date.valueOf("2017-12-15"));
//		reservationVO1.setRes_content("987654");
//		reservationVO1.setRes_time("11:00AM");
//		dao.insert(reservationVO1);



		//● 修改
//		ReservationVO reservationVO2 = new ReservationVO();
//		reservationVO2.setRes_no("20171128-RES00000009");
//		reservationVO2.setMemberVO(memberVO);
//		reservationVO2.setRes_date(java.sql.Date.valueOf("2017-08-15"));
//		reservationVO2.setRes_content("測試測試");
//		reservationVO2.setRes_time("11:00AM");
//		dao.update(reservationVO2);



		//● 刪除(小心cascade - 多方reservation.hbm.xml如果設為 cascade="all"或
		// cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除)
//		dao.delete("20171128-RES00000008");



		//● 查詢-findByPrimaryKey (多方reservation.hbm.xml必須設為lazy="false")(優!)
//		ReservationVO reservationVO3 = dao.findByPrimaryKey("20171128-RES00000007");
//		System.out.print(reservationVO3.getRes_no() + ",");
//		System.out.print(reservationVO3.getMemberVO().getMem_no() + ",");
//		System.out.print(reservationVO3.getRes_date() + ",");
//		System.out.print(reservationVO3.getRes_content() + ",");
//		System.out.print(reservationVO3.getRes_time() + ",");
//		// 注意以下三行的寫法 (優!)
//		System.out.println();
//		System.out.print(reservationVO3.getMemberVO().getMem_name() + ",");
//		System.out.print(reservationVO3.getMemberVO().getMem_birthday() + ",");
//		System.out.print(reservationVO3.getMemberVO().getMem_mobile());
//		System.out.println("\n---------------------");



		//● 查詢-getAll (多方reservation.hbm.xml必須設為lazy="false")(優!)
		List<ReservationVO> list = dao.getAll();
		for (ReservationVO areservation : list) {
			System.out.print(areservation.getRes_no() + ",");
			System.out.print(areservation.getMemberVO().getMem_no() + ",");
			System.out.print(areservation.getRes_date() + ",");
			System.out.print(areservation.getRes_content() + ",");
			System.out.print(areservation.getRes_time() + ",");
			// 注意以下三行的寫法 (優!)
			System.out.println();
			System.out.print(areservation.getMemberVO().getMem_name()+ ",");
			System.out.print(areservation.getMemberVO().getMem_birthday() + ",");
			System.out.print(areservation.getMemberVO().getMem_psw());
			System.out.println();
		}
	}

}
