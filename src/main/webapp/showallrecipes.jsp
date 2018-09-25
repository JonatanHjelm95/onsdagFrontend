<%-- 
    Document   : showallrecipes
    Created on : 25-09-2018, 10:21:52
    Author     : porse
--%>

<%@page import="java.util.List"%>
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
        <h1>Hello World!</h1>
        <ul>
            <%
                ArrayList<Recipe> recipes = (ArrayList) request.getSession(false).getAttribute("recipes");
                for (Recipe recipe : recipes) {
                    out.println("<li><a href=\"?origin=showRecipe&recipe_id=\""+recipe.getRecipeName()+"\">" + recipe.getRecipeName() + "</a></li>");
                }
            %>
        </ul>
    </body>
</html>
