package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CookiesServlet")
public class CookieServlet extends HttpServlet {
    //Vamos a monitorear si un usuario ya ha hecho peticiones a nuestro servidor
        //Si e susuario nuevo se da bienvenida, si no, tro mensaje
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException        {
        //1.- Creamos una variable llamada nuevo usuario
        boolean nuevoUsuario = true;//Suponemos que es la primera vez
        
        //2.- obtenemos el arreglo de cookies
        Cookie cookies[] = request.getCookies();
        
        //3.- Buscamos si ya existe una cookie creada con anterioridad
        if(cookies != null){
            for(Cookie c: cookies){
                if("VisitanteRecurrente".equals(c.getName()) && "si".equals(c.getValue())){
                    //3.1.- El visitante no es nuevo
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        
        //4.- Ahora revisamos si el usuario es nuevo y definimos mensaje
        String mensaje = "";
        if(nuevoUsuario){
            //Agregamos la cookie en la respuesta para que no sea nuevo usuario la proxima vez
            Cookie visitanteCookie = new Cookie("VisitanteRecurrente","si");
            response.addCookie(visitanteCookie);
            mensaje = "Bienvenido a nuestro sitio";
        } else {
            mensaje = "Gracias por volver";                
        }

        //5.- Seteamos el tipo mime a repsonder y traemos el writter
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //6.- mandamos el mensaje como respuestay cerramos el writer
        out.print(mensaje);
        out.close();
    }
}
