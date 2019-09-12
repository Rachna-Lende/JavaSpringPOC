<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>  
<head>  
<style>  
.error{color:red}  
</style>  
</head>  
<body>  
<c:set var="contextPath" value="${pageContext.request.contextPath}"/> 
<form:form action="/POC/editSave" modelAttribute="command" method="post">  
Name(*): <form:input path="name"/> <br><br>  
<form:errors path="name" cssClass="error"/><br><br>  

<!-- Email: <form:input path="email"/> <br><br> 
<form:errors path="email" cssClass="error"/><br><br>  -->

<form:input path="email" type = "hidden"/>

Date Of Birth: <form:input path="dateOfBirth"/> <br><br>
<form:errors path="dateOfBirth" cssClass="error"/><br><br> 

Password: <form:password path="password"/>    
<form:errors path="password" cssClass="error"/><br><br> 

<input type="submit" value="update">  
</form:form>  
</body>  
</html>  