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

<p class="title"><font face="微软雅黑"><b><font color="maroon">M</font><font>ovie
</font><font color="maroon">L</font><font>ist</font></b></font></p>
<font face="微软雅黑"> </font><font face="微软雅黑" color="maroon"><b>Y</b></font><font
	face="微软雅黑"><b>ou </b></font><font face="微软雅黑" color="maroon"><b>C</b></font><font
	face="微软雅黑"><b>an </b></font><font face="微软雅黑" color="maroon"><b>C</b></font><font
	face="微软雅黑"><b>heck </b></font><font face="微软雅黑" color="maroon"><b><a
	href="./doCMI.do">All</a></b><br>
<br>
<b>OR</b></font><font face="微软雅黑"><br>
<br>
</font><font face="微软雅黑" color="maroon"><b>E</b></font><font face="微软雅黑"><b>nter
</b></font><font face="微软雅黑" color="maroon"><b>Y</b></font><font
	face="微软雅黑"><b>our </b></font><font face="微软雅黑" color="maroon"><b>C</b></font><font
	face="微软雅黑"><b>hioce</b></font>
<form method="post" action="./doCMI.do"><font face="微软雅黑"> </font><font
	face="微软雅黑" color="maroon">Title </font><font face="微软雅黑"><input
	type="text" size="10" name="title"> <input type="submit"
	value="Go,Search!"><br>
</font></form>

<form method="post" action="./doCMI.do"><font face="微软雅黑" color="maroon">
Screen </font><font face="微软雅黑"><input type="text" size="10"
	name="screen"> <input type="submit" value="Go,Search!"></font></form>

		
		<p class="content"><font face="微软雅黑" color="maroon"> <logic:present
	name="CinemaForm" property="movinfList">
	<logic:notEmpty name="CinemaForm" property="movinfList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				<td align="center"><font color="maroon"><b>ID</b></font></td>
				<td align="center"><font color="maroon"><b>Title</b></font></td>
				<td align="center"><font color="maroon"><b>Screen</b></font></td>
				<td align="center"><font color="maroon"><b>Price</b></font></td>
				<td align="center"><font color="maroon"><b>Seats</b></font></td>
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
</logic:present> <br>
<a href="CinemaIndex.html">Back to Index</a><br>
<br>
</font><font face="微软雅黑" size="-1"><a href="Verify.html">To
Manage</a>(Admin)</font></div>
</body>
</html:html>