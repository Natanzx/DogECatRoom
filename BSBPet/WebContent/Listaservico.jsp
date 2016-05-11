<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.List" %>
    <%@page import="br.upis.Servico" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar servico</title>
</head>
<body>
<br>
<br>
<p align="center" style="font-size:18px; font-weight: bold;">Serviços</p>
	<table bgcolor="#e0e0e0" align="center" cellpadding=4 style="width:800px; text-align: center; font-family:"Arial, Helvetica, sans-serif;">
		<tr bgcolor="#2b3e8c" style="color: #FFF;">
			<th>Matricula</th> <th>Tipo de serviço</th> <th>Valor</th> <th>ACAO</th> 
		</tr>   
	<% //retorna object tem que fazer cast pois nois sabe que é uma lista
		List<Servico> lista=(List<Servico>) request.getAttribute("lista");	
	for(Servico cli:lista){
	%>
		<tr>
			<td><% out.print(cli.getId()); %></td>
			<td><% out.print(cli.getTipo()); %></td>
			<td>R$<% out.print(cli.getValor()); %></td>
			<td>
				<a href="ServicoController?acao=excluir&id=<%out.print(cli.getId());%>">Excluir</a>
				|
				<a href="ServicoController?acao=alterar&id=<%out.print(cli.getId());%>">Alterar</a>
			</td>
		</tr>
	<% } %>
		<tr>
			<td colspan=4 align="center"><a href="Inicio.jsp">VOLTAR</a></td>
		</tr>
	</table>

</body>
</html>