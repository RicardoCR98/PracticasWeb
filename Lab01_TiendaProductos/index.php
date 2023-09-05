<?php
$nombre ="";
$clave ="";
$preferencias = false;


if(isset ($_COOKIE['c_preferencias']) && $_COOKIE['c_preferencias']!=""){
    $preferencias =true;
    $nombre = $_COOKIE['c_nombre'];
    $clave = $_COOKIE['c_clave'];
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
    <!--action indica el fichero en el servidor que va a procesar los datos
    cual es el fichero que va a procesar los datos-->
    <form method="POST" action="autorizacion.php">
        <!--name indica el nombre del paraemtro que va al servidor-->
    <h1>LOGIN</h1>
        <fieldset>
            <h3>Usario*:</h3> 
            <input type="text" name ="nombre" value= "<?php echo $nombre?>" required><br>
            <h3>Clave*:</h3>
            <input type ="password" name ="clave" value= "<?php echo $clave?>" required><br>
            <br>
            <input type="checkbox" name="chkpreferencias" <?php ($preferencias)? "checked": "" ?>><b>Recordar mis datos</b>
            <br>
            <input type="submit" value = "Enviar">
        </fieldset>
    </form>
</body>
</html>