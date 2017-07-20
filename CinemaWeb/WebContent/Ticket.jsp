<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>Ticket</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">
		<p class="title"><font face="@微软雅黑"><b><font color="maroon">T</font>icket
<font color="maroon">L</font>ist</b></font></p>

<form method="post" action="./doCTK.do"><font face="@微软雅黑"> Your
</font><font face="@微软雅黑" color="maroon">Name</font><font face="@微软雅黑">
<input type="text" size="10" name="name"> <input type="submit"
	value="Go,Check!"> </font></form>
		
		<p class="content"><font face="@微软雅黑" color="maroon"> <logic:present
	name="CinemaForm" property="ticketList">
	<logic:notEmpty name="CinemaForm" property="ticketList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				<td align="center"><b>ID</b></td>
				<td align="center"><b>Name</b></td>
				<td align="center"><b>Title</b></td>
				<td align="center"><b>Screen</b></td>
				<td align="center"><b>Price</b></td>
				<td align="center"><b>Quantity</b></td>
				<td align="center"><b>Total</b></td>
			</tr>

			<logic:iterate name="CinemaForm" property="ticketList"
				id="TicketData">
				<tr>
					<td><bean:write name="TicketData" property="id" filter="false" /></td>
					<td><bean:write name="TicketData" property="name"
						filter="false" /></td>
					<td><bean:write name="TicketData" property="title"
						filter="false" /></td>
					<td><bean:write name="TicketData" property="screen"
						filter="false" /></td>
					<td><bean:write name="TicketData" property="price"
						filter="false" /></td>
					<td><bean:write name="TicketData" property="quantity"
						filter="false" /></td>
					<td><bean:write name="TicketData" property="total"
						filter="false" /></td>
				</tr>
			</logic:iterate>
		</table>

	</logic:notEmpty>
</logic:present> <br>
<a href="CinemaIndex.html">Back to Index</a></font></p>
<p class="content"><font face="@微软雅黑" color="maroon"> </font><font
	face="@微软雅黑" size="-1"><a href="Verify.html">To Manage</a>(Admin)</font></p>
</div>
</body>
</html:html>