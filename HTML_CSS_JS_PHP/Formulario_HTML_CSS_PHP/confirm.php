<?php

// Si todos los campos se han enviado, $post es true.
$post = (isset($_POST['dni']) && !empty($_POST['dni'])) &&
        (isset($_POST['nombre']) && !empty($_POST['nombre'])) &&
        (isset($_POST['apellidos']) && !empty($_POST['apellidos'])) &&
        (isset($_POST['domicilio']) && !empty($_POST['domicilio'])) &&
        (isset($_POST['codigopostal']) && !empty($_POST['codigopostal'])) &&
        (isset($_POST['provincia']) && !empty($_POST['provincia'])) &&
        (isset($_POST['telefono']) && !empty($_POST['telefono'])) &&
        (isset($_POST['correo']) && !empty($_POST['correo'])) &&
        (isset($_POST['estadocivil']) && !empty($_POST['estadocivil'])) &&
        (isset($_POST['idioma']) && !empty($_POST['idioma'])) &&
        (isset($_POST['comentarios']) && !empty($_POST['comentarios'])) &&
        (isset($_POST['banco']) && !empty($_POST['banco'])) &&
        (isset($_POST['sucursal']) && !empty($_POST['sucursal'])) &&
        (isset($_POST['digitocontrol']) && !empty($_POST['digitocontrol'])) &&
        (isset($_POST['numcuenta']) && !empty($_POST['numcuenta']));


// Si $post es true, mostrar los resultados.
if ( $post ) {
    $dni = htmlspecialchars($_POST["dni"]);
    $nombre = htmlspecialchars($_POST["nombre"]);
    $apellidos = htmlspecialchars($_POST["apellidos"]);
    $fechanacimiento = htmlspecialchars($_POST["fechanacimiento"]);
    $domicilio = htmlspecialchars($_POST["domicilio"]);
    $codigopostal = htmlspecialchars($_POST["codigopostal"]);
    $provincia = htmlspecialchars($_POST["provincia"]);
    $telefono = htmlspecialchars($_POST["telefono"]);
    $correo = htmlspecialchars($_POST["correo"]);
    $estadocivil = htmlspecialchars($_POST["estadocivil"]);
    $idioma = htmlspecialchars($_POST["idioma"]);
    $comentarios = htmlspecialchars($_POST["comentarios"]);
    $banco = htmlspecialchars($_POST["banco"]);
    $sucursal = htmlspecialchars($_POST["sucursal"]);
    $digitocontrol = htmlspecialchars($_POST["digitocontrol"]);
    $numcuenta = htmlspecialchars($_POST["numcuenta"]);
    $ibancuenta = htmlspecialchars($_POST["ibancuenta"]);
    $hora = htmlspecialchars($_POST["hora"]);


}else {
  // Si es false, volver al formulario.
  header("location:valid_total.html");
}


function LetraNIF ($dni) {
    $valor= (int) ($dni / 23);
    $valor *= 23;
    $valor= $dni - $valor;
    $letras= "TRWAGMYFPDXBNJZSQVHLCKEO";
    $letraNif= $dni . substr ($letras, $valor, 1);
    return $letraNif;
}
$letra=LetraNIF($dni);

function revisaFecha($fechanacimiento) {
    $datosfecha = explode("/",$fechanacimiento);
    if(count($datosfecha) === 3 && checkdate($datosfecha[1],$datosfecha[0],$datosfecha[2])) {
        return $fechanacimiento;
    } else {
        header("location:valid_total.html");
    }
}
$fechanacimiento = revisafecha($fechanacimiento);

function validarcodigopostal($codigopostal){
    if(strlen($codigopostal) === 5 && is_numeric($codigopostal)){
        return $codigopostal;
    }else{
        header("location:valid_total.html");
    }
}
$codigopostal = validarcodigopostal($codigopostal);


function validartelefono($telefono){
    if(strlen($telefono) === 9 && is_numeric($telefono)){
        return $telefono;
    }else{
        header("location:valid_total.html");
    }
}
$telefono = validartelefono($telefono);

function validaremail($correo) {
    if(filter_var($correo,FILTER_VALIDATE_EMAIL)) {
        return $correo;
    } else {
        header("location:valid_total.html");
    }
}
$correo = validaremail($correo);

function estadocivil($estadocivil){
    if($estadocivil == 1){
        $estadocivil = "soltero";
        return $estadocivil;
    }
    if($estadocivil == 2){
        $estadocivil = "casado";
        return $estadocivil;
    }
    if($estadocivil == 3){
        $estadocivil = "divorciado";
        return $estadocivil;
    }
    if($estadocivil == 4){
        $estadocivil = "viudo";
        return $estadocivil;
    }
    if($estadocivil == 5){
        $estadocivil = "Arrejuntado";
        return $estadocivil;
    }

}
$estadocivil = estadocivil($estadocivil);

function idiomas($idioma){
    
    $seleccion = $_POST['idioma'];
    $contador = 0;

    foreach($seleccion as $s){
        $contador = $contador . "</br>" . $s;
    }
    if($contador == 1){
        $contador = "Español";
        return $contador;
    }
    if($contador == 2){
        $contador = "Francés";
        return $contador;
    }
    if($contador == 3){
        $contador = "Inglés";
        return $contador;
    }
    if($contador == 4){
        $contador = "Alemán";
        return $contador;
    }

    return $contador;
}
$idioma = idiomas($idioma);

function modulo97($modulo) {
    $m = 0;
    for($i = 0;$i < strlen($modulo);$i++) {
        $m = ($m * 10 + $modulo[$i]) % 97;
    }
    return $m;
}

function validarcuenta($banco,$sucursal,$digitocontrol,$numcuenta) {
    $cuenta = $banco . $sucursal . $digitocontrol . $numcuenta . "142800";
    $iban = 98 - modulo97($cuenta);
    if($iban <= 9) {
        $iban = "0" . $iban;
    }
    return "ES" . $iban . $banco . $sucursal . $digitocontrol . $numcuenta;
}
$ibancuenta = validarcuenta($banco,$sucursal,$digitocontrol,$numcuenta);


function validarhora($hora){
    date("H");
    date("i");
    date("s");

    $horaactual = date(" H : i : s");
    return $horaactual;
}
$hora = validarhora($hora);


  // Resultado.
  echo "<h1>Formulario</h1> <br/> <br/> 
        <h2>Formulario enviado correctamente</h2><br/>
        <b>DNI: </b>" . $letra .  "<br/><br/> 
        <b>Nombre:</b> " . $nombre . "<br/><br/> 
        <b>Apellidos:</b> " . $apellidos . "<br/><br/> 
        <b>Fecha de nacimiento:</b> " . $fechanacimiento . "<br/><br/> 
        <b>Domicilio:</b> " . $domicilio . "<br/><br/> 
        <b>Código Postal:</b> " . $codigopostal . "<br/><br/> 
        <b>Provincia:</b> " . $provincia . "<br/><br/> 
        <b>Teléfono:</b> " . $telefono . "<br/><br/> 
        <b>Correo electrónico:</b> " . $correo . "<br/><br/> 
        <b>Estado civil:</b> " . $estadocivil . "<br/><br/> 
        <b>Idiomas:</b> " . $idioma . "<br/><br/> 
        <b>Comentarios:</b> " . $comentarios . "<br/><br/> 
        <b>Número de cuenta:</b> " . $banco . $sucursal . $digitocontrol . $numcuenta . "<br/><br/> 
        <b>Cuenta completa: </b>" . $ibancuenta . "<br/><br/> 
        <b>Hora: </b>" . $hora;

?>