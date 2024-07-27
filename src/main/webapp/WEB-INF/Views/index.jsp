<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Register Student</h2>
  <form action="processForm" method="Post">
    <div class="form-group">
      <label for="email">roll No:</label>
      <input type="text" class="form-control" id="rollNo" placeholder="Enter Roll No" name="rollNo">
    </div>
    <div class="form-group">
      <label for="pwd">student name:</label>
      <input type="text" class="form-control" id="studentName" placeholder="Enter Name" name="studentName">
    </div>
    <div class="form-group">
      <label for="pwd">grade:</label>
      <input type="text" class="form-control" id="grade" placeholder="Enter grade" name="grade">
    </div>
    
    <button type="submit" class="btn btn-default" name="action">Submit</button>
  </form>
</div>

<c:out value="${msg}" />

</body>
</html>
