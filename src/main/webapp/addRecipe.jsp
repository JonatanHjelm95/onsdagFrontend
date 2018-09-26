<%-- 
    Document   : addRecipe
    Created on : Sep 26, 2018, 12:52:45 PM
    Author     : Fen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div>

            <form action="Control" method="POST">
                <input type="text" name="recipename" placeholder="Enter recipe name"/>
                <input type="text" name="ingredients" placeholder="Enter ingredients"/>
                <input type="text" name="instructions" placeholder="Enter instructions"/>
                <input type="hidden" name="origin" value="createRecipe"/>
                <input type="submit" value="Submit"/>
            </form>

        </div>
    </body>
</html>
