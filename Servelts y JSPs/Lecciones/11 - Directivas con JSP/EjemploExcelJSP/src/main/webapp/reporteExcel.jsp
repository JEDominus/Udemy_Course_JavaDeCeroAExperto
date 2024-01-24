<%-- En este caso, este JSP nbo va a responder con contenido html, si no excel--%>
<%@page import="utilerias.Conversion, java.util.Date" %><%--Directiva para importar clases java import --%>
<%-- La segunda directiva es para definir el tipó de respuesta--%>
<%@page contentType="application/vnd.ms-excel"%>
<%--Ahora abrimos un scriptlet para definir el nombre del reporte--%>
<%
    String nombreArchivo = "Reporte Excel.xls";
    //Con esto seteamos el header que define la respuesta 
    response.setHeader("Content-Disposition", "attachment;filename=" + nombreArchivo);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte Excel</title>
    </head>
    <body>
        <h1>Reporte Excel</h1><br>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripcion</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <th>1. Fundamentos de Java</th>
                <th>Aprenderemos la sintaxis basica de Java</th>
                <%--Aqui usamos la clase conversiones dentro de una expresion--%>
                <th><%= Conversion.format(new Date()) %></th>
            </tr>
            <tr>
                <th>2. Programacion con Java</th>
                <th>Pondremos en practica conceptos de la POO</th>
                <%--Aqui usamos la clase conversiones dentro de una expresion--%>
                <th><%= Conversion.format(new Date()) %></th>
            </tr>
        </table>
    </body>
</html>
