<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"  %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRUEBA CRUD DE TABLA PERSONA</title>
    </head>
    <body>
        <table border="2" align="center">
            <tr>
                <td>
                    <spring:nestedPath path="afe">
                        <form id="frmInicial" action="" method="post">
                            <table>
                                <tr>
                                    <td>Id</td>
                                    <td>
                                        <spring:bind path="id">
                                            <input type="text" id="${status.expression}" name="${status.expression}" value="${status.value}" >
                                        </spring:bind>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2"><input type="submit" name="Buscar" value="Buscar">
                                    <input type="submit" name="Eliminar" value="Eliminar">
                                    <input type="submit" name="Modificar" value="Modificar">
                                    <input type="submit" name="Listar" value="Listar"></td>
                                </tr>
                                <tr>
                                    <td>Clave</td>
                                    <td>
                                        <spring:bind path="Clave">
                                            <input type="text" id="${status.expression}" name="${status.expression}" value="${status.value}" >
                                        </spring:bind>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Nombre</td>
                                    <td>
                                        <spring:bind path="Nombre">
                                            <input type="text" id="${status.expression}" name="${status.expression}" value="${status.value}">
                                        </spring:bind>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Tipo</td>
                                    <td>
                                        <spring:bind path="Tipo">
                                            <input type="text" id="${status.expression}" name="${status.expression}" value="${status.value}">
                                        </spring:bind>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><input type="submit" name="Insertar" value="Insertar">
                                        <input type="reset" name="Limpiar" value="Limpiar"></td>
                                </tr>
                            </table>
                        </form>
                    </spring:nestedPath>
                </td>
            </tr>
        </table>
    </body>
</html>
