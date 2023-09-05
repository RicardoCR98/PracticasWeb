<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>pagina de inicio</h1>
<!--Las peticiones siempre SIEMPRE llegan al servlet controlador-->
<!-- Me voy a la raiz y le llamo a personaController -->
	<form method="get" action="../PersonaController">
		<label for="idNombre">Nombre:</label>
		<input type="text" name="nombre" id="txtNombre"/>
		<input type="submit" value="Saludar"/>
	</form>
</body>
</html>