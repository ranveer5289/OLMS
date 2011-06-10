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
        <script language="javascript" src="clearform.js">

        </script>
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AddBook</title>
    </head>
    <body>
        <html:form action="AddBook">
            <table border="1">
                <tbody>
                     <tr>
                         <td>ISBN </td>
                         <td><html:text property = "ISBNNumber"/> </td> 
                     </tr>
                    <tr>
                        <td> Title</td>
                        <td><html:text property="title" /></td>
                    </tr>
                    <tr>
                        <td> Author</td>
                        <td><html:text property="author"/></td>
                    </tr>
                    <tr>
                        <td>Publication</td>
                        <td><html:text property="publication"/></td>
                    </tr>
                    <tr>
                        <td>Edition</td>
                        <td><html:text property="edition"/></td>
                    </tr>
                    <tr>
                        <td>Category</td>
                        <td><html:text property="category"/></td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td><html:text property="price"/></td>
                    </tr>
                    
                    <tr>
                        <td></td>
                        <td><html:submit value="save"/><html:button property = "name" value = "clear" onclick="clearForm()"/></td>
                    </tr>
                     <tr>
                        <td colspan="2">
                            <bean:write name="AddBookForm" property="message" filter = "false"/>
                         </td>
                    </tr>
                </tbody>
            </table>

            

        </html:form>
    </body>
</html>
