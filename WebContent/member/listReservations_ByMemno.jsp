<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- 此頁採用 JSTL 與 EL 取值 --%>

<jsp:useBean id="listReservations_ByMemno" scope="request" type="java.util.Set" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>會員預約 - listReservations_ByMemno.jsp</title>
<s:head theme="xhtml"  /><!-- 預設 -->
</head>
<body bgcolor='white'>

<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td><h3>會員預約 - listReservations_ByMemno.jsp</h3>
		          <a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>	</td></tr></table>

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>預約編號</th>
		<th>會員姓名</th>
		<th>預約日期</th>
		<th>預約內容</th>
		<th>預約時間</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	
	<c:forEach var="reservationVO" items="${listReservations_ByMemno}" >
		<tr align='center' valign='middle' ${(reservationVO.res_no==param["reservationVO.res_no"]) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->
			<td>${reservationVO.res_no}</td>
			<td>${reservationVO.memberVO.mem_name}</td>
			<td>${reservationVO.res_date}</td>
			<td>${reservationVO.res_content}</td>
			<td>${reservationVO.res_time}</td>
			<td>
	          ${reservationVO.memberVO.mem_no}【<font color=orange>${reservationVO.memberVO.mem_name}</font> - ${reservationVO.memberVO.mem_mobile}】               
			</td>
			<td>
			  <s:form action="getOne_For_UpdateReservation" namespace="/reservation"  method="getOne_For_Update">
			     <s:submit value="修改" />
			        <input type="hidden" name="res_no" value="${reservationVO.res_no}">
			        <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			     </s:form>
			</td>
			<td>
			  <s:form action="deleteReservation" namespace="/reservation"  method="delete">
			     <s:submit value="刪除" />
			        <input type="hidden" name="res_no" value="${reservationVO.res_no}">
			        <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			     </s:form>
			</td>
		</tr>
	</c:forEach>
</table>

<br>本網頁的路徑:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
</body>
</html>
