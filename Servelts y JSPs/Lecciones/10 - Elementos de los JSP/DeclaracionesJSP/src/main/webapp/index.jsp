<%-- 1.- Agregamos una declaraciond e JSP --%>
<%-- Se puede declara un atributo o un metodo, una vez compilado, formara parte de la clase del servlet generado --%>
<%-- Todo lo que vaya dentro estara dentro de la clase de java, asi que agregaremos el get --%>
<%! 
    //Definimos el get 
    private String usuario = "Javier";
    private int visitas = 0;

    public String getUsuario(){return this.usuario;}
%>
<%-- Los scriptlets declaran variables que van dentro del metodo jspService del servlet, las declaraciones son a nivel clase --%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Declaraciones JSP</title>
    </head>
    <body>
        <h1>Declaraciones JSP!</h1>
        Valor de usuario por medio del atributo <%= this.usuario %> <br>
        Valor de usuario por medio del metodo <%= this.getUsuario() %> <br>
        Valor contador visitas <%= ++this.visitas%>
        
    </body>
</html>
