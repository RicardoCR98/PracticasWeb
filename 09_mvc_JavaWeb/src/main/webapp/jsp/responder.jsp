<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Problema de seguridad -->
<%
	String nombre= (String)request.getAttribute("dato");
	out.print("El nombre es: "+ nombre);
%>

<!-- Para solucionar este problema java tiene una liberia llamada jspl -->

</body>
</html>