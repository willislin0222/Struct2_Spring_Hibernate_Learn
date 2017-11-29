<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>預約資料 - listOneReservation.jsp</title>
<s:head theme="xhtml" /><!-- 預設 -->
</head>
<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='1000'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>員工資料 - ListOneEmp.jsp</h3>
		              <a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></td></tr></table>

	<table border='1' bordercolor='#CCCCFF' width='1000'>
		<tr>
			<th align="left">EL 或 OGNL(Object-Graph Navigation Language)</th>
			<th>預約編號</th>
			<th>會員姓名</th>
			<th>預約日期</th>
			<th>預約內容</th>
			<th>預約時間</th>
			<th>修改</th>
			<th>刪除</th>
		</tr>
		<tr align='center' valign='middle'>
		     <td align="left">EL</td>
		     <td>${reservationVO.res_no}</td>
			 <td>${reservationVO.memberVO.mem_name}</td>
             <td>${reservationVO.res_date}</td>
             <td>${reservationVO.res_content}</td>
             <td>${reservationVO.res_time}</td>
             <td>${reservationVO.memberVO.mem_name}【${reservationVO.memberVO.mem_mobile} - ${reservationVO.memberVO.mem_birthday}】</td>
		</tr>
		<tr align='center' valign='middle'>
		     <td align="left">OGNL-  #request.empVO.xxx</td>
			 <td><s:property value="#request.reservationVO.res_no" /></td>
			 <td><s:property value="#request.reservationVO.memberVO.mem_name" /></td>
             <td><s:property value="#request.reservationVO.res_date" /></td>
             <td><s:property value="#request.reservationVO.res_content" /></td>
             <td><s:property value="#request.reservationVO.res_time" /></td>
             <td><s:property value="#request.reservationVO.memberVO.mem_name" />【<s:property value="#request.reservationVO.memberVO.mem_mobile" /> - <s:property value="#request.reservationVO.memberVO.mem_birthday" />】</td>
		</tr>
	</table>

</body>
</html>
