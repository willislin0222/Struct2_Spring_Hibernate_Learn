<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>預約資料修改 - update_reservation_input.jsp</title>
<s:head theme="xhtml"  /><!-- 預設 -->
<sx:head debug="false" cache="false"  parseContent="false" compressed="false"  extraLocales="zh-tw,en-us,ja,ko"/>
</head>
<body bgcolor='white' >

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>預約資料修改 - update_reservation_input.jsp</h3>
			          <a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif"  width="100" height="32" border="0">回首頁 </a></td></tr></table>
	
	<h3>員工資料:</h3>
	<s:form action="updateReservation" namespace="/reservation" >
	    <s:textfield name="reservationVO.res_no" label="預約編號" value="%{#request.reservationVO.res_no}"  readonly="true" cssStyle="background:gray" />
		<s:textfield name="reservationVO.memberVO.mem_no" label="會員姓名" value="%{#request.reservationVO.memberVO.mem_no}"/> 
		<sx:datetimepicker name="reservationVO.res_date"  label="預約日期"  type="date" displayFormat="yyyy-MM-dd"  id="picker1" language="zh-tw" cssStyle="background:cyan ; font-size:13.5px" value="%{#request.reservationVO.res_date}"/>
		<s:textfield name="reservationVO.res_content"  label="預約內容" value="%{#request.reservationVO.res_content}"/>
		<s:textfield name="reservationVO.res_time" label="預約時間" value="%{#request.reservationVO.res_time}"/>
		<s:submit value="送出" method="update"/>
		<s:reset  value="重新輸入" />
		<input type="hidden" name="requestURL" value="<%=request.getParameter("requestURL")%>"><!--原送出修改的來源網頁路徑,從request取出後,再送給Controller準備轉交之用-->
        <input type="hidden" name="whichPage" value="<%=request.getParameter("whichPage")%>">  <!--只用於:istAllReservation.jsp-->
	</s:form>

<br>送出修改的來源網頁路徑:<br><b>
   <font color=blue>request.getParameter("requestURL"):</font> <%= request.getParameter("requestURL")%><br>
   <font color=blue>request.getParameter("whichPage"):</font> <%= request.getParameter("whichPage")%> (此範例目前只用於:istAllEmp.jsp))</b>
</body>
</html>

