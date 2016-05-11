<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
    <%@page import="br.upis.Cliente" %>
    <%@page import="br.upis.Servico" %>
    <%@page import="br.upis.Orcamento" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Venda BSBPET</title>
</head>
<body>
<p align="right" style="font-size: 13px;"">você está logado como: <%=session.getAttribute("usuario") %></p>
<br>
	<form method="post" action="OrcamentoController">
	<table bgcolor="#e0e0e0" align="center" width="400px" height="250px" style="text-align:center; font-family:"Arial, Helvetica, sans-serif;">
		<tr bgcolor="#2b3e8c" style="color: #FFF;">
			<td colspan="2">Informe os dados:</td>
		</tr>
		<tr>
			<td colspan="2">Selecione o Cliente/Animal:</td>
		</tr>
		<tr>
			<td colspan="2">
				<select style="width: 300px;" name="id_cliente">
					<% 
					//retorna object tem que fazer cast pois nois sabe que é uma lista
					List<Cliente> listaCliente = (List<Cliente>) request.getAttribute("listaCliente");
					for(Cliente cli:listaCliente){
					%>
					<option width="300px" value="<% out.print(cli.getId()); %>">
						<% out.print(cli.getNome()); %> - 
						<% out.print(cli.getAnimal()); %>
					</option>
					<% } %>
				</select>
			</td>
		</tr>
		<tr >
			<td colspan="2">Selecione o tipo de Servico:</td>
		<tr>
			<td colspan="2">
				<select style="width: 300px;" name="id_servico">
				<%	
					List<Servico> listaServico = (List<Servico>) request.getAttribute("listaServico");
					for(Servico ser:listaServico){
				%>
					<option style="width: 300px" value="<% out.print(ser.getId()); %>">
						<% out.print(ser.getTipo()); %> - R$
						<% out.print(ser.getValor()); %>
					</option>
				<% } %>	
				</select>
			</td>
		</tr>

		<tr>
			<td align="center"><a href="Inicio.jsp">Voltar</a></td>
			<td> <input type="submit" value="Realizar Venda"></td>
		</tr>
	</table>
	
	
	
	
	<table>
		<tr>
			<td>
			
			</td>
		
		</tr>
		<tr>
			<td>
			
			</td>
		
		</tr>
		<tr>
			<td>
			
			</td>
		
		</tr>
		<tr>
			<td>
			
			</td>
		
		</tr>
	
	
	
	</table>

</body>
</html>