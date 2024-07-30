<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>student details</title>
</head>
<body>
	
	<h1><c:out value="${Heading }" /></h1>
	<p><c:out value="${desc }" /></p>
	
	<hr>
	
	<h1>Student details</h1>
	<h1>Name :  <c:out value="${student.studentName }" /></h1>	
	<h1>Grade :  <c:out value="${student.grade }" /></h1>	
	<h1>Roll No :  <c:out value="${student.rollNo }" /></h1>	
	
</body>
</html>