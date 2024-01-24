package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletCodigos")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Simular valores corrector del formulario en codigo duro
        String usuarioOk = "Javier";
        String passwordOk = "123";
        
        //Recibimos los valores del formulario
        String usuario = request.getParameter("iUsuario");
        String password = request.getParameter("iPassword");
        
        //Validamos que sean iguales a los valores admitidos
        if(usuarioOk.equals(usuario) && passwordOk.equals(password)){
            PrintWriter out = response.getWriter();
            out.print("<h1>Datos correctos</h1>");
            out.print("<br>Usuario: " + usuario);
            out.print("<br>Password: " + password);
        } else {
            //Usando el response, mandamos el error con la enumeracion de tipo no autorizado (401)
            response.sendError(response.SC_UNAUTHORIZED, "Las credenciales son incorrectas");
        }
    }
}
