<%-- Este jsp vbaa recuperar el valor de iFondo del formulario y aplicarlo al fondo --%>
<!DOCTYPE html>
<%-- Para ello se require el siguiente scriptlet --%>
<%
    String fondo = request.getParameter("iColor");
    if(fondo == null || fondo.trim().equals("")){
     fondo = "white";
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Cambio Color</title>
    </head>
    <%-- Ahora seteamos el valor de ese colo rne el bg del body con otro scriptlet--%>
    <body bgcolor="<%=fondo%>">
        <h1>Hello World!</h1>
        <p>Color aplicado: <%=fondo%></p>
        <a href="index.html">Link para regresar al inicio</a>
    </body>
</html>
