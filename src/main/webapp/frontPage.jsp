<%-- 
    Document   : newjsp
    Created on : Sep 25, 2018, 7:41:07 PM
    Author     : Fen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Front Page</title>
    </head>
    <body>
        <h1>This is the front page</h1>
        <div>
            <%
                out.println("<li><a href=\"?origin=getRecipes\">" + "See all recipes" + "</a></li>");
            %>
        </div>
    </body>
</html>
