<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="board/list">게시판으로 이동</a>
	<script>
	function expireSession(){
		window.location = "board/list";
	}
	setTimeout('expireSession()', <%= request.getSession().getMaxInactiveInterval() %>);
	</script>
	
	<%--
	<%
		pageContext.forward("board/list");
	%>
	 --%>
<%-- 	<jsp:forward page="board/list"></jsp:forward> --%>
<%-- 	<% response.sendRedirect("board/list"); %> --%>
</body>
</html>