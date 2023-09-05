<?php

session_start();
# Verificar si el usuario ha iniciado sesión
if (!isset($_SESSION['nombre']) || empty($_SESSION['nombre'])) {
    header("Location: index.php");
    exit();
}
# Verificar si se ha seleccionado un idioma
if (isset($_GET['lang'])) {
    $idioma = $_GET['lang'];

    # Guardar la preferencia de idioma en una cookie válida por 24 horas
    setcookie('idioma', $idioma, (24 * 60 * 60));
} else {
    # Obtener el idioma guardado en la cookie (si existe)
    $idioma = isset($_COOKIE['idioma']) ? $_COOKIE['idioma'] : 'en';
}

echo "POST: ";
var_dump($_POST);
echo "<br>";
echo "SESSION: ";
var_dump($_SESSION);
echo "<br>";
echo "COOKIE: ";
var_dump($_COOKIE);
echo "<br>";
echo "GET: ";
var_dump($_GET);

#LEEMOS LOS FICHEROS EN INGLES Y ESPAÑOL
require_once('./modelo/producto.php');
$instance = new producto();
$contenidoEN = $instance->getContenidoEN();
$contenidoES = $instance->getContenidoES();


#COOKIES PARA RECORDAR USUARIO Y CLAVE
$nombre = $_SESSION['nombre'];
$clave =  $_SESSION['clave'];
$preferencias = isset($_SESSION['chkpreferencias']) ? $_SESSION['chkpreferencias'] : '';

if ($preferencias != "") { #Si preferencias tiene valores -> se guarda las cookies
    #Solo si se pidió guardar las preferencias, creamos las cookies
    #la cookie se crea en el servidor pero se almacena en el navegador
    setcookie("c_nombre", $nombre, 0);
    setcookie("c_clave", $clave, 0);
    setcookie("c_preferencias", $preferencias, 0);
}else { #Si preferencias no tiene valores -> no se guarda las cookies
    if (isset($_COOKIE)) {
        foreach ($_COOKIE as $name => $value) {
            setcookie($name, '', 1);
        }
    }
}



?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <h1>PANEL PRINCIPAL</h1>

    <h4>Bienvenido Usuario: <?php echo $_SESSION['nombre'] ?></h4>

    <a href="?lang=es">ES(Español)</a>
    <a href="?lang=en">EN(English)</a>
    <br>
    <br>
    <a href="cerrarsesion.php">Cerrar sesión</a> <br>


    <h2>Lista de Productos</h2>
    <ul>
        <?php foreach ($idioma === 'en' ? $contenidoEN : $contenidoES as $item) { ?>
            <li> <?php echo $item; ?> </li>
        <?php } ?>
    </ul>



</body>

</html>