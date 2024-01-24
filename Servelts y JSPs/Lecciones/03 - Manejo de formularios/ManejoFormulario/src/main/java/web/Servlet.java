package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    //Para esta leccion se ha creado una rchivo JS y CSS en la carpeta recursos a la altura de webapp
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //indicamos el contentype de la respuesta
        response.setContentType("text/html;charset=UTF-8");
        //ahora nos traemos el print writter del response para pdoer escribir en la respuesta
        PrintWriter out = response.getWriter();
        
        //Capturamos los valores del formulario desde el request
        String usernmae = request.getParameter("iUsuario");
        String password = request.getParameter("iPassword");
        
        //Las tecnologias se recuperar en un arreglo, usamos getParameterValues para varios elementos
        String tecnologies[] = request.getParameterValues("iTecnologia");
        String gender = request.getParameter("iGenero");
        String ocupation = request.getParameter("iOcupacion");
        String music[] = request.getParameterValues("iMusica");
        String comments = request.getParameter("iComentarios");  
        
        //Ahora ya tenemos la informacion del formulario del lado del servidor de java
        
        //Ahora toca responder al cliente de vuelta
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Respuesta</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Parametros procesados por el servlet</h1>");
        out.print("<table border='1'>");
        
        out.print("<tr>");
        out.print("<td>Usuario</td>");
        out.print("<td>");
        out.print(usernmae);
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>Password</td>");
        out.print("<td>");
        out.print(password);
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>Tecnologias</td>");
        out.print("<td>");
        for(String tec: tecnologies){
            out.print(tec);
            out.print(" / ");
        }
        out.print("</td>");              
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>Genero</td>");
        out.print("<td>");
        out.print(gender);
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>Ocupacion</td>");
        out.print("<td>");
        out.print(ocupation);
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>Musica</td>");
        out.print("<td>");
        if(music != null){
            for(String mus: music){
                out.print(mus);
                out.print(" / ");
            }
        }else{
            out.print("Valor no proporcionado");
        }
        out.print("</td>");              
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>Comentarios</td>");
        out.print("<td>");
        out.print(comments);
        out.print("</td>");
        out.print("</tr>");
        
        out.print("</table");
        out.print("</body>");
        out.print("</html>");
    }
}
