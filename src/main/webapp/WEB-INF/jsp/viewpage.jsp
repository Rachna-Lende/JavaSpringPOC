<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>  
<head>  
<style>  
.error{color:red}  
</style>  
</head>  
<body>  
<form:form action="helloagain" modelAttribute="emp" method="post">  
Name(*): <form:input path="name"/> <br><br>  
<form:errors path="name" cssClass="error"/><br><br>  

Email: <form:input path="email"/> <br><br> 
<form:errors path="email" cssClass="error"/><br><br> 

Date Of Birth: <form:input path="dateOfBirth"/> <br><br>
<form:errors path="dateOfBirth" cssClass="error"/><br><br> 

Password: <form:password path="password"/>    
<form:errors path="password" cssClass="error"/><br><br> 

<input type="submit" value="submit">  
</form:form>  
</body>  
</html>  