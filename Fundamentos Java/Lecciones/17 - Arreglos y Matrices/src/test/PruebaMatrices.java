package test;

import domain.Persona;

public class PruebaMatrices {
    public static void main(String[] args) {
        //matricesFundamentos();
        //iterandoMatrices();
        ejercicioFrutas();
        matrizDeObjetos();
    }
    
    public static void matricesFundamentos(){
        //Una matriz es un arreglo de arreglos [][]
            //El primer arreglo controla los renglones y el segundo [] controla las columnas
            //Pueden tener diferentes tamaños
        //Para obtener el primer valor, basta con usar [REN][COL] ... [0][5]
        
        //la definicion es muy aprecida al arreglo, solo que el primero corresponde a renglones y el segundo a columnas
        int[][] edades = new int[3][2];//Matriz de 3 renglones y 2 columnas
        System.out.println("edades = " + edades);//Imprime una referencia, en debug se pueden ver los renglones y columnas
        //Al debugear se pueden ver los arreglos de ints
        
        edades[0][0] = 5; //Modificando renglon 0 y columna 0... Primer posicion
        edades[0][1] = 7; //Modificando renglon 0 y columna 1
        
        edades[1][0] = 8; //Modificando renglon 1 y columna 0... Primer posicion
        edades[1][1] = 4; //Modificando renglon 1 y columna 1
        
        //El ultimo renglon tendra valores por default
        
        //Accediendo al primer renglon de la matriz
        System.out.println("edades renglon 0 columna 0 = " + edades[0][0]);
        System.out.println("edades renglon 0 columna 1 = " + edades[0][1]);        
        
        //Accediendo al segundo renglon de la matriz
        System.out.println("edades renglon 1 columna 0 = " + edades[1][0]);
        System.out.println("edades renglon 1 columna 1 = " + edades[1][1]);
        
        //Accediendo al tercer renglon de la matriz
        System.out.println("edades renglon 2 columna 0 = " + edades[2][0]);
        System.out.println("edades renglon 2 columna 1 = " + edades[2][1]);
    }
    
    private static void iterandoMatrices(){
        //Sintaxis resumida, inicializando con valores
        int[][] edades = {{2,3},{5,8},{7,1}};//{...}Renglones, {...{,}...} Columans
        
        //La variable ren contabiliza los renglones de la matriz
        for(int ren = 0; ren < edades.length; ren++){//El limite es la longitud de los renglones de la matriz edades
            //La variable col contabiliza las columnas de cada renglon de la mtriz
            for(int col = 0; col < edades[ren].length; col++){//Limite es la longitud de cada renglon de la matriz
            //edaded[ren] - hace referencia a un vercto (columna... por eso se puede llamar a length
                
                //String builder practice
                StringBuilder sb = new StringBuilder();
                sb.append("Renglon: ").append(ren);//Tomar la iteracion del renglon
                sb.append(", Columna: ").append(col);//Tomar la iteracion de la colum,na
                sb.append(" = ").append(edades[ren][col]);//imprimir valor actual de iteracion ren - col
                
                System.out.println(sb.toString());
            }
        }
        
        //imprimir(edades);//Incompatible por ser tipo primitivo
    }
    
    private static void ejercicioFrutas(){
        //No tienen porque ser siempre matrices cuadras, el segundo renglon tiene 3 columnas y el primero no
        //|_|_|
        //|_|_|_|
        String[][] frutas = {{"Limon","Naranja"},{"Uva","Manzana","Mora"}};//Matriz simplificada        

        
        for (int i = 0; i < frutas.length; i++){
            for (int j = 0; j < frutas[i].length; j++){
                StringBuilder sb = new StringBuilder();
                sb.append("Renglon: ").append(i).append(", Columna: ").append(j).append(" =").append(frutas[i][j]);
                System.out.println(sb.toString());
            }
        }
        
        imprimir(frutas);//Compatible por ser tipo Object
    }
    
    private static void matrizDeObjetos(){
        //Creacion de matriz con personas
        Persona personas[][] = new Persona[2][3];
        personas[0][0] = new Persona("Javier");
        personas[0][1] = new Persona("Natalia");
        
        imprimir(personas);//Compatible por ser tipo Object
    }
    
    //creacion de metodo para imprimir cualquier matriz, por eso es de tipo object
    private static void imprimir(Object matriz[][]){//Compatible con matrices de tipo Object... NO se puede usar con priitivos
        System.out.println("Imprimiendo desde metodo Imprimir");
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                StringBuilder sb = new StringBuilder();
                sb.append("Renglon: ").append(i).append(", Columna: ").append(j).append(" =").append(matriz[i][j]);
                System.out.println(sb.toString());
            }
        }
    }
}
