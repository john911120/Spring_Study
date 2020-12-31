<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>구구단</h2><table><tr bgcolor="cyan">
<c:forEach var="i" begin="2" end="9"><th>${i}단</th></c:forEach>
</tr><tr>
<c:forEach var="i" begin="2" end="9" >
	<c:if test="${i%2==0}"><td bgcolor="orange"></c:if>
	<c:if test="${i%2==1}"><td bgcolor="yellow"></c:if>
	<c:forEach var="j" begin="1" end="9">
		${i } * ${j } = ${i*j }<br>
	</c:forEach></td>
</c:forEach>
</tr></table>
</body>
</html>