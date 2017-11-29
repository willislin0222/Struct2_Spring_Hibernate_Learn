<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.reservation.model.*"%>

<jsp:useBean id="memberSvc" scope="page" class="com.member.model.MemberService" />

<html>
<head>
<title>所有會員- listAllMember-with-Reservations.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='805'>
	<tr bgcolor='orange' align='center' valign='middle' height='20'>
		<td>
		<h3>所有會員 - listAllMember-with-Reservations.jsp</h3>
		<a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></td>
	</tr>
</table>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>請修正以下錯誤:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>

<table border='0' bordercolor='#CCCCFF'>
	<c:forEach var="memberVO" items="${memberSvc.all}">
		<tr bgcolor='orange'>
			<th>會員編號</th>
			<th>會員姓名</th>
			<th>會員ID</th>
			<th>會員密碼</th>
			<th>會員生日</th>
			<th>會員電話</th>
			<th>會員圖片</th>
		</tr>

		<tr bgcolor='orange' align='center' valign='middle'>
			<td><font color=red><b>${memberVO.mem_no}</b></font></td>
			<td>${memberVO.mem_name}</td>
			<td>${memberVO.mem_id}</td>
			<td>${memberVO.mem_psw}</td>
			<td>${memberVO.mem_birthday}</td>
			<td>${memberVO.mem_mobile}</td>
			<td>${memberVO.mem_image}</td>
		</tr>

		<tr align='center' valign='middle'>
			<td colspan="3" bordercolor='#CCCCFF'>
			<table border='1' bordercolor='black' width='800'>
				<tr>
					<th>預約編號</th>
					<th>會員姓名</th>
					<th>預約日期</th>
					<th>預約項目</th>
					<th>預約時間</th>
				</tr>

				<c:forEach var="reservationVO" items="${memberVO.reservations}">
					<tr align='center' valign='middle' ${(reservationVO.res_no==param.res_no)
						? 'bgcolor=#CCCCFF':''}>
						<td>${reservationVO.res_no}</td>
						<td>${reservationVO.memberVO.mem_name}</td>
						<td>${reservationVO.res_date}</td>
						<td>${reservationVO.res_content}</td>
						<td>${reservationVO.res_time}</td>
					</tr>
				</c:forEach>
			</table>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
