<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student details</title>
</head>
<body>
	<h1>Student details : </h1>
	
	<hr>
	<c:if test="${student!= null }">
		
	<h3>Student Name : ${student.studentName }</h3>
	<h3>Student roll : ${student.rollNo }</h3>
	<h3>Grade        : ${student.grade }</h3>
	</c:if>
	
	<c:if test="${msg!=null}" >
		<h3> <c:out value="${msg }" /></h3>
	</c:if>
</body>
</html>