<%-- 
    Document   : listado
    Created on : 06/12/2010, 01:09:42 PM
    Author     : Martin
<%@page contentType="text/html" pageEncoding="UTF-8"%>
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de todas las Personas</title>
    </head>
    <body>
        <table align="center" cellspacing="10">
            <th>Id</th><th>Nombre</th><th>Clave</th><th>Tipo</th>
        <c:forEach items="${listado}" var="persona" >
            <tr>
                <td>${persona.id}</td>
                <td>${persona.nombre}</td>
                <td>${persona.clave}</td>
                <td>${persona.tipo}</td>
            </tr>
        </c:forEach>
        </table>
        <center><a href="index.htm">VOLVER</a></center>
    </body>
</html>
