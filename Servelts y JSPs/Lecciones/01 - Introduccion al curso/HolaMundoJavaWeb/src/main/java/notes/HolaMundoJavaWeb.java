package notes;

public class HolaMundoJavaWeb {
    /* Hola Mundo Java Web
        - File - New Project - Maven Project - Web Application - Configuramos - Glassfish y Java EE 8
        - Por default tenemos un index.html en WebPages
            - Damos click derecho sobre el proyecto y Run
                - No requiere un psvm para ser ejecutado
        - Debe mostrar el hola Mundod e nuestro index
    
        - En el pom podemos ver la dependencia de javaee api y la version de jakarta 8
    */
    
    /*Introduccion a WWW (World Wide Web)
        - Un sitio web contiene informacion estatica que deben ser cambiados manualmente
        - Una aplicacion web, puede recuperar informacion dinamica
            - Puede procesar una peticion de un cliente, la procesa uns ervidor web y regresa la respuesta al cliente

    Arquitectura de una aplicacion web con Java
        - Capa de cliente
            - HTML, CSS y Javascript
            - El navegador se encarga de hacer las peticiones al servisdor y mostrar la inormacion al cliente
        - Capa web (HTTP)
            - JSP's y servlets
        - Capa de negocio
            - Objetos del dominio del negocio
            - Seguridad y transaccionalidad
        - Capa de datos
            - Objetos de tipo entidad, acceso a data storage

    
    Proceso de una peticion http
        1.- Cliente hace un http request (solicitud de transferencia de hipertec)
            - El prtocolo http permite la conexion entre cliente-servidor
        2.- El servidor web (applicaion web) recibe la informacion y manda una respuesta

    Glassfish 5.0 (servidor)
        - Descargamos el Java EE 8 - Glassfish 5.0 full Platform
        - Creamos AppServers en C: y extraemos el contenido
        - Ahora hay que asociar este servidor de aplicaciones copn apache Netbeans 
            - Nos posicionamos una antes de bean y copiamos la ruta
            - En apache netbeans vamos a tab Servicios - Servers - CliclD - Add Server - GlassFish Server - Next
            - Debemos tener activado Java Web y EE... Damos click y se descargara 
            - Dejamos los valores de localhost y los puertos por defaul y anotamos los puertos
                - DAS port es para la consola de administracion, el http para el acceso a la aplicacion
        - Ahora tendremos que descargar el JDK 8 para poder correr el server de glassfish 
            - Descargamos e instalamos, tra el JRE
            - Ahora manage jdk ya gregamos el JDK8
        - Ya podemos levantar el servidor de glassfish
            - Damos click derecho y vamos a view domain admin console para ver la consola de admoinistracion
            - Tambien podemos entrar via localhost:4848... Ahi podremos administrar el servidor
            - Con localhost:8080 podremos acceder a pagina de welcome de glassfish
            - Con esto ya se tiene glasfish configurado a apache netbeans    
    */
}
