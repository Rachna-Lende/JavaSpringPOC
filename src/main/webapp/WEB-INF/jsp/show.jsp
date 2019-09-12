<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1>  
<form:form action="/POC/delete"  method="post"> 
<table border="2" width="70%" cellpadding="2">   
   <c:forEach var="emp" items="${list}">   
   <tr>  
<td><input type="checkbox" name="checkbox" value="${emp.email}"/></td>  
<td><a href="editemp/${emp.name}"> ${emp.name} </a></td>
<td>${emp.email}</td>
<td> ${emp.dateOfBirth} </td>
   </tr>  
   </c:forEach>  
 
   </table>  
   <input type="submit" value="delete">   
</form:form>  
   <br/>  
</body>
</html>