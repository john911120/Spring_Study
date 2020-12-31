<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	http://localhost:8080/sample/ex044?name=gin&page=4<br>
	ex044.jsp파일<br>
	<hr>
	@ModelAttribute를 사용하면 정상적으로 page가 전달이 된것을 확인할 수 있다.<br>
	dto : ${sampleDTO}<br>
	page : ${page}
</body>
</html>