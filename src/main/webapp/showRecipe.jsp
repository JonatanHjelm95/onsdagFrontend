<%-- 
    Document   : singleRecipe
    Created on : 25-09-2018, 11:34:30
    Author     : porse
--%>

<%@page import="logic.LogicController"%>
<%@page import="data.Recipe"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1> Recipe </h1>
        <%
            String recipeName = request.getParameter("recipe_id");
            ArrayList<Recipe> recipes = (ArrayList) request.getSession(false).getAttribute("recipes");
            LogicController lc = new LogicController();
            Recipe recipe = lc.getSpecificRecipe(recipeName, recipes);
            //out.println(recipe);
        %>
        <div>              
            <%
                out.println(recipe.getRecipeName());
                out.println("<img src=" + recipe.getImgURL() + ">");
            %>               
        </div>
        <div>              
            <%
                out.println("Ingredients:");
                out.println(recipe.getIngredients());
            %>               
        </div>
        <div>              
            <%
                out.println("Instructions:");
                out.println(recipe.getInstructions());
            %>               
        </div>


    </body>
</html>
