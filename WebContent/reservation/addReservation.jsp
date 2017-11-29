<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>預約資料新增 - addEmp.jsp</title>
<s:head theme="xhtml" /><!-- 預設 -->
<sx:head debug="false" cache="false" parseContent="false"	compressed="false" extraLocales="zh-tw,en-us,ja,ko" />
</head>
<body bgcolor='white' onLoad="setValue()">

	<table border='1' cellpadding='5' cellspacing='0' width='500'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>預約資料新增 - addEmp.jsp</h3></td>
			<td><a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/tomcat.gif"	width="100" height="100" border="1"> 回首頁 </a></td></tr></table>

	<%-- 錯誤表列 --%>
	<%-- <s:fielderror cssStyle="color: blue" /> --%>

	<h3>員工資料:</h3>
	<s:form action="addReservation" namespace="/reservation">
		<s:textfield name="reservationVO.memberVO.mem_no" label="會員編號" value="MEM00000012" />
		<sx:datetimepicker name="reservationVO.res_date" label="預約日期"	type="date" displayFormat="yyyy-MM-dd " id="picker1" language="zh-tw" cssStyle="background:cyan ; font-size:13.5px" /><%-- 捨棄原來的 value="%{'today'}" , 改用javascript的setValue()--%>
		<s:textfield name="reservationVO.res_content"  label="預約項目" />
		<s:textfield name="reservationVO.res_time" label="預約時間" />
	    <s:submit value="送出新增" method="add" />
	</s:form>

	<script type="text/javascript">
		function setValue() {
			var picker1 = dojo.widget.byId("picker1");
			if (picker1.getValue() == "")
				picker1.setValue(new Date()); //Date value  //picker.setValue('2007-01-01');  //string value
		}
	</script>

</body>
</html>

