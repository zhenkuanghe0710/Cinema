<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>Book</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">
		<p class="title"><b><font color="green">M</font>ovie <font
	color="green">L</font>ist</b></p>
		<b>Check <font color="green"><a href="./doBCMI.do">All</a></font></b><font
	color="green"></font><form method="post" action="./doBCMI.do"><font color="green">
Title </font><input type="text" size="10" name="title">
<input type="submit"  value="Go,filter!"></form>

<form method="post" action="./doBCMI.do"><font color="green">
Screen</font> <input type="text" size="10" name="screen">
<input type="submit"  value="Go,filter!"></form>
		
		<p class="content">
		
				<logic:present name="CinemaForm" property="movinfList">
					<logic:notEmpty name="CinemaForm" property="movinfList">
					
						<table border="1px"  cellspacing="0px" cellpadding="6px">
								<tr>
										<td align="center"><font color="green"><b>ID</b></font></td>
										<td align="center"><font color="green"><b>Title</b></font></td>
										<td align="center"><font color="green"><b>Screen</b></font></td>
										<td align="center"><font color="green"><b>Price</b></font></td>
										<td align="center"><font color="green"><b>Seats</b></font></td>
								</tr>
				
								<logic:iterate name="CinemaForm" property="movinfList" id="MovInfData">
										<tr>
												<td><bean:write name="MovInfData" property="id" filter="false"/></td>
												<td><bean:write name="MovInfData" property="title" filter="false"/></td>
												<td><bean:write name="MovInfData" property="screen" filter="false"/></td>
												<td><bean:write name="MovInfData" property="price" filter="false"/></td>
												<td><bean:write name="MovInfData" property="seats" filter="false"/></td>
										</tr>
								</logic:iterate>
						</table>
						
				</logic:notEmpty>
			</logic:present>
				
					<p class="title"><b><font color="green">P</font>lease <font
	color="green">E</font>nter <font color="green">Y</font>our <font
	color="green">C</font>hoice</b></p>
					
					<form method="post" action="./doBook.do">
                               <b>Movie <font color="green">Title</font></b><font
	color="green"></font> <input type="text" size="10" name="title"><br>
                               <b>Movie <font color="green">Screen</font></b> <input type="text" size="10" name="screen"><br>
                               <b><font color="green">Quantity</font></b> <input type="text" size="10" name="quantity"><br><br>
                               <b>Your <font color="green">Name</font></b> <input type="text" size="10" name="name"><br>
                               <b>Your <font color="green">E-mail</font> Address</b> <input type="text" size="30" name="receiver"><br><br>
                               <input type="submit"  value="Go,Book!"></form>




		<a href="CinemaIndex.html">Back to Index</a></div>
</body>
</html:html>