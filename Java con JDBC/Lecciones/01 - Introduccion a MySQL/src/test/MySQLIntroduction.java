package test;

public class MySQLIntroduction {
    public static void main(String[] args) {
        /* Instalacion:
            1.- Acceder a https://dev.mysql.com/downloads/windows/installer/8.0.html
            2.- Descargar el instalador de la version community ya que es mas completa que la web
            3.- Hacer la instalacion personalizada y agregar MySQL Server y MySQL Workbench
            4.- Dejar la configuracion del servidor por default
            5.- Seleccionamos contrasreña encripiptada y creamos una contraseña para el usuario root
            6.- Aceptamos que se convierta en servicio de windows y se ejecuta cuando se inicie la computadora
            7.- Damos click en finalizar y ya debe estar listo el servidor y workbench
        */
        
        /* Conectarse a una base de datos (Servidor MySQL)
            1.- Abrimos MySQL workbench
            2.- En la pestaña "Database" seleccionamos "Connect to database"
            3.- Introducimos el nombre de dominio del servidor "localhost" o "127.0.0.1"
            4.- Configuramos el puerto segun lo establecido durante la instalacion de MySQL Server "3306"
            5.- Almacenamos la contraseña que creamos previamente
            6.- Presionamos en "Connect"
        */
        
        /* Crear una base de datos y una tabla
            1.- Presionamos sobre la barra superior "Create new Schema", le damos nombre y presionamos "Apply"
            2.- Del lado izquierdo ya se vera nuestro esquema creado ("test")
            3.- Deplegamos el nuevo esquema y sobre "Tables" seleccionamos "Create new Table" con el click derecho
            4.- Le damos nombre y agregamos el nombre de las columnas
            5.- Configuramos las reglas de cada columna segu corresponda
                a.- PK - Primary Key
                b.- NN - Not Null
                c.- UQ - Unique Index
                d.- B  - Is Binary Column
                e.- UN - Unassigned Data Type
                f.- ZF - Fill values with 0 if is numeric
                g.- AI - Autoincremental (Most for PK)
                h.- G  - Generated column
            6.- Presionamos Apply
            
            Notas
            - "Schema" es como se le conoce a una Base de datos tambien
            - Podemos hacer select con click derecho sobre el nombre de la tabla para traer los records, query autogenerada
            - Del lado izquierdo inferior, la pestaña Administration   permite exportar e Importar Schemas
        */
        
        /* Sentencias DML en SQL
            - SQL (Structure Query Language) Lenguaje que suamos para inteactuar con la Base de datos
            - DML (Data Manipulation Language) permite interactuar con datos de una Base de datos, sus entencias en SQL son
                - SELECT: Permite recuperar registros de la tabla
                    - SELECT * FROM persona;
                - INSERT: Permite agregar registros a una tabla
                    - INSERT INTO persona(nombre, apellido, email, telefono) VALUES ('Javier','Mota','je.dominus.hatred@gmail.com','3320801954');
                - UPDATE: Permite actualizar registros de una tabla
                    - UPDATE persona SET telefono = '1578121284' WHERE id_persona = '2');
                - DELETE: Permite eliminar registros de una tabla
                    - DELETE FROM persona WHERE id_persona = '3';
        */
    }
}
