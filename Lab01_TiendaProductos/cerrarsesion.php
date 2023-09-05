<?php
# Cerrar la sesión
session_start();
session_destroy();

# Redirigir a la página de inicio de sesión
header("Location: index.php");
?>