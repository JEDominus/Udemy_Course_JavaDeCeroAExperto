<%-- Por default esta en false, pero ala ctivarlo ya podemos acceder al objecto exception --%>
<%@page isErrorPage="true"%>
<%--Importamos java IO para acceder al print wirter --%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manejo de Errores</title>
    </head>
    <body>
        <h1>Error</h1><br>
        <p>Ocurrio un error: </p>
        <p><%= exception.getMessage() %></p><br> <%-- Este maneja solo el mensaje generico, lo siguiente envia el stack trace --%>
        <textarea col="30" rows="5">
            <pre><%--Con este pre nos respeta el formato que trae y no lo modifica--%>
                <% exception.printStackTrace(new PrintWriter(out)); %>
            </pre>
        </textarea>  
    </body>
</html>
