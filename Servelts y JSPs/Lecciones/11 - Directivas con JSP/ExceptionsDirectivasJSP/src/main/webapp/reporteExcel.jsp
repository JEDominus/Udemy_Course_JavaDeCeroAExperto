<%--Declaramos con la directiva page el JSP... para esto recomienda ue sea un jsp privado y meterlo enWEBINF para que nadie pueda acceder--%>
<%@page errorPage="/WEB-INF/manejoError.jsp"%><%-- Con esta directiva ya seteamos quien va a manejar los errores --%>
<%@page import="utilerias.Conversion, java.util.Date" %>
<%@page contentType="application/vnd.ms-excel"%>
<%
    String nombreArchivo = "Reporte Excel.xls";
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
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
                <th><%= Conversion.format(new Date()) %></th>
            </tr>
            <tr>
                <th>2. Programacion con Java</th>
                <th>Pondremos en practica conceptos de la POO</th>
                <th><%= Conversion.format(new Date()) %></th>
            </tr>
            <tr> <%--Ahora vamos a hacer tronar el metodo pero antes hay que sobrecargar el metodo formart en la clase Java --%>
                <th>2. Programacion con Java</th>
                <th>Pondremos en practica conceptos de la POO</th>
                <%--Para manejar esta exception y poder recuperarnos, hay que agregar un JSP para manejarlo--%>
                <th><%= Conversion.format("500") %></th>
            </tr>
        </table>
    </body>
</html>
