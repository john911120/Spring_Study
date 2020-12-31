<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	http://localhost:8080/sample/ex04?name=gin&page=4<br>
	ex04.jsp파일<br>
	dto : ${sampleDTO}<br>
	page : ${page}
	<hr>
	page를 전달하려면 @ModelAttribute를 사용해야 전달이 가능해진다.
</body>
</html>