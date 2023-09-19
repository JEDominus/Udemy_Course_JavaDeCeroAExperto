package manejoarchivos;

import java.io.*;//Input Ouput... paquete de entrada salida de Java

/*Operaciones basicas
    Crear archivo
    Agregar informacion al archivo
    Eliminar informacion del archivo
    Eliminar el archivo
*/

public class ManejoArchivos {
    public static void crearArchivo(String nombreDeArchivo){//Va a crear el archivo en el disco duro
        //La clase File gestiona el manejo de archivos
            //Lo siguiente solo instancia el objeto, no crea el archivo
        File archivo = new File(nombreDeArchivo);//Con esto se crea el objeto file en memoria
        
        //Para que se guarde el archivo debemos usar la clase PrintWirter.. Tambien es de java io
            //El constructor puede lanzar una "Exception" asi que debe ser firmada o cachada... la vamos a cachare
        try {
            //Se envuelve la linea ya que podria lanzar la excetion
            
            //Esto solo abre el objeto File en memoria, aun no lo guarda
                //Por eso requiere el nombre, para encontrarlo
            PrintWriter salida = new PrintWriter(archivo);//Recibe el "File" creado anteriormente para abrirlo
            //Lo anterior abre el flujo de la referencia dada, para que se guarde hay que cerrar el flujo
            salida.close();//Al cerrar el flujo, ya se crea el archivo en disco duro
            //Se guarda en la ruta de esta carpeta, por lo que se ve en el proyecto
            System.out.println("Se ha creado el archivo: " + nombreDeArchivo);
        } catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);//Pintamos el stack tarce en consola
        }
        
    }
    
    public static void escribirArchivo(String nombreArchivo, String contenido){
        //De forma similar a la creacion, hay que abrir el archivo en memoria
            //Si no existe, lo creara
        File archivo = new File(nombreArchivo);
        
        try{
            //Abrimos el flujo del objeto (archivo) en memoria 
            PrintWriter salida = new PrintWriter(archivo);
            //antes de cerrar hay que escribir la informacion
                //Para ello se usa el println de la salida
                //es un metodo sobrecargado, por lo que se le pueden pasar multiples valores
            salida.println(contenido);
            salida.close();//Si no existe lo crea... si tiene contenido, lo sobreescribe, se pierde lo anterior
            System.out.println("Se ha escrito en el archivo");
        }catch(FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
    }
    
    public static void anexarInformacion(String nombreArchivo, String contenido){
        //mismo proceso de creacion de file, apertura de flujo...
        File archivo = new File(nombreArchivo);
        
        try{
            //Ahora en lugar de escribir directamente en PrinWritter, hay que crear un FileWritter
            FileWriter fileWritter = new FileWriter(archivo, true);//Pasamos el archivo y si va a hacer append o no (concatenar)
            //La salida ademas de el archivo, tambien puede recibir el fileWritter
            PrintWriter salida = new PrintWriter(fileWritter);//... = new PrintWriter(new FileWriter(archivo, true));
            salida.println(contenido);//Despues agregamos el contenido
            salida.close(); 
            System.out.println("Concatenacion exitosa");
        }catch(FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }catch(IOException ex){
            ex.printStackTrace(System.out);            
        }
        
    }
    
    public static void leerArchivo(String nombreArchivo){
        //Requiere la referencia de File en memoria
        File archivo = new File(nombreArchivo);
        
        try{
            //asi como PrintWritter escribe usar FileWritter para escribir...
                //BufferedReader usa FileReader para leer
            //File reader no lee lineas completas, pero Buffer reader si
            FileReader fileReader = new FileReader(archivo); //Este solo recive el nombre del archivo
            BufferedReader entrada = new BufferedReader(fileReader);//... = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();//Este lee solo la primer linea
            
            //Para leer las lineas completas podemos usar un while()
            while(lectura != null){//mientras la linea actual no sea null... lee
                //Imprimimos la linea leida actual
                System.out.println("lectura = " + lectura);//imprimimos el valor actual de la linea (lectura)
                lectura = entrada.readLine();//Salta a leer la siguiente linea
                //En el momento que la siguiente linea sea null, sale del cicflo
                //Hay que reasignar valor ya que si no es un loop infinito
            }   
            
            //Al igual que hay que cerrar el PrinWritter, hay que cerrar el BufferedReader
            entrada.close();//esto se puede abrir fuera del try y cerrar en el final
        }catch(FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }catch(IOException ex){
            ex.printStackTrace(System.out);
        }
    }
}
