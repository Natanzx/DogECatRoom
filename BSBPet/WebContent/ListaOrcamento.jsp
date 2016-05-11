<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
    <%@page import="br.upis.Orcamento" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Orcamentos</title>
</head>
<body>
<br>
<br>
<p align="center" style="font-size:18px; font-weight: bold;">Vendas</p>
	<table bgcolor="#e0e0e0" align="center" cellpadding=4 style="text-align:justify; width:800px; font-family:"Arial, Helvetica, sans-serif;">
		<tr bgcolor="#2b3e8c" style="color: #FFF;">
			<td>Nº da Venda</td>
			<td>Cliente</td>
			<td>Servico</td>
			<td>Valor</td>
			<td>Usuario</td>
			<td>Data da venda</td>
		</tr>
	<%
		List<Orcamento> lista = (List<Orcamento>) request.getAttribute("lista");	
		for(Orcamento orc:lista){
	%>
		<tr>
			<td align="center"><% out.print(orc.getId()); %></td>
			<td><% out.print(orc.getNome_cliente()); %></td>
			<td><% out.print(orc.getNome_servico()); %></td>
			<td align="left">R$<% out.print(orc.getValor()); %></td>
			<td><% out.print(orc.getUsuario()); %>
			<td align="center"><% out.print(orc.getData()); %></td>
		</tr>
<% } %>
	<tr>
		<td align="center" colspan=7><a href="Inicio.jsp">Voltar</a></td>
	</tr>	
	</table>

</body>
</html>