<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>MovInf</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">

<p class="title"><font><font><b>Movie
List</b></font></font></p>
<font> <font> <b>You Can Check </b><font color="maroon"><b><a
	href="./doDCMI.do">All</a></b><br>
<br>
</font>OR<br>
<br>
<b>Enter Your Chioce</b> </font> </font>
<form method="post" action="./doDCMI.do"><font><font>
Title<font color="maroon"> </font><input type="text" size="10"
	name="title"> <input type="submit" value="Go,Search!"><br>
</font></font></form>

<form method="post" action="./doDCMI.do"><font><font> Screen <input type="text" size="10"
	name="screen"> <input type="submit" value="Go,Search!"></font></font></form>

		
		<p class="content"><font><font><font color="maroon">
<logic:present name="CinemaForm" property="movinfList">
	<logic:notEmpty name="CinemaForm" property="movinfList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				<td align="center"><b>ID</b></td>
				<td align="center"><b>Title</b></td>
				<td align="center"><b>Screen</b></td>
				<td align="center"><b>Price</b></td>
				<td align="center"><b>Seats</b></td>
			</tr>

			<logic:iterate name="CinemaForm" property="movinfList"
				id="MovInfData">
				<tr>
					<td><bean:write name="MovInfData" property="id" filter="false" /></td>
					<td><bean:write name="MovInfData" property="title"
						filter="false" /></td>
					<td><bean:write name="MovInfData" property="screen"
						filter="false" /></td>
					<td><bean:write name="MovInfData" property="price"
						filter="false" /></td>
					<td><bean:write name="MovInfData" property="seats"
						filter="false" /></td>
				</tr>
			</logic:iterate>
		</table>

	</logic:notEmpty>
</logic:present> </font> </font></font></p>
<p class="content"><font><font><b> Enter Movie
Information</b></font></font><form method="post" action="./doDMI.do"><font>
ID <input type="text" size="10" name="id"><br>

<input type="submit" value="Go,Delete!"> </font></form>
<font> <font> <font color="maroon"> <br>
<a href="Manage.jsp">Back</a></font></font></font></div>
</body>
</html:html>