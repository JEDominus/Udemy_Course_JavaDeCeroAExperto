package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Seteamos el tipo de respuesta
        response.setContentType("text/html;charset=UTF-8");

        //Nos traemos la sesion del cliente
        HttpSession sesion = request.getSession();
        
        //Recuperamos la lista de articulos si es que existe
            //GetAyttribute para sesiones, getParameter para request
            //Retorna un objeto de tipo lista si es que almacena mas de un valor
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");
        
        //Preguntamos por la existencia
        if(articulos == null){//Si no existe, la creamos y agregamos a la sesion
            articulos = new ArrayList();
            sesion.setAttribute("articulos", articulos);            
        }
        
        //Nos traemos el parametro que se ha enviado del formulario
        String articulo = request.getParameter("iArticulo");
        
        //Revisamos y agregamos articulo nuevo 
            //trim quita espacios vacios al inicio y final de la cadena
            //Si el articulo existe y sin espacios al inicio y final, no es igual a blank... Lo agregamos a la lista
        if(articulo != null && !articulo.trim().equals("")){
            articulos.add(articulo);
            //Ya no es necesario agregar la lista a la session porque como hace referencia un objeto en la sesion
            //Los cambios que se hagan en el objeto de la session se cvana  ver reflejados automaticamente
        }
        
        try ( //Por ultimo, imprimimos la lista de articulos
            PrintWriter out = response.getWriter()) {
            out.print("<h1>Lista del super</h1>");
            
            articulos.forEach(element -> {
                out.print("<li>"+element+"</li>");
            });
            
            //Regresamos al indice
            out.print("<a href='/SesionesCarritoCompras'>Regresar al inicio</a>");
            
            //Al converti s un try-with-resources, nos agrega el bloque try
            //Al final el bloque try, automaticamente se llama a close(), por eso se elimino la linea
        }
    }
}
