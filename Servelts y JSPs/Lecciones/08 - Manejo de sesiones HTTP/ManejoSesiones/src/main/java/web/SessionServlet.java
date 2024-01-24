package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        //Obtenemos la sesion actual asociada con esta peticion
            //Si no se tiene una sesion, se va a crear otra
        HttpSession sesion = request.getSession();
        
        //Ahora podemos agregar y recuperar informacion de la sesion
        String titulo = null;
        
        //Ahora pedimos un atributo a la sesion
            //Este puede regresar nulo y, los nulos no se aplican a primitivos, por ello es que se usa INTEGER
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        
        //Ahora preguntamos si es nulo para saber si es la primera vez que accedemos a la aplicacion
        if(contadorVisitas == null){
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        } else {
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }
        
        //Hay que agregar el contador a la session para la siguiente lectura 
            //Esto agrega o modifica el atributo que ya se tiene
            //Los valores de una sesion se almacena como mapa, nombre valor
            //Los mapas, agregan o sobreescribenm segun si existe o no
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        
        //Ahora mandamos la repsuesta al cliente
        PrintWriter out = response.getWriter();
        out.print(titulo + "<br>");
        out.print("Numnero de accessos: " + contadorVisitas + "<br>");
        out.print("ID de la session: " + sesion.getId());//Este valor lo asigna automaticamente el servidor glassfish
        out.close();
        
        //Internamente Glassfish (servidor de aplicacion) va a utilizar 2 formas para manejar las sesiones
        //1.- Agregar el sessionID en la URL (URL rewriting)... SOlo se usa cuando se prohibe el uso de cookies
        //2.- Manejarlo como coockie (default)
        
        //En WEb Pages/WEB-INF/web.xml podemos ver el tiempo de expiracion de la session
    }
}
