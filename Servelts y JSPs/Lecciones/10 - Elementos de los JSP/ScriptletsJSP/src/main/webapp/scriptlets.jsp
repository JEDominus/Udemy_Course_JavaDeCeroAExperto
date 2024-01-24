<%-- Esta pagina va a enviar informacion directamente al navegador cons criptlets --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriptlets</title>
    </head>
    <body>
        <h1>JSP con scriptlets</h1>
        <%-- Los copmentarios de jsp a diferencia de los de html, es que no se muesdtran en el navegador --%>
    </body>
    <%-- Asi se abre y cierra un scriptlet, procesa codigo java puro --%>
    <%-- 1.- Manda informacion directa al navegador --%>
    <%
        out.println("Saludos desde un scriptlet");
    %>
    <%-- 2.- Manejo de objetos implicitos --%>
    <%
        String nombreAplicacion = request.getContextPath();
        out.println("Nombre de la aplicacion" + nombreAplicacion);
    %>
    <%-- 3.- Scriptlet condicionado usando java --%>
        <%-- Notese que se puede dejar la secuencia de llaves incompleto par ainsertar texto, mas no es buena practica --%>
    <%
        if(session != null && session.isNew()){
    %>
    La sesion SI es nueva
    <%
        } else if(session != null) {
    %>
    La sesion NO es nueva
    <%
        }
    %>
    <br>
    <a href="index.html">Link para regresar al inicio</a>
</html>
