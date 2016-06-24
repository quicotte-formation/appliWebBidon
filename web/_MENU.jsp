<%-- 
    Document   : _TITRE
    Created on : 17 juin 2016, 10:54:26
    Author     : tom
--%>





<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<a href="films_lister">Films</a>
<a href="serie_lister">Séries</a>
<c:choose>
    <c:when test="${utilConnecte.login==null}">
        <a href="login">Connexion</a>
    </c:when>
    <c:otherwise>
        <a href="logout">Déconnexion</a>
        <c:if test="${utilConnecte.utilType=='ADMIN'}">
            <a href="film_ajouter">Ajout film</a>
            <a href="serie_ajouter">Ajout série</a>
        </c:if>
    </c:otherwise>
</c:choose>
<a href="change_style?style=style1">Style 1</a>
<a href="change_style?style=style2">Style 2</a>