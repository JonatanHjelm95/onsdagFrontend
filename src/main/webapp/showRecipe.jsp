<%-- 
    Document   : singleRecipe
    Created on : 25-09-2018, 11:34:30
    Author     : porse
--%>

<%@page import="data.Recipe"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Recipe </h1>
        <ul> 
            <% 
                String recipeName = request.getParameter("recipe_id");
                out.println(recipeName);
            %>
        </ul>

    </body>
</html>
