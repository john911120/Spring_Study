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
	<h1>/sample/admin Page</h1>
	Page614 내용 정상 작동되면 메시지를 출력시킵니다.<hr>
	Page642 Sample/admin 페이지에서 로그아웃 처리를 하는 링크를 넣는다. <hr>
	<hr>
	Page672 JSP에서 로그인한 사용자의 정보를 보여드립니다.<br>
	<p>Principal : <sec:authentication property="principal"/> </p>
	<p>MemberVO : <sec:authentication property="principal.member"/> </p>
	<p>사용자이름 : <sec:authentication property="principal.member.userName"/> </p>
	<p>사용자아이디 : <sec:authentication property="principal.username"/></p>
	<p>사용자 권한 리스트 : <sec:authentication property="principal.member.authList"/> </p>
	<a href="/customLogout">Logout</a>
</body>
</html>