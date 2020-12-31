<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/sample/all Page</h1>
		Page614 내용 정상 작동되면 메시지를 출력시킵니다.<hr>
	Page 674 표현식을 이용하는 동작 구성(로그인 사용자와 비로그인 사용자에 따라 결과가 다르게 출력된다.)<hr>	
	<sec:authorize access="isAnonymous()">
		<a href="/customLogin">로그인 사이트로 이동</a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<a href="/customLogout">로그아웃</a>
	</sec:authorize>
</body>
</html>