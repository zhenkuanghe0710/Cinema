<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%><html:html>
<head>
<title>SetMovInf</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/web.css" type="text/css">
</head>
<body>



<div class="body">
              <p class="title"><b>Enter the Movie Information</b></p>
					<form method="post" action="./doSetMovInf.do">
            
            <p class="content"> 
                                Title<input type="text" size="10" name="title"><br>
                                Screen<input type="text" size="10" name="screen"><br>
                                Price<input type="text" size="10" name="price"><br>
                                Seats<input type="text" size="10" name="seats"><br>
<input type="submit" value="Go,Insert!"></p>

</form>

<a href="Manage.jsp">Back</a></div>
</body>
</html:html>