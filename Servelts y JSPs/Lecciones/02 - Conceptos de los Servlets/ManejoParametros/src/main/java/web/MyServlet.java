package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/MyServlet")//Nombre del componente que se referencia en el html
public class MyServlet extends HttpServlet {
    
    //ahora especificamos el metodo a procesar
    @Override//Sovbreescribimos el metodo protected de la clase heredada
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //En el request podemos leer los parametros que se establecieron en el formulario
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        //Imprimimos los valores en la consola del servidor
        System.out.println("usuario = " + usuario);
        System.out.println("password = " + password);
        //Para responder al cliente, vamos a abrir un print Writter
        PrintWriter out  = response.getWriter();//agregamos la firma del throws 
        //POdemos pintar html
        out.print("<html><body><p>Usuario: " + usuario + "</p><p>Usuario: " + password + "</p></body></html>");
    }
}
