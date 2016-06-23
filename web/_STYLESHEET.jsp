<%-- 
    Document   : _STYLESHEET
    Created on : 17 juin 2016, 10:51:03
    Author     : tom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:choose>
    <c:when test="${cookie.style_prefere=='blanc'}">
        <link href="CSS/style1.css" rel="stylesheet" type="text/css"/>
    </c:when>
    <c:otherwise>
        <link href="CSS/style2.css" rel="stylesheet" type="text/css"/>
    </c:otherwise>
</c:choose>