<%--
Para esta leccion, se limino el index.html y se reemplazo por este index.jsp
Las librerias que suaremos para trabajar con jsp se encuentran en la dependencia javaee-api en el pom
Los comentarios en jsp varia, ahora se utiliza % en lugar de !
Las etiquetas de jsp se usan utilizando %, como en %@page
--%>

<%-- Cuarta impresion de lista, asi se importa una libreria 
    El uri marca donde se buscara la libreria, que puede ser la dependencia en el proyecto
    El prefijo ayuda a referenciar el uso de la libreria en el codigo
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 
La siguiente es una directiva que define el tipo de contenido del archivo 
La directiva page (entre otras) contienen sus propios atributos
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%-- Se peude remover este meta ya que se ha definido en la directiva <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> --%>
        <title>Hola Mundo JSP</title>
    </head>
    <body>
        <h1>Hola Mundo JSP</h1>
        <ul>
            <%-- Scriptlets ...% scriptlet, %! declara variables, %-- comentario, %= Expresion sirve como print writter --%>
            <%-- Dentro del scriptlet se puede agregar codigo java y ya incluye algunas funciones como el print witter --%>
            <li><% out.print("Hola Mundo con Scriptlets");%></li>
            <%--
            Este JSP es un componente del lado del servidor, no es un simple html
            Este JSP se traduce como un servlet y por ello podemos escribir codigo java
            Para este Servlet, se aplica el ciclo de vida del servlet, puede hacer hasta llamadas a una base de datos 
            --%>
            
            <%-- Expresion language--%>
            <li>${"Hola Mundo con Expresion Language (EL)"}</li>
            
            <%-- Esta expresion, despues del = ya aplica como si usaramos la variable out, por lo que se imprimira--%>
            <li><%="Hola Mundo con expresiones %="%></li>
            
            <%-- JSTL, hay que definir la libreria en la parte alta del JSP--%>
            <li><c:out value="Hola Mundo con JSP Startdard Tag Library (JSTL)" /></li>
        </ul>

    </body>
</html>

<%-- Para ver el servlet generado por este jsp podemos dar click derecho en el jsp y en evr servlet --%>
