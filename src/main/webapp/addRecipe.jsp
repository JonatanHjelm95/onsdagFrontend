<%-- 
    Document   : addRecipe
    Created on : Sep 26, 2018, 12:52:45 PM
    Author     : Fen
--%>

<%@page import="logic.CreateRecipeForms"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <script>
            function reloadPageWithParams(value){
                document.write("<br>
                <input type="text" name="ingredients" placeholder="Enter ingredient"/>

                <input type="submit" value="Submit"/>")
            }
            
        </script>

        <h1>Hello World!</h1>
        <div>

            <form action="Control" method="POST">
                <input type="text" name="recipename" placeholder="Enter recipe name"/>
                <input type="text" name="instructions" placeholder="Enter instructions"/>
                <input type="hidden" name="origin" value="createRecipe"/>
                <select name="selectNumberOfIngredients" onchange="location.reload()">
                    <option value="1">1 ingredient</option>
                    <option value="2">2 ingredients</option>
                    <option value="3">3 ingredients</option>
                    <option value="4">4 ingredients</option>
                    <option value="5">5 ingredients</option>
                    <option value="6">6 ingredients</option>
                    <option value="7">7 ingredients</option>
                    <option value="8">8 ingredients</option>
                    <option value="9">9 ingredients</option>

                </select>
                <%
                    CreateRecipeForms crf = new CreateRecipeForms();
                    String number = request.getParameter("selectNumberOfIngredients");
                    out.println(number);
                %>
                <br>
                <input type="text" name="ingredients" placeholder="Enter ingredient"/>

                <input type="submit" value="Submit"/>
            </form>

        </div>
    </body>
</html>
