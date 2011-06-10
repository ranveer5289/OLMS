<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %> 
<%-- 
    Document   : success
    Created on : May 25, 2011, 2:04:59 AM
    Author     : TheSpecialisT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Success</title>
</head>
<body>
    <h1>Congratulations!</h1>
    <a href = "AddBook.jsp"> Add Book </a> <br>
    
    <html:link href="DeleteBook.jsp">Delete Book</html:link><br>

    <a href = "IssueBook.jsp"> Issue Book </a> <br>  
    
    <a href = "Deposit.jsp"> Deposit Book</a><br>
    
        
    
      

    <p>You have successfully logged in.</p>

    <p>Your name is:<bean:write name="LoginForm" property="name" />.</p>

    <p>your email is:<bean:write name="LoginForm" property="email" />.</p>
    <p>Date:<bean:write name="LoginForm" property="date" />.</p>
</body>
</html>
