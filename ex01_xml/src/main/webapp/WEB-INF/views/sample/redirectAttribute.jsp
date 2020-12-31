<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	redirectAttribute.jsp 내용<br>
	msg : ${msg}<br>
	attr : ${param.attr}<br>
	<hr>
	<%= request.getAttribute("msg")%>
	<%= request.getParameter("attr")%>
</body>
</html>