<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.reservation.model.*"%>
<%-- 此頁因為不需要做錯誤驗證, 所以(刻意)不使用Struts2的表單UI標籤, 仍使用傳統的Html標籤  --%>

<jsp:useBean id="memberSvc" scope="page" class="com.member.model.MemberService" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>所有會員 - listAllMember.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁因為不需要做錯誤驗證, 所以(刻意)不使用Struts2的表單UI標籤, 仍使用傳統的Html標籤</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='orange' align='center' valign='middle' height='20'>
		<td>
		<h3>所有會員- ListAllMember.jsp</h3>
		<a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
		</td>
	</tr>
</table>

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>會員編號</th>
		<th>會員姓名</th>
		<th>會員ID</th>
		<th>會員密碼</th>
		<th>會員生日</th>
		<th>會員電話</th>
		<th>會員圖片</th>
		<th>修改</th>
		<th>刪除<font color=red>(關聯測試與交易-小心)</font></th>
		<th>查詢部門員工</th>
	</tr>
	
	<c:forEach var="memberVO" items="${memberSvc.all}">
		<tr align='center' valign='middle'>
			<td>${memberVO.mem_no}</td>
			<td>${memberVO.mem_name}</td>
			<td>${memberVO.mem_id}</td>
			<td>${memberVO.mem_psw}</td>
			<td>${memberVO.mem_birthday}</td>
			<td>${memberVO.mem_mobile}</td>
			<td>${memberVO.mem_image}</td>
			<td>
			  <FORM METHOD="post" ACTION="updateDept.action">
			    <input type="submit" value="修改" disabled> 
			    <input type="hidden" name="mem_no" value="${memberVO.mem_no}">
			    <input type="hidden" name="action" value="getOne_For_Update_Member">
			</td></FORM>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/deleteMember.action">
			    <input type="submit" value="刪除">
			    <input type="hidden" name="mem_no" value="${memberVO.mem_no}">
			    <input type="hidden" name="action" value="delete_Member">
			</td></FORM>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/member/listReservationsByMemno.action">
			    <input type="submit" value="送出查詢"> 
			    <input type="hidden" name="mem_no" value="${memberVO.mem_no}">
			    <input type="hidden" name="action" value="listReservations_ByMemno_B">
			</td></FORM>
		</tr>
	</c:forEach>
</table>

<%if (request.getAttribute("listReservations_ByMemno")!=null){%>
       <jsp:include page="listReservations_ByMemno.jsp" />
<%} %>

</body>
</html>
