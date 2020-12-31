<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	http://localhost:8080/sample/ex02Array?ids=753&ids=270&ids=172&ids=704<br>
	<!-- 파라미터 배열으로 넘어오는 값역시 배열 처리를 해줘야 날아오는 배열값들이 정상적으로 출력된다. -->
	ex02List.jsp파일<br>
	ids0 : ${ids[0]}
	ids1 : ${ids[1]}
	ids2 : ${ids[2]}
	ids3 : ${ids[3]}
</body>
</html>