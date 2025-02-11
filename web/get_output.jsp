<%-- 
    Document   : get_output
    Created on : 01 May 2024, 11:53:16 PM
    Author     : karab
--%>


<%@page import="java.util.Base64"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity.Cars"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            List<Cars> cars = (List<Cars>)request.getAttribute("cars");
            for (int i = 0; i < cars.size(); i++) {
                
            String image_source = "data:image/png;base64, " + Base64.getEncoder().encodeToString(cars.get(i).getImage_source());
          %>
          <table >
              
              <tbody>
                  <tr>
                      <td></td>
                      <td></td>
                  </tr>
                  <tr>
                      <td></td>
                      <td><img src="<%=image_source%>" width="200" height="200" alt="alt"/></td>
                  </tr>
              </tbody>
              <%
              }
              %>
          </table>
          


    </body>
</html>

