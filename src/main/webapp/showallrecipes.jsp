<%-- 
    Document   : showallrecipes
    Created on : 25-09-2018, 10:21:52
    Author     : porse
--%>

<%@page import="logic.CollectionToHTML"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="data.Recipe"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet"
              type = "text/css"
              href = "ShowAllRecipesStyle.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Recipes</h1>
        <ul>
            <%
                ArrayList<Recipe> recipes = (ArrayList) request.getSession(false).getAttribute("recipes");
                // Collections.sort(recipes, Comparator.comparing(Recipe::getRecipeName));
                for (Recipe recipe : recipes) {
                    out.println("<li><a href=\"?origin=showRecipe&recipe_id=" + recipe.getRecipeName() + "\">" + recipe.getRecipeName() + "</a></li>");
                }
            %>
        </ul>

        <div id ="recipesTable">
            <%
                CollectionToHTML cthtml = new CollectionToHTML();
                String columns = cthtml.generateHTMLString(recipes);
                out.println(columns);
            %>
        </div>
    </body>
</html>
