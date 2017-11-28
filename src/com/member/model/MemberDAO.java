package com.member.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.reservation.model.ReservationVO;

public class MemberDAO implements MemberDAO_interface{
	
	private static final String GET_ALL_STMT = "from MemberVO order by mem_no";
	
	//springframework hibernate5
	private HibernateTemplate hibernateTemplate;    
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) { 
        this.hibernateTemplate = hibernateTemplate;
    }

	@Override
	public void insert(MemberVO memberVO) {
		hibernateTemplate.saveOrUpdate(memberVO);
		
	}

	@Override
	public void update(MemberVO memberVO) {
		hibernateTemplate.update(memberVO);
	}

	@Override
	public void delete(String mem_no) {
		MemberVO memberVO =(MemberVO) hibernateTemplate.get(MemberVO.class, mem_no);
		hibernateTemplate.delete(memberVO);
	}

	@Override
	public MemberVO findByPrimaryKey(String mem_no) {
		MemberVO memberVO =(MemberVO) hibernateTemplate.get(MemberVO.class, mem_no);
		return memberVO;
	}

	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> list = null;
		list = (List<MemberVO>) hibernateTemplate.find(GET_ALL_STMT);
		return list;
	}

	@Override
	public Set<ReservationVO> getReservationsByMemno(String mem_no) {
		Set<ReservationVO> set = findByPrimaryKey(mem_no).getReservations();
		return set;
	}
	
	public static void main(String[] args) {

		//DeptHibernateDAO dao = new DeptHibernateDAO();
		//為方便一般應用程式main方的測試,所以底下的model-config1-DriverManagerDataSource.xml內部dataSource設定是採用org.springframework.jdbc.datasource.DriverManagerDataSource
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config1-DriverManagerDataSource.xml");
		
		// 建立DAO物件
		MemberDAO_interface dao =(MemberDAO_interface) context.getBean("memberDAO");

		//● 新增-1(一方dept2.hbm.xml必須有cascade="save-update" 或cascade="all"的設定)(雖然強大,不過實務上並不常用)(但,可用在訂單主檔與明細檔一次新增成功)
//		MemberVO memberVO = new MemberVO();  // 會員POJO
//		Set<ReservationVO> set = new HashSet<ReservationVO>();// 準備置入預約紀錄數筆,以便cascade="save-update"的測試
//
//		ReservationVO reservationxx = new ReservationVO();   // 預約第一筆
//		reservationxx.setMemberVO(memberVO);
//		reservationxx.setRes_content("1234");
//		reservationxx.setRes_date(java.sql.Date.valueOf("2017-11-15"));
//		reservationxx.setRes_time("9:00");
//
//		ReservationVO reservationyy = new ReservationVO();   // 預約第二筆
//		reservationyy.setMemberVO(memberVO);
//		reservationyy.setRes_content("5678");
//		reservationyy.setRes_date(java.sql.Date.valueOf("2017-11-25"));
//		reservationyy.setRes_time("10:00");
//
//		set.add(reservationxx);
//		set.add(reservationyy);
//
//		memberVO.setMem_id("vicky");
//		memberVO.setMem_name("薇庭");
//		memberVO.setMem_psw("0823");
//		memberVO.setMem_birthday(java.sql.Date.valueOf("2017-11-25"));
//		memberVO.setMem_mobile("0912345678");
//		memberVO.setReservations(set);
//		dao.insert(memberVO);



		//● 修改-1(一方dept2.hbm.xml必須有cascade="save-update" 或 cascade="all"的設定)(雖然強大,不過實務上並不常用)(但,可視情況使用之)
//		MemberVO memberVO = new MemberVO(); // 會員POJO
//		Set<ReservationVO> set = new HashSet<ReservationVO>(); // 準備置入員工數人,以便cascade="save-update"的測試
//
//		ReservationVO reservationxx = new ReservationVO(); // 預約POJO1
//		reservationxx.setRes_no("20171128-RES00000008"); // 【如果增加 reservationxx.setRes_no(20171128-RES00000008); 則變成update】
//		reservationxx.setMemberVO(memberVO);
//		reservationxx.setRes_date(java.sql.Date.valueOf("2017-11-28"));
//		reservationxx.setRes_content("測試測試");
//		reservationxx.setRes_time("12:00PM");
//		
//		ReservationVO reservationyy = new ReservationVO(); // 預約POJO2
//		reservationyy.setRes_no("20171128-RES00000007"); // 【如果增加 reservationxx.setRes_no(20171128-RES00000007); 則變成update】
//		reservationyy.setMemberVO(memberVO);
//		reservationyy.setRes_date(java.sql.Date.valueOf("2017-11-28"));
//		reservationyy.setRes_content("測試測試12345");
//		reservationyy.setRes_time("10:00PM");
//
//		set.add(reservationxx);
//		set.add(reservationyy);
//
//		memberVO.setMem_no("MEM00000009"); // 【memberVO.setMem_no("MEM00000009") 則變成update】
//		memberVO.setMem_id("UAO");
//		memberVO.setMem_name("貞雅");
//		memberVO.setMem_psw("1227");
//		memberVO.setMem_birthday(java.sql.Date.valueOf("2017-12-25"));
//		memberVO.setMem_mobile("0911111111");
//		memberVO.setReservations(set);
//		dao.update(memberVO);



		//● 修改-2(不需設定cascade="save-update" 或 cascade="all")(這是經常要用到的一般修改)
//		MemberVO memberVO2 = new MemberVO(); // 會員POJO
//		memberVO2.setMem_no("MEM00000008"); // 【如果增加memberVO2.setMem_no("MEM00000008"); 則變成update】
//		memberVO2.setMem_id("UAO11");
//		memberVO2.setMem_name("貞雅");
//		memberVO2.setMem_psw("1227");
//		memberVO2.setMem_birthday(java.sql.Date.valueOf("2017-12-25"));
//		memberVO2.setMem_mobile("0911111111");
//		dao.update(memberVO2);



		//●刪除 (超級強大!小心使用!)(一方dept2.hbm.xml必須有cascade="delete" 或 cascade="all"的設定, 再加上inverse="true"設定)
//		dao.delete("MEM00000008");



		//● 新增-2(不需要cascade="save-update" 或 cascade="all"的設定)(這是經常要用到的一般新增)
//		MemberVO memberVO2 = new MemberVO(); // 會員POJO
//		memberVO2.setMem_id("UAO11");
//		memberVO2.setMem_name("貞雅");
//		memberVO2.setMem_psw("1227");
//		memberVO2.setMem_birthday(java.sql.Date.valueOf("2017-12-25"));
//		memberVO2.setMem_mobile("0911111111");
//		dao.insert(memberVO2);



		//● 查詢-findByPrimaryKey (優秀!) (一方dept2.hbm.xml必須設為lazy="false")
//		MemberVO memberVO3 = dao.findByPrimaryKey("MEM00000009");
//		System.out.print(memberVO3.getMem_no() + ",");
//		System.out.print(memberVO3.getMem_name() + ",");
//		System.out.print(memberVO3.getMem_id()+ ",");
//		System.out.print(memberVO3.getMem_psw()+ ",");
//		System.out.print(memberVO3.getMem_birthday()+ ",");
//		System.out.print(memberVO3.getMem_mobile()+ ",");
//		System.out.print(memberVO3.getMem_image()+ ",");
//		System.out.println("\n-----------------");
//		Set<ReservationVO> set3 = memberVO3.getReservations();
//		for (ReservationVO areservations : set3) {
//			System.out.print(areservations.getRes_no() + ",");
//			System.out.print(areservations.getMemberVO().getMem_name() + ",");
//			System.out.print(areservations.getRes_date() + ",");
//			System.out.print(areservations.getRes_content() + ",");
//			System.out.print(areservations.getRes_time() + ",");
//			System.out.println();
//		}



		//● 查詢-getAll-1 (一方dept2.hbm.xml不用設為lazy="false",因為沒用到多方的物件)
//		List<MemberVO> list1 = dao.getAll();
//		for (MemberVO aMember : list1) {
//			System.out.print(aMember.getMem_no() + ",");
//			System.out.print(aMember.getMem_name() + ",");
//			System.out.print(aMember.getMem_id()+ ",");
//			System.out.print(aMember.getMem_psw()+ ",");
//			System.out.print(aMember.getMem_birthday()+ ",");
//			System.out.print(aMember.getMem_mobile()+ ",");
//			System.out.print(aMember.getMem_image()+ ",");
//			System.out.println("\n-----------------");
//		}



		//● 查詢-getAll-2 (優秀!!!) (一方dept2.hbm.xml必須設為lazy="false")
		List<MemberVO> list2 = dao.getAll();
		for (MemberVO aMember : list2) {
			System.out.print(aMember.getMem_no() + ",");
			System.out.print(aMember.getMem_name() + ",");
			System.out.print(aMember.getMem_id()+ ",");
			System.out.print(aMember.getMem_psw()+ ",");
			System.out.print(aMember.getMem_birthday()+ ",");
			System.out.print(aMember.getMem_mobile()+ ",");
			System.out.print(aMember.getMem_image()+ ",");
			System.out.println("\n-----------------");
			Set<ReservationVO> set2 = aMember.getReservations();
			for (ReservationVO areservation : set2) {
				System.out.print(areservation.getRes_no() + ",");
				System.out.print(areservation.getMemberVO().getMem_name() + ",");
				System.out.print(areservation.getRes_date() + ",");
				System.out.print(areservation.getRes_content() + ",");
				System.out.print(areservation.getRes_time() + ",");
				System.out.println();
			}
			System.out.println();
		}

	}

}
