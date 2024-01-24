package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet{
    //Clase que eprmitira descargar un excel al recibir un request
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //1.- seteamos el tipo de respuesta (MIME)
        response.setContentType("application/vnd.ms-excel"); 
        
        //2.- cuando entremos que se descargue el excel
            //Con esto le decimos al navegador que al dar click descargue el excel
            //Apache poi.apache.org para excel profesional
        response.setHeader("Content-Disposition", "attachment;filename=ejemploExcel.xls");
        
        //3.- Indicar al navegador que no guarde cache
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
            //Para que la iunformacion expire de manera inmediata usamos
        response.setDateHeader("Expires", -1);
        
        //4.- Para desplegar la informacion al cliente:
        PrintWriter out = response.getWriter();
            //Ahora el out apunta al documento de excel en lugar de html 
            //Lo que se imprima usando el oput sera hacia el documento excel
                //Cada \t es una celda hacia abjo
        out.println("\t Valores");//Al usat \t es un tabulador, es decir, una celda, al hacer otro tab, se pasa a otra celda
        out.println("\t 1");//Celda 2
        out.println("\t 2");
            //ahora sumamos los valores
        out.println("Total\t=SUMA(b2:b3)");//Funcion excel
    }
}
