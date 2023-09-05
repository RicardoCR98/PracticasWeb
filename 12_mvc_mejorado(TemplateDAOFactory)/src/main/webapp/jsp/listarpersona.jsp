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

	<%@include file= '../templates/banner_inside.html'%>
	
	<h1>Listado de Personas</h1>

	<div><a href="GestorPersonaController?ruta=nuevo">Nuevo</a></div>
	
	
    
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