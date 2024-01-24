package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ContadorServlet")
public class ContadorServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //1.- Indicar el numero de veces que se ha visitado el sitio
        Integer contador = 0;
        
        //2.- Traemos el numero de veces que se ha entrado
        Cookie[] cookies = request.getCookies();
        
        //3.- Revisamos por la existencia de la cookie
        if(cookies != null){
            for(Cookie c: cookies){
                if(c.getName().equals("contadorVisitas")){
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }
        
        //4.- Incrementamos y agregamos el contador a la respuesta
        Cookie c = new Cookie("contadorVisitas", String.valueOf(++contador));
        
        //5.- La cookie expirara en 1 hora
        c.setMaxAge(3600);
        
        //6.- Agregamos las cookie
        response.addCookie(c);
        
        //7.- Ahora imprimimos el numero de visitas
            //Hay que traer el writter
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Veces que has visitado el sitio: " + contador);
        out.close();
    }
}
