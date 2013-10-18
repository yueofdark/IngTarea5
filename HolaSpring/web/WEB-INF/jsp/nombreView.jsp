<%-- 
    Document   : nombreView
    Created on : 17/10/2013, 09:08:44 AM
    Author     : roso
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Escribe tu nombre</title>
    </head>
    <body>
        <h1>Escribe tu nombre</h1>
    <spring:nestedPath path="nombre1">
        <form action="" method="post">
            Nombre:
            <spring:bind path="usuario">
                <input type="text" name="${status.expression}" value="${status.value}">
            </spring:bind>
            Clave:
             <spring:bind path="clave">
                <input type="text" name="${status.expression}" value="${status.value}">
             </spring:bind>    
            <input type="submit" value="OK ">
        </form>
    </spring:nestedPath>    
     
    </body>
</html>
