<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	http://localhost:8080/sample/ex033?title=dodo&dueDate=2019/11/21<br>
	ex033.jsp파일<br>
<!-- 	INFO : org.zerock.controller.SampleController - todo : TodoDTO(title=dodo, dueDate=Thu Nov 21 00:00:00 KST 2019) -->
	title : ${todoDTO.title}<br>
	dueDate : ${todoDTO.dueDate}
</body>
</html>