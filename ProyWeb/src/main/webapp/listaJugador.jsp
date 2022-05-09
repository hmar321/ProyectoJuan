<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.Jugadores"%>
<%@ page import="com.ies.baroja.Controller"%>
<%@ page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Listado de jugadores de la NBA</title>
</head>
<body>
	<div class="container mt-3">
		<h1>
			Datos Jugador
		</h1>
		<table class="table table-striped">
			<thead class="table-dark">
				<tr>
					<th>nombre</th>
					<th>procedencia</th>
					<th>altura</th>
					<th>peso</th>
					<th>posicion</th>
					<th>nombre_equipo</th>
				</tr>
			</thead>
			<tbody>
				<%
				HttpSession sesion = request.getSession();
				Jugadores jugador = (Jugadores) sesion.getAttribute("jugador");
				out.println("<tr class='table-primary'>");
				out.println("<td>" + jugador.getNombre() +"</td>");
				out.println("<td>" + jugador.getProcedencia() + "</td>");
				out.println("<td>" + jugador.getAltura() + "</td>");
				out.println("<td>" + jugador.getPeso() + "</td>");
				out.println("<td>" + jugador.getPosicion() + "</td>");
				out.println("<td>" + jugador.getNombre_equipo() + "</td>");
				out.println("</tr>");
				%>
			</tbody>
		</table>
	</div>
</body>
</html>