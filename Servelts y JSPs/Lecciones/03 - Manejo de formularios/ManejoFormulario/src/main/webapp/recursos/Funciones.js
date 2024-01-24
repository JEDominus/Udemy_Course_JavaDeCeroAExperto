//Este archivo validara los elementos del formulario antes de llamar al servlet

//este metodo va a recibir todo el objeto de tipo forma de html, es decir, todo el formulario
function validarForma(forma){
    //1.- Validacion del usuario
    var usuario = forma.iUsuario;//se recupera de la forma con el nombre establecido en el elemento
    if(usuario.value == "" || usuario.value == "Escribir usuario"){
        alert("Debe proporcionar un nombre de usuario"); //Lanza una alerta en el navegador
        usuario.focus();//Ponemos el foco en el elemento usuario
        usuario.select();//Seleccionamos donde se encuentra el foco
        return false;//Si es false es que no es valida y no llama al servlet
    }
    
    //2.- Validacion de password
    var password = forma.iPassword;
    if(password.value == "" || password.value.length < 3){//Si el pw es menor a 3 caracteres
        alert("El password debe ser mayor a 3 elementos");
        password.focus();
        password.select();
        return false;
    }
    
    //3.- validar tecnologias
    var tecnologias = forma.iTecnologia;
    var checkSeleccionado = false;
    
    for(var i = 0; i < tecnologias.length; i++){
        if(tecnologias[i].checked){//Saber si algun elemento se ha seleccionado
            checkSeleccionado = true;//Al menos se selecciono 1
        }
    }
    
    if(!checkSeleccionado){
        alert("Debe seleccionar una tecnologia");
        return false;
    }
    
    //4.- Validar genero
    var generos = forma.iGenero;
    var radioSeleccionado = false;
    
    for(var i = 0; i < generos.length; i++){
        if(generos[i].checked){//Saber si algun elemento se ha seleccionado
            radioSeleccionado = true;//Al menos se selecciono 1
        }
    }
    
    if(!radioSeleccionado){
        alert("Debe seleccionar un genero");
        return false;
    }
    
    //5.- Validar ocupacion
    var ocupacion = forma.iOcupacion;
    
    if(ocupacion.value == "" ){//Si el pw es menor a 3 caracteres
        alert("Debe seleccionar una ocupacion");
        return false;
    }
    
    alert("Formulario valido, enviando datos al servidor")
    return true;
}
