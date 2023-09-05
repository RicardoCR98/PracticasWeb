<?php 
#Para levantar la sesión 
session_start();
//usamos rquier_once para cargar el fichero 1 sola vez (para optimizar)
//el require carga todo y se pueden cargar varias veces provocando overbuffer
require_once('./modelo/Fichero.php');
$FicherInstancia = new Fichero();
$contenido = $FicherInstancia -> getContenido();
var_dump($contenido);

if(!isset($_SESSION['nombre'])){
    if($_POST['nombre'] != "" && $_POST['clave'] !=""){
        #crearmos la sesión
        $_SESSION['nombre'] = $_POST['nombre'];
    }else{
        header("Location:index.php");
    }
    
}

?>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mi panel</title>
</head>
<body>
    <h1>Panel principal de BestBuy</h1>
    <h3>Bienvenido: <?php echo $_SESSION['nombre'] ?></h3>
    <br>
    <p><a href="otrapagina.php">Calzado</a></p>
    <p><a href="index.php">Cerrar sesión</a></p>

    <ul>
        <?php foreach($contenido as $item){ ?>
            <li><?php echo $item; ?></li>
        <?php } ?>
    </ul>

</body>
</html>


