<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
	<link rel="stylesheet" href="css/styles.css" />


</head>
<body>

<%@include file= '../templates/banner_inside.html'%>

	<div class="wrapper">
		
		<div>
			<a href="listarPersona.html">Ir a Menú principal</a><br>
		</div>
		<h1>Actualizar Persona</h1>
		<form method="POST" action="">
			<input type="hidden" value="1" name="txtIdPersona" /> <label
				for="txtNombre">Nombre</label><br> <input type="text"
				name="txtNombre" id="txtNombre" value="Pedro" /><br>
			<label for="txtClave">Clave</label><br> <input type="text"
				name="txtClave" id="txtClave" value="pedro123" /><br><br>
			<input type="submit" value="Guardar">
		</form>

	</div>
</body>


</html>