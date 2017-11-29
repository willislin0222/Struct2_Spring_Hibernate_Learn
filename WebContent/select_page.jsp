<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head theme="xhtml" /><!-- 預設 -->
</head>
<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>IBM Emp: Home</h3>	<font color=red>( Struts2-Spring-Hibernate  MVC )</font></td></tr></table>

	<p>This is the Home page</p>

	<h3>資料查詢:</h3>
	<%-- 錯誤表列 --%>
    <s:fielderror cssStyle="color: red" />

	<ul>
		<li><a href='<%=request.getContextPath()%>/reservation/listAllReservation.jsp'>List</a> all Reservations.</li><br>

		<li>
            <s:form action="getOne_For_DisplayReservation" namespace="/reservation" theme="simple">  【<font color=blue>theme="simple"</font>】
               <b>輸入預約編號 (如):20171129-RES00000010</b> 
                <s:textfield name="res_no" />
				<s:submit	 value="送出"  method="getOne_For_Display" />
            </s:form>
		</li>

        <s:bean id="reservationSvc" name="com.reservation.model.ReservationService" />     <%-- 相當於  <jsp:useBean id="reservationSvc" scope="request" class="com.reservation.model.ReservationService" /> --%>

		<li>
			<s:form action="getOne_For_DisplayReservation" namespace="/reservation" theme="simple">  【<font color=blue>theme="simple"</font>】
				<b>選擇預約編號:</b>
				<s:select name="res_no" labelposition="center" list="#reservationSvc.all" listKey="res_no" listValue="res_no" /> 
				<s:submit value="送出"  method="getOne_For_Display" />
			</s:form>
		</li>
		
		<li>
			<s:form action="getOne_For_DisplayReservation" namespace="/reservation" theme="simple">  【<font color=blue>theme="simple"</font>】
				<b>選擇預約日期:</b>
				<s:select name="res_no" labelposition="center" list="#reservationSvc.all" listKey="res_no" listValue="res_date" /> 
				<s:submit value="送出"  method="getOne_For_Display" />
			</s:form>
		</li>
		
        <s:bean id="memberSvc" name="com.member.model.MemberService" />     <%-- 相當於  <jsp:useBean id="memberSvc" scope="page" class="com.member.model.MemberService" /> --%>
		
		<li>
			<s:form action="listReservationsByMemno" namespace="/member" theme="simple">  【<font color=blue>theme="simple"</font>】
				<b><font color=orange>選擇會員:</font></b>
				<s:select name="mem_no" labelposition="center" list="#memberSvc.all" listKey="mem_no" listValue="mem_name" />
				<s:submit value="送出"   method="listReservations_ByMemno" />
				<input type="hidden" name="action" value="listReservations_ByMemno_A">
			</s:form>
		</li>
		
	</ul>


	<h3>會員管理</h3>
	
	<ul>
		<li><a href='<%=request.getContextPath()%>/reservation/addReservation.jsp'>Add</a> a new Reservation.</li>
	</ul>
	
	<h3><font color=orange>會員管理</font></h3>

    <ul>
        <li><a href='<%=request.getContextPath()%>/member/listAllMember.jsp'>List</a> all Members. </li>
    </ul>

</body>
</html>
