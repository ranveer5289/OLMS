<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<%-- 
    Document   : login
    Created on : May 25, 2011, 1:49:50 AM
    Author     : TheSpecialisT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script language="javascript" src="cal2.js">

        </script>
        <script language="javascript" src="cal_conf2.js"></script>
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            
        <title>Login</title>
    </head>
    <body>
    
        <html:form action= "/login">
            <table border="1">
                <tbody>
                    <tr>
                        <td colspan="2">
                         <bean:write name="LoginForm" property="error" filter="false"/>
                    &nbsp;</td>		
                    </tr>
                    <tr>
                        <td>Enter Your Name</td>
                        <td><html:text property = "name" />
                        <html:messages id = "error" property="name" ><bean:write name = "error" />
                        </html:messages><html:messages id = "error" property="name1" ><bean:write name = "error" />
                        </html:messages></td>
                          
                       
                     </tr>
                    <tr>
                        <td>Enter your Email</td>
                        <td><html:password property="email" maxlength = "40"/>
                             <html:messages id = "error" property="email"><bean:write name = "error"/>
                                </html:messages> </td> 
                    </tr>
                    <tr>
                        <td>Enter date</td>                      
                        <td><html:text property="date" /><html:link href="javascript:showCal('Calendar3')">Select Date</html:link></td>
                    </tr>
                    

                    <tr>
                        <td></td>
                        <td><html:submit value="Login"/></td>
                    </tr>
                </tbody>
            </table>

                        <html:link href = "Registration.jsp"><span style='color:red'>REGISTER YOURSELF</span></html:link>                
                        <html:link href = "ForgetPassword.jsp"><span style='color:green'>Forget Password</span></html:link> 
        </html:form>
    </body>
</html>
