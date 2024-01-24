package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletHeaders")
public class ServletHeaders extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Establecemos el tipo de contenido de la respuesta y obtenemos el writter del response para pdoer escribir html
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //Para Obtener los headers, hacemos uso del parametro request
            //1.- Metodo de la peticion
        String metodoHttp = request.getMethod();
            //2.- URI
        String uri = request.getRequestURI();
            //3.- protocolo
        String protocolo = request.getProtocol();
            //4.- Todos los cabeceros disponibles
        Enumeration cabeceros = request.getHeaderNames();
        
        out.print("<html>");
        out.print("<head>");
        out.print("<title>headers Http</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<p>Protocolo : " + protocolo + "</p>");
        out.print("<p>Metodo Http: " + metodoHttp + "</p>");
        out.print("<p>URI: " + uri + "</p>");
        out.print("<hr width='75%'/> <br>");   
        while(cabeceros.hasMoreElements()){
            String nombrecabecero = (String) cabeceros.nextElement();//Retorna el siguiente elemento, regresa tipo object
            out.print("<span><b>" + nombrecabecero + "</b></span>:");
            out.print("<span>" + request.getHeader(nombrecabecero) + "</span>");
            out.print("<br>");  
            
        }
        out.print("</body>");
        out.print("</html>");
    }
}
