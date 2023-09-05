<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1">Gestor Personas</span>
			<span class="navbar-brand mb-0 h3">Usuario logeado: Pedro</span>
			<span class="navbar-brand mb-0 h3"><a class="text-decoration-none text-white" href="index.html">Salir</a></span>
		</div>
	</nav>
	
	<h1>Listado de Personas</h1>

	<div><a href="InsertarPersonaController">Nuevo</a></div>
	
	
    
	<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Nombre</th>
			<th scope="col">Contraseña</th>
			<th scope="col">Acciones</th>
		</tr>
	</thead>

		<c:forEach items="${personas}" var="persona">
			<tr>
				<td scope="row">${persona.id}</td>
				<td>${persona.nombre}</td>
				<td>${persona.password}</td>
				<td><a href="actualizarPersona.html">Actualizar</a> | <a href="listarPersona.html">Eliminar</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>