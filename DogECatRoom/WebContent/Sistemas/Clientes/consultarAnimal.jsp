<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="br.com.dogcatroom.dto.AnimalDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th colspan="8">Lista de Animais</th>
			</tr>
			<tr>
				<th>Nome</th>
				<th>Tipo</th>
				<th>Raca</th>
				<th>Cor</th>
				<th>Data Nasc.</th>
				<th>Sexo</th>
				<th>Pedigre</th>
				<th>N° Pedigre</th>
			</tr>
		</thead>
		
		<tbody>
		<%
			List<AnimalDTO> lista =(List<AnimalDTO>) request.getAttribute("listaAnimal");	
			for(AnimalDTO a : lista){
		%>
			
			<tr>
				<td><% out.print(a.getNome()); %></td>
				<td><% out.print(a.getTipo()); %></td>
				<td><% out.print(a.getRaca()); %></td>
				<td><% out.print(a.getCor()); %></td>
				<td><% out.print(a.getDataNasc()); %></td>
				<td><% out.print(a.getSexo()); %></td>
				<td><% out.print(a.getPedigre()); %></td>
				<td><% out.print(a.getNumPedigre()); %></td>				
			</tr>
		<%
			}
		%>
		</tbody>
	</table>	
</body>
</html>
