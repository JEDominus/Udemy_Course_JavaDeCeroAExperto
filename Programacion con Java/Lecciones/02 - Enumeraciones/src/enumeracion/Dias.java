package enumeracion;

//Las enumeraciones empiezan con "enum" en lugar de "class"
//este enumerador contiene los dias de la semana
public enum Dias {
    //POR DEFAULT, los elementos de enum son constantes = publicos, estaticos y finales... Por eso son con mayusculas
    //Se declaran los valores (dias) separados por coma 
        //Seria ams tedioso definir cada constante por separadop como en una clase normal
    LUNES,
    MARTES,
    MIERCOLES,
    JUEVES,
    VIERNES,
    SABADO,
    DOMINGO
}
