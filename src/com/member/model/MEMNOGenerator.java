package com.member.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class MEMNOGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String prefix="MEM";  //您要產生的自增主鍵字串
		Connection con= session.connection(); //產生連線
		try {
			PreparedStatement pstmt = con.prepareStatement("select MEM_seq.nextval from dual"); //從資料庫取的下一個SEQUENCE的值
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				int no = rs.getInt("nextval"); //將此次的值放到no的變數中
				String code = prefix + StringUtils.leftPad("" + no, 8, '0');  //將變數code裡放入要產生的自訂自增主鍵(此範例為MEM000000XX)
				return code; //回傳要產生的自增主鍵code
			}
			
		} catch (SQLException e) {
			throw new HibernateException("Unable to generate Stock Code Sequence");
		}
		
		return null;
	}

}
