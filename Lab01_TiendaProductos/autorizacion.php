<?php
#para iniciar sesión se usa session_start()
session_start();
$nombre = $_POST['nombre'];
$clave =  $_POST['clave'];
$preferencias = isset($_POST['chkpreferencias']) ? $_POST['chkpreferencias'] : '';
#CREAMOS LA SESIÓN
#el primer isset devuelve false, pero con "!" devuelve true y entra en el condicional
# si no existe la sesión -> entra dentro del if para crearla
if (isset($_POST) || !empty($_POST)) {
    #luego comprobamos los datos enviados, y verificamos que no sean valores nulos
    #creamos la sesión
    if ($nombre != "" && $clave != "" && $preferencias != "") {
        #creamos la sesión
        $_SESSION['nombre'] = $nombre;
        $_SESSION['clave'] = $clave;
        $_SESSION['chkpreferencias'] = $preferencias;
        header("Location: PanelPrincipal.php");
    } else if($nombre != "" && $clave != "" && $preferencias == ""){
        $_SESSION['nombre'] = $nombre;
        $_SESSION['clave'] = $clave;
        header("Location: PanelPrincipal.php");
    }else{
        header("Location: index.php");
    }
} else {
    header("Location: index.php");
}
