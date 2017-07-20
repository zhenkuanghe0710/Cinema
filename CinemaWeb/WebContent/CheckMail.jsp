<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html:html>
<head>
		<title>Check Mail</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
<div class="body">
		<p class="title"><font face="微软雅黑" color="maroon"><b>M</b></font><font
	face="微软雅黑"><b>ail </b></font><font face="微软雅黑" color="maroon"><b>B</b></font><font
	face="微软雅黑"><b>ox</b></font></p>
			
		<p class="content">
		
		<form method="post" action="./doCM.do"><font face="微软雅黑"> </font><font
	face="微软雅黑" color="maroon">Y</font><font face="微软雅黑">our </font><font
	face="微软雅黑" color="maroon">E</font><font face="微软雅黑">mail
</font><font face="微软雅黑" color="maroon">A</font><font face="微软雅黑">ddress
<input type="text" size="25" name="receiver"> <br>
<br>
<input type="submit" value="Go,Check!"> </font></form>
<font face="微软雅黑" color="maroon"> <logic:present
	name="CinemaForm" property="mailList">
	<logic:notEmpty name="CinemaForm" property="mailList">

		<table border="1px" cellspacing="0px" cellpadding="6px">
			<tr>
				<td align="center"><font color="maroon"><b>ID</b></font></td>
				<td align="center"><font color="maroon"><b>Sender</b></font></td>
				<td align="center"><font color="maroon"><b>Subject</b></font></td>
				<td align="center"><font color="maroon"><b>Content</b></font></td>
				<td align="center"><font color="maroon"><b>Timestamp</b></font></td>
			</tr>

			<logic:iterate name="CinemaForm" property="mailList" id="MailData">
				<tr>
					<td><bean:write name="MailData" property="id" filter="false" /></td>
					<td><bean:write name="MailData" property="sender"
						filter="false" /></td>
					<td><bean:write name="MailData" property="subject"
						filter="false" /></td>
					<td><bean:write name="MailData" property="content"
						filter="false" /></td>
					<td><bean:write name="MailData" property="timestamp"
						filter="false" /></td>
				</tr>
			</logic:iterate>
		</table>

	</logic:notEmpty>
</logic:present> <logic:present name="CinemaForm" property="mailList">
	<logic:empty name="CinemaForm" property="mailList">
					           No Mail in the Mailbox: <bean:write name="CinemaForm"
			property="receiver" filter="false" />
	</logic:empty>
</logic:present> <a href="CinemaIndex.html"><br>
<br>
Back to Index</a></font><br>
<br>
<font face="微软雅黑" size="-1"><a href="Verify.html">To Manage</a>(Admin)</font>
</div>
</body>
</html:html>