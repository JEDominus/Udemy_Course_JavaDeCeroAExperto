package test;

import java.sql.*;

public class TestMySQLJDBC {
    /* Introducciona  JDB
        - JDBC - Java Database Connectivity
        - Maven - Tecnologia que ayuda a gestionar las dependencias o librerias de una aplicacion

        - Este proyecto ha sido creado con Maven
        - La primera vez que se rcea un projecto Maven se descargan librerias
            - Tal vez hay que desactivar un firewall o antivirus

        - click derecho en projecto - Clean and Build - Descarga als dependencias que se necesitan para el proyecto
            - Al final vemos que crea un archivo "..../IntroduccionJDBC-1.0.jar"
            - Esto es el empaquetamiento de nuestro proyecto
            - Un jar es el archivo que se puede distribuir en diferentes equipos
            - Esto hace que el proyecto se construya y empaquete

        - Ahora tenemos que agregar la dependencia/libreria de JDBC
            - Hay que ir al project Filespom.xml, que es ela rchivo de administracion de maven
            - Ahi es donde se configura el proyecto y se agregan librerias
        - El archivo ya contiene configuacion de lo que seteamos al crear el proyecto
            - Incluye la version del JDK
        - El archivo se compone por etiquetas que abren y cierran

        - Hay que abrir la etiqueta de "dependencies"
    */
    public static void main(String[] args) {
        cadcenaDeConexxion();
    }
    
    public static void cadcenaDeConexxion(){
        //Se trabajara con la libreria de JDB con el connectore de mySQL... Las clases estan en al dependencia
        
        //1.- Escribir cadena de conexion de la Base de Datos
            //cada tecnologia tiene su version
                //Se colocal el protocolo asi como http, en este caso es mysql
            //podemos agregar parametros con ?... se requieren para poder configurar la conexion
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&iseTomezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        System.out.println("MySQL URL definida: " + url);
        
        //2.- Se
        try {
            //esta linea en apps web puede ser requerida pero ya no se usa tanto actualmente
                //en configuracion local no es requerida
                //Arroja ClassNotFoundException
            Class.forName("com.mysql.cj.jdbc.Driver");       
            System.out.println("Clase driver encontrada en libreria");
            
            //3.- Usando la clase DriverManager de la dependencia de mySQl, creamos la conexion con la url y las credenciales
                //puede arrojar SQL Exception
            Connection conexion = DriverManager.getConnection(url, "root", "admin");
            System.out.println("Conectando con la base de datos");
            
            //4.- Ahora definimos el objeto statemente, que permite realizar sentencias sobre la abse de datos
                //statement es una interfaz, pero el create retorna una implementacion de mySQL
                //creteStatement() tambien puede ser suado por otras abses de datos, segun la que estemos usando
            Statement instruccion = conexion.createStatement();
            System.out.println("Objeto de instrucciones creado");
            
            //5.- Creamos una instruccion
            String sql = "SELECT * FROM persona";//Query sin ;
            System.out.println("Sentencia sql creada");
            
            //6.- Ahora podemos ejecutar la query llamando a executeQuery
                //El tipo de dato retornado es un ResultSet
            ResultSet resultado = instruccion.executeQuery(sql);
            System.out.println("Ejecutando: " + sql);
            
            //7.- Procesamos el resultado o los resultados
                //Como puede retornan mucho resultados, se requiere iterar el resultado
                    //el metodo next basicamente valida si aun tenemos elementos por iterar
            System.out.println("Resultados obtenidos de la Base de datos: ");
            while(resultado.next()){//Retorna un boolean y ademas se posiciona en el registro a iterar
                //Mandamos a imprimir el registro a consola 
                    //El get debe ser del tipo de dato de la columna que vamos a regresar, en este caso, el id es int
                    //Se puede recuperar por indice de columna o por nombre de columna
                        //Estos indices comienzan con 1... Sin embargo se recomienda usar el nombre por si cambia el orde
                StringBuilder sb = new StringBuilder()
                        .append("ID: ").append(resultado.getInt("id_persona"))
                        .append(" Nombre: ").append(resultado.getString("nombre"))//omitiremos apellido por ahora
                        .append(" Email: ").append(resultado.getString("email"))
                        .append(" Telefono: ").append(resultado.getString("telefono"));
                System.out.println(sb.toString());
            }
            
            //8.- Es importante cerrar todo loque abrio en orden deñl ultimo al primero
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (SQLException e){
            e.printStackTrace(System.out);
        } 
        
    }
}
