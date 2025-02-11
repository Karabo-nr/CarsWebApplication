<%-- 
    Document   : output
    Created on : 01 May 2024, 11:14:18 PM
    Author     : karab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>OutPut</h1>
        
        <%
            String name = String.valueOf(request.getAttribute("name"));
            
            
            
          %>
          <%=name%> has been stored
    </body>
</html>
