<?php 
session_start();
if(!isset($_SESSION['nombre'])){
    header("Location:index.php");
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
    <h1>Categoría Zapatos</h1>
    <h3>Usuario Logado: <?php echo $_SESSION['nombre'] ?></h3>
    <hr>
    <p><a href="mipanel.php">Ir al panel principal</a></p>
    <p><a href="index.php">Cerrar sesión</a></p>

</body>
</html>