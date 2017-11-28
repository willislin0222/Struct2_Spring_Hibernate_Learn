package com.reservation.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RESNOGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		//==格式化
		SimpleDateFormat nowdate = new java.text.SimpleDateFormat("yyyyMMdd"); 

		//==GMT標準時間往後加八小時
		nowdate.setTimeZone(TimeZone.getTimeZone("GMT+8"));

		//==取得目前時間
		String sdate = nowdate.format(new java.util.Date());
		
		String prefix=sdate + "-RES";  //您要產生的自增主鍵字串
		Connection con= session.connection(); //產生連線
		try {
			PreparedStatement pstmt = con.prepareStatement("select RES_seq.nextval from dual"); //從資料庫取的下一個SEQUENCE的值
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				int no = rs.getInt("nextval"); //將此次的值放到no的變數中
				String code = prefix + StringUtils.leftPad("" + no, 8, '0');  //將變數code裡放入要產生的自訂自增主鍵(此範例為今天日期-RESXXXXXX)
				return code; //回傳要產生的自增主鍵code
			}
			
		} catch (SQLException e) {
			throw new HibernateException("Unable to generate Stock Code Sequence");
		}
		
		return null;
	}

}
