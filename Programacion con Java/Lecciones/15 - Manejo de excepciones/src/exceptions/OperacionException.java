package exceptions;

//Para que el compilador la tome como una exception, tiene que heredar de alguna exception
    //Si heredamos de Exception, se convierte en una CheckedException
    //Si heredamos de RuntimeException, se convierte en UncheckedException
//Esta exception podra estar presente en la clase que lance este tipo de exceprtion, aritmetica por ejemplo
public class OperacionException extends Exception{
    public OperacionException(String mensaje){
        super(mensaje);
        //En exceptiones que heredan de Exception, se debe propagar un mensaje a la clase padre
            //Hablandod e herencia y clases padre, por esos e utiliza super
    }
}
