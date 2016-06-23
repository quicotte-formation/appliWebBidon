<%-- 
    Document   : form
    Created on : 17 juin 2016, 09:37:40
    Author     : tom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulaire</h1>
        <form method="post">
            Titre: <input type="text" name="titre"/>
            <br>
            Année prod: <input type="text" name="anneeProd"/>
            <br>
            Genre:
            <select name="genre">
                <option>Animé</option>
                <option>Horreur</option>
                <option>SF</option>
            </select>
            <br>
            Pays:
            <select name="pays">
                <option>FR</option>
                <option>UK</option>
                <option>USA</option>
            </select>
            <br>
            <input type="submit"/>
        </form>
    </body>
</html>
