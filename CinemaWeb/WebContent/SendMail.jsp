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
		<p class="title"><font face="微软雅黑" color="maroon"><b>Feedback Message</b></font></p>
			
		<p class="content">
		
		<form method="post" action="./doSM.do"><font face="微软雅黑"> </font><font
	face="微软雅黑" color="maroon">Y</font><font face="微软雅黑">our </font><font
	face="微软雅黑" color="maroon">Name</font><font face="微软雅黑">
<input type="text" size="15" name="name"> <br>
<br>
Your Suggestions
and Criticisms<br>
<br>
<input type="text" size="100" name="result">
<br>
<br>
<input type="submit" value="Go,Send!"> </font></form><font face="微软雅黑" color="maroon"><a href="CinemaIndex.html"><br>
Back to Index</a></font><br>
</div>
</body>
</html:html>