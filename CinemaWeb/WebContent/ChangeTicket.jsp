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
		<p class="title"><b><font color="green">T</font>icket <font
	color="green">L</font>ist</b></p>

<form method="post" action="./doPCTK.do">
Your <font color="green">Name</font> <input type="text" size="10" name="name">
<input type="submit"  value="Go,Check!"></form>
		
		<p class="content">
		
				<logic:present name="CinemaForm" property="ticketList">
					<logic:notEmpty name="CinemaForm" property="ticketList">
					
						<table border="1px"  cellspacing="0px" cellpadding="6px">
								<tr>
										<td align="center"><font color="green"><b>ID</b></font></td>
										<td align="center"><font color="green"><b>Name</b></font></td>
										<td align="center"><font color="green"><b>Title</b></font></td>
										<td align="center"><font color="green"><b>Screen</b></font></td>
										<td align="center"><font color="green"><b>Price</b></font></td>
										<td align="center"><font color="green"><b>Quantity</b></font></td>
										<td align="center"><font color="green"><b>Total</b></font></td>
								</tr>
				
								<logic:iterate name="CinemaForm" property="ticketList" id="TicketData">
										<tr>
												<td><bean:write name="TicketData" property="id" filter="false"/></td>
												<td><bean:write name="TicketData" property="name" filter="false"/></td>
												<td><bean:write name="TicketData" property="title" filter="false"/></td>
												<td><bean:write name="TicketData" property="screen" filter="false"/></td>
												<td><bean:write name="TicketData" property="price" filter="false"/></td>
												<td><bean:write name="TicketData" property="quantity" filter="false"/></td>
												<td><bean:write name="TicketData" property="total" filter="false"/></td>
										</tr>
								</logic:iterate>
						</table>
						
				</logic:notEmpty>
			</logic:present>
			
			    <p class="title"> <b><font color="green">P</font>lease<font
	color="green"> E</font>nter <font
	color="green">Y</font>our <font color="green">C</font>hange</b></p>
	
	<form method="post" action="./doCHTK.do">
<b><font size="+1"><u>Old Order</u></font><br>
<br>
<font color="green">ID</font> <input type="text" size="8" name="id"><br>
<br>
Change <font color="green">Quantity</font> to <input type="text" size="5" name="cquantity"><br>
<br>
Your <font color="green">Name</font> <input type="text" size="10" name="name"> <br>
Your <font color="green">E-mail</font> Address <input type="text" size="30" name="receiver"></b><br>
<br>
<input type="submit"  value="Go, Change Quantity !"><br>
</form>
<b><font size="+1" color="green">OR</font></b><br>
<b><br>

<a href="DelTicket.jsp"><font size="+2">Make a New Order</font><br>
</a></b><br>
<br>
      <a href="CinemaIndex.html">Back to Index</a></div>
</body>
</html:html>