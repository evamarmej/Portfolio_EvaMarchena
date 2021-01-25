
window.onload = function () {
    document.formularioContacto.calcdni.focus();
    document.formularioContacto.addEventListener('submit', validarFormulario);

    var fecha = new Date(); //Fecha actual
    var hora = fecha.getHours(); //obteniendo mes
    var minuto = fecha.getMinutes(); //obteniendo dia
    var segundo = fecha.getSeconds(); //obteniendo año
    if(hora<10){
        hora='0'+hora; //agrega cero si el menor de 10
    }
    if(minuto<10){
        minuto='0'+minuto //agrega cero si el menor de 10
    }
    if(segundo<10){
        segundo='0'+segundo //agrega cero si el menor de 10
    }
    document.getElementById('reloj').value = "  " + hora+" : "+minuto+" : "+segundo;
}
    
     
    
function validarFormulario(evObject) {
    evObject.preventDefault();
    var todoCorrecto = true;
    var formulario = document.formularioContacto;
    for (var i=0; i<formulario.length; i++) {
        if(formulario[i].type =='text' && formulario[i].type != 'resultado' && formulario[i].type != 'resul') {
            if (formulario[i].value == null || formulario[i].value.length == 0 || /^\s*$/.test(formulario[i].value)){
            alert (formulario[i].name+ ' no puede estar vacío o contener sólo espacios en blanco');
            todoCorrecto=false;
            }
        }
    }
    if (todoCorrecto ==true) {formulario.submit();}
}

function solonumeros(e){
    key = e.keyCode || e.which;
    teclado =  String.fromCharCode(key);
    numeros = "1234567890";
    especiales = "8-37-38-46";
    teclado_especial = false;

    for(var i in especiales){
        if(key==especiales[i]){
            teclado_especial=true;
        }
    }
    if(numeros.indexOf(teclado)== -1 && !teclado_especial){
        return false;
    }
}

function Validarcp(cp) {
    if (cp.value.length < 5 || cp.value.length > 5 ) {
      alert("El código postal debe tener 5 dígitos");
      cp.focus();
      cp.select();
    }
}

function Validartelefono(telefono) {
    if (telefono.value.length < 9 || telefono.value.length > 9 ) {
        alert("El teléfono debe tener 9 dígitos");
        telefono.focus();
        telefono.select();
    }
}

function validaremail (correo){
	patron = /^([\da-z_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/
	if(!patron.exec(correo)){
        alert('email no valido');
        document.getElementById("correo").style.borderColor = "red";

	}else{
        document.getElementById("correo").style.borderColor = "green";
    }
}

function validariban() {
    banco = document.getElementById("banco").value;
	sucursal = document.getElementById("sucursal").value;
	digitocontrol = document.getElementById("digitocontrol").value;
    numcuenta = document.getElementById("numcuenta").value;
    
    var numeros = banco + sucursal + digitocontrol + numcuenta;
    numeros = numeros.trim();
    numeros = numeros.replace(/\s/g, "");
    var calculo = "ES00" + numeros;
    var ibanletraS,ibanletraE,buscarletraE,buscarletraS;
    var sustituir;
    if (calculo.length != 24) {
        return false;
    }
    ibanletraS = calculo.substring(0, 1);
    ibanletraE = calculo.substring(1, 2);
    abc = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    buscarletraE = abc.search(ibanletraS) + 10;
    buscarletraS = abc.search(ibanletraE) + 10;
    sustituir = String(buscarletraE) + String(buscarletraS) + calculo.substring(2);
    sustituir = sustituir.substring(6) + sustituir.substring(0,6);
    var mover = Math.ceil(sustituir.length/7);
    var recordar = "";
    for (var i = 1; i <= mover; i++) {
        recordar = String(parseFloat(recordar+sustituir.substr((i-1)*7, 7))%97);
    }
    var total;
    total = recordar;
    total = 98 - total;
    document.getElementById("resultado").value = ibanletraS + ibanletraE + total;
}

function calculadni(dni)
{
var JuegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKET";
var Posicion= dni % 23;
var Letra = JuegoCaracteres.charAt(Posicion);
return Letra;
}
function seleccionaridioma(elemento) {

    var elementosObtenidos = document.getElementsByName(elemento);
    var msg = 'Has seleccionado --> ';
    var elegidos = 0;

    for (var i = 0; i < elementosObtenidos.length; i++) {
        if (elementosObtenidos[i].checked){
            ++elegidos;
            msg = msg + elementosObtenidos[i].value + '  -  ';
        }
    };
    //alert (msg);
    document.getElementById("resul").value = msg;
}

//function validarfecha(campo) {
//    var RegExPattern = /^\d{1,2}\/\d{1,2}\/\d{2,4}$/;
//    if ((campo.match(RegExPattern)) && (campo!='')) {
//          return true;
//    } else {
//          return false;
//    }
//}


function validarfecha(date) {
    var valid = true;

    date = date.replace('/-/g', '');

    var mes = parseInt(date.substring(0, 2),10);
    var dia   = parseInt(date.substring(2, 4),10);
    var ano  = parseInt(date.substring(4, 8),10);

    if(isNaN(dia) || isNaN(mes) || isNaN(ano)) return false;

    if((mes < 1) || (mes > 12)) valid = false;
    else if((dia < 1) || (dia > 31)) valid = false;
    else if(((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11)) && (dia > 30)) valid = false;
    else if((mes == 2) && (((ano % 400) == 0) || ((ano % 4) == 0)) && ((ano % 100) != 0) && (dia > 29)) valid = false;
    else if((mes == 2) && ((ano % 100) == 0) && (dia > 29)) valid = false;
    else if((mes == 2) && (dia > 28)) valid = false;

return valid;
}



