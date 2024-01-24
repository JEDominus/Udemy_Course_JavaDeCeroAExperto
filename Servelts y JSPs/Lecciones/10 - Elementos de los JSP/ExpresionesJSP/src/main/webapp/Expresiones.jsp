<%-- El objetivo de este jsp, es usar expresiones de forma directa --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Expresiones</title>
    </head>
    <body>
        <h1>JSP con Expresiones</h1>
        <%-- Ahora se agregan las expresiones con valores en este jsp --%>
        Concatenacion: <%= "Saludos " + "JSP" %><br>
        <%-- Para poder ver el servlet, tenemos que ejecutar el jsp primero --%>
        <%= 2 * 3 / 2 %><br> <%-- Esto se va a evaluar y se imprimira en cadena en el jsp--%>
        <%= session.getId() %><br><br><%-- Este es el ejemplod e los objetos cargados automaticamente--%>
        <a href="index.html">Regresar al Inicio</a><br>
    </body>
</html>
