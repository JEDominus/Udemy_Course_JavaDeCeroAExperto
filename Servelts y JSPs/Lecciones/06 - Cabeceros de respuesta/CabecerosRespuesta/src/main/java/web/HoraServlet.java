package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/HoraServlet")
public class HoraServlet extends HttpServlet{
    //Va a retornar hrml pero actualizara la hora pagina cada segundo 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //1.- seteamos el tipo de respuesta (MIME)
        response.setContentType("text/html");
        
        //2.- agregamos cabecero de refrescado
        response.setHeader("refresh", "1");
        
        //3.- implementamos la fecha a imprimir
        Date fecha = new Date();
        
        //4.- Formato de la fecha - Tiene opciones para formatear fecha
        SimpleDateFormat formateador = new SimpleDateFormat("'Hora actualizada:' HH:mm:ss");
        
            //Este ya contiene la fecha formateada
        String horaFormateada = formateador.format(fecha);
        
        //5.- Nos traemos el print wirtte
        PrintWriter out = response.getWriter();
        out.print(horaFormateada);//Aqui va el html pero nomas se hara la hora 
    }
}
