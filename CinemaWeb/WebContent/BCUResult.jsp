<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@page	language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html:html>
<head>
		<title>Result</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/web.css" type="text/css">
</head>

<body>
		<div class="body">
				<p class="title"><b>Message</b></p>
				<p class="content">
				   <bean:write name="CinemaForm" property = "result" filter ="false"/><br><br>
				   The Comfrim Message Has been Sent to Your MailBox at 
						<bean:write name="CinemaForm" property="timestamp" filter="false"/></p>
			
			<a href="CinemaIndex.html">Back to Index</a></div>
</body>

</html:html>