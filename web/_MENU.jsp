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
    <c:when test="${cookie.login==null}">
        <a href="login">Connexion</a>
    </c:when>
    <c:otherwise>
        <a href="logout">Déconnexion</a>
        <c:if test="${cookie.util_type.getValue()=='ADMIN'}">
            <a href="film_ajouter">Ajout film</a>
            <a href="serie_ajouter">Ajout série</a>
        </c:if>
    </c:otherwise>
</c:choose>