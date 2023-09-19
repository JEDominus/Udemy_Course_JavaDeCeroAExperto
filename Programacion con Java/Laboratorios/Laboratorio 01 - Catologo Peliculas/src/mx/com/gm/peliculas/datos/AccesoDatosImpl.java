package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosException;
import mx.com.gm.peliculas.excepciones.EscrituraDeDatosException;
import mx.com.gm.peliculas.excepciones.LecturaDeDatosExcepcion;

public class AccesoDatosImpl implements IAccesoDatos {

    public static final String RUTA_DE_ARCHIVO = "C:\\Users\\jedom\\OneDrive\\Documentos\\NetBeansProjects\\Universidad Java\\Java de cero a experto\\Programacion con Java\\Laboratorios\\Laboratorio 01 - Catolog Peliculas (Fix)\\CatalogoPeliculas\\";
    public static final String EXTENCION_DE_ARCHIVO = ".txt";

    @Override//Crea un archivo de texto nuevo
    public void crear(String nombreArchivo) throws AccesoDatosException {//Se recibe el nombre del archivo 
        //Se crea un File con la ruta y la extencion del archivo
        File archivo = new File(RUTA_DE_ARCHIVO + nombreArchivo + EXTENCION_DE_ARCHIVO);

        try {
            PrintWriter writer = new PrintWriter(archivo);//crea el flujo de escritura
            //Sin acciones intermedias, con abrir y cerrar crea el archivo
            writer.close();//Crea el archivo en disco duro
            System.out.println("Catalogo: '" + nombreArchivo + "' creado exitosamente!\n");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            //Se propaga la exceptiond e tipo acceso datos otra vez
            throw new AccesoDatosException("Excepcion al crear catalogo: " + ex.getMessage());
        }
    }

    @Override//Busca si un archivo existe
    public boolean existe(String nombreArchivo) {//Se puede omitir nla firma de la exception si no se lanza
        //crea un archivo con el nombre dado, la ruta y la extencion
        File archivo = new File(RUTA_DE_ARCHIVO + nombreArchivo + EXTENCION_DE_ARCHIVO);
        return archivo.exists();//Retorna el valor de si existe o no
    }

    @Override//Agregar una pelicula a un catalogo
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDeDatosException {
        File archivo = new File(RUTA_DE_ARCHIVO + nombreArchivo + EXTENCION_DE_ARCHIVO);//Se abre el archivo

        try {
            //Se instancia el flujo de archivo junto con la escritura como aprametro
            PrintWriter writer = new PrintWriter(new FileWriter(archivo, anexar));
            writer.println(pelicula.getNombre());//Se hace append con la nueva pelicula
            writer.close();//Se cierra el canal de escritura
            System.out.println("'" + pelicula.getNombre() + "' agregada al Catalogo '" + nombreArchivo + "' exitosamente!\n");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            //Ahora propagamos la exception de tipo Lectura 
            throw new EscrituraDeDatosException("Excepcion al escribir peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            //Se propaga la exceptiond e tipo lectura otra vez
            throw new EscrituraDeDatosException("Excepcion al escribir peliculas: " + ex.getMessage());
        }
    }

    @Override//Lee archivo y crea lista de peliculas
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDeDatosExcepcion {
        List<Pelicula> peliculas = new ArrayList();//Se crea la lista para poder usarla dentro y fuera del bloque tc
        File archivo = new File(RUTA_DE_ARCHIVO + nombreArchivo + EXTENCION_DE_ARCHIVO);

        try {
            FileReader fileReader = new FileReader(archivo);//Se encarga de leer el archivo
            BufferedReader entrada = new BufferedReader(fileReader);//Se encarga de almacenar lineas completas
            String lectura = entrada.readLine();//Almacena el valor de la linae actuial

            while (lectura != null) {//Mientras haya lineas en el archivo que leer 
                Pelicula pelicula = new Pelicula();//crea el objeto
                pelicula.setNombre(lectura);//asignale nombre segun el valor de la linea
                peliculas.add(pelicula);//Agrega la pelicula a la lista

                lectura = entrada.readLine();//Avaanza a la siguiente linea del archivo
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            //Ahora propagamos la exception de tipo Lectura 
            throw new LecturaDeDatosExcepcion("Excepcion al lista peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            //Se propaga la exceptiond e tipo lectura otra vez
            throw new LecturaDeDatosExcepcion("Excepcion al lista peliculas: " + ex.getMessage());
        }

        return peliculas;//Retorna la lista creada
    }

    @Override//Busca una pelicula y retorna la linea donde la encontro
    public String buscar(String nombreArchivo, String nombrePelicula) throws LecturaDeDatosExcepcion {
        String resultado = "No se encontro la pelicula '" + nombrePelicula + "'\n";

        //Crea el flujo del archivo en memoria
        File archivo = new File(RUTA_DE_ARCHIVO + nombreArchivo + EXTENCION_DE_ARCHIVO);

        try {
            FileReader reader = new FileReader(archivo);//Lector de archivo
            BufferedReader entrada = new BufferedReader(reader);//Lector de luneas
            String lectura = entrada.readLine();//Valor de la lectura 

            int index = 1;
            while (lectura != null) {
                if (lectura.equalsIgnoreCase(nombrePelicula)) {
                    resultado = "Pelicula '" + lectura + "' encontrada en la linea: " + index + "\n";
                    break;//Salir del ciclo
                }
                index++;
                lectura = entrada.readLine();
            }

            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            //Ahora propagamos la exception de tipo Lectura 
            throw new LecturaDeDatosExcepcion("Excepcion al buscar pelicula: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            //Se propaga la exceptiond e tipo lectura otra vez
            throw new LecturaDeDatosExcepcion("Excepcion al buscar pelicula: " + ex.getMessage());
        }

        return resultado;
    }

    @Override//Elimina archivo
    public void borrar(String nombreArchivo) { // No se esta lanzando la exception, podemos quitarla de lafirma, aun asi la interfaz la conserva en la firma
        File archivo = new File(RUTA_DE_ARCHIVO + nombreArchivo + EXTENCION_DE_ARCHIVO);

        if (archivo.exists()) {
            archivo.delete();//Se elimina el archivo             
        }
    }

}
