<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
    <%@page import="br.upis.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Cliente</title>
</head>
<body>
<br>
<br>
<p align="center" style="font-size:18px; font-weight: bold;">Clientes</p>
<table bgcolor="#e0e0e0" align="center" cellpadding=4 style="text-align:justify; width:800px; font-family:"Arial, Helvetica, sans-serif;">
	<tr bgcolor="#2b3e8c" style="color: #FFF;">
		<th>Matricula</th> <th>Nome do Cliente</th> <th>Telefone</th> <th>CPF</th> <th>Endereço</th> <th>Pet</th> <th>ACAO</th></tr>
	</tr>    
	<% 
	//retorna object tem que fazer cast pois nois sabe que é uma lista
		List<Cliente> lista=(List<Cliente>) request.getAttribute("lista");	
	for(Cliente cli:lista){
	%>
	<tr>
		<td align="center"><% out.print(cli.getId()); %></td>
		<td><% out.print(cli.getNome()); %></td>
		<td><% out.print(cli.getTelefone()); %></td>
		<td><% out.print(cli.getCpf()); %></td> 
		<td><% out.print(cli.getEndereco()); %></td>
		<td><% out.print(cli.getAnimal()); %></td>
		<td align="center">
			<a href="ClienteController?acao=excluir&id=<%out.print(cli.getId());%>">Excluir</a>
			|
			<a href="ClienteController?acao=alterar&id=<%out.print(cli.getId());%>">Alterar</a>
		</td>
	</tr>
<% } %>
	<tr>
		<td align="center" colspan=7><a href="Inicio.jsp">Voltar</a></td>
	</tr>
</table>

</body>
</html>