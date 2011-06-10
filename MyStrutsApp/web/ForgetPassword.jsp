<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%-- 
    Document   : ForgetPassword
    Created on : Jun 8, 2011, 9:59:48 PM
    Author     : ranveer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <html:form action = "/ForgetPassword">
            <label>Email Address</label>
            <html:text  property="emailid"/><html:messages id = "error" property="emailid" ><bean:write name = "error" />
                        </html:messages><html:messages id = "error" property="emailID" ><bean:write name = "error" />
                        </html:messages><br>
            
            <html:submit value="submit"/>
        </html:form>
        
    </body>
</html>
