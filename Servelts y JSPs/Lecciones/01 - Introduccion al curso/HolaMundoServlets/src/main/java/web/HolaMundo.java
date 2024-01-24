package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

//Al extender de httpServlet, ya es una clase servlet
//Para que el navegador reconozca esta clase, hay que agregar la anotacion y el path
@WebServlet("/HolaMundo")
public class HolaMundo extends HttpServlet {
    //Los 2 paquetes autogenerados en Source Packages los podemos eliminar
    //El IDE permite crear clases de tipo servlet, pero configuraremos el servlet desde una clase java 
    //Los servlets van en el paquete web
    
    //Ahora hay que indicar que metodo va aprocesar este servlet
        //al hacer la llamada desde el navegador, se hace una peticion web mediante un link del navegador
        //los formuklarios usan peticion POST
    //Para hacer una llamda al servlet desde el navegador, debe seer una peticion de tipo get
        //El metodo de la clase padre recibe estos 2 argumentos
    @Override//Metodo de la clase servlet doGet
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Ahora, glassfish hace la llamada a este metodo al dar con la ruta de este servlet
        //Ahora podemos implementar algo 
            //Los servlets pueden responder con html, pero lo usal es usar jsp
        
        //Establecemos el tipo de contenido a responder, podria ser json
        response.setContentType("text/html;charset=UTF-8");
        
        //Traemos el objeto response el Writter
            //Ahora con out es como pintar en consola, sin embargo, en lugar de consola, sera en la web
        PrintWriter out = response.getWriter();//Firmamos la exception en luagr del trycatch
        
        //ahora solo imprimimos una linea en el objeto out
        out.println("Hola mundo desde servlets");//Aqui se inserta el html, de momento, solo un string        
        
        //Al hacer clean an build, se genera el archivo war
        //Una rchivo war es donde se empaquetan nuestros proyectos web (Web Archive File)
            //La informacion web creada en el war la podemos ver en webpages y  webInf junto con archivos xml
        //Los archivos bean.xml y web.xml de momento no se usan y se pueden eliminar, pero vamos a modificar el web.xml
        
        //en el web.xml se definen caracteristicas de los apis de servelets y jsp
            //La anotaciond e esdta clase, configura el servlet directamente en lugar de en el web.xml
            
        //Ver a index.html para continuar con la configuracion
    }
}
