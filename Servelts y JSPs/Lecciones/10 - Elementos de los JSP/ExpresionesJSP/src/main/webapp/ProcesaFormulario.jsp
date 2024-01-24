<%-- El objetivo de este jsp, recuperar informacion del formulario en index y procesarla --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesa Formulario</title>
    </head>
    <body>
        <h1>Resultado de procesar el formulario</h1>
        <%-- Usamos el objeto request cargado automaticamente apra acceder a los elementos del formulario como en el servlet --%>
        Usuario: <%= request.getParameter("iUsuario") %><br>
        Password: <%= request.getParameter("iPassword") %><br><br>
        <a href="index.html">Regresar al Inicio</a><br>
    </body>
</html>
