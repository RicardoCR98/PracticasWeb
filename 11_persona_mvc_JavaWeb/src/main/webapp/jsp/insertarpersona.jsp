<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar Persona</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
</head>
<body>


	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1">Gestor Personas</span>
			<span class="navbar-brand mb-0 h3">Usuario logeado: Pedro</span>
			<span class="navbar-brand mb-0 h3"><a class="text-decoration-none text-white" href="login.html">Salir</a></span>
		</div>
	</nav>


	<div class="wrapper">
	<div><a href="listarPersona.html"> Ir a Menú Principal</a></div>
		

		<h1>Insertar Persona</h1>
		<form method="POST" action="../InsertarPersonaController">
			<label for="txtId">Id</label> <br>
			<input type="text" name="txtId" id="txtId" /> <br>
			
			<label for="txtNombre">Nombre</label> <br>
			<input type="text" name="txtNombre" id="txtNombre" /><br> 
			
			<label for="txtClave">Clave</label><br>
			<input type="password" name="txtClave" id="txtClave" /> 
			<br><br> 
			<input type="submit" value="insertar"> 
		</form>


	</div>
</body>
</html>