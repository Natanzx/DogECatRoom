<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="br.com.dogcatroom.dto.ClienteDTO" %>
<%@page import="br.com.dogcatroom.dto.ServicoDTO" %>
<%@page import="br.com.dogcatroom.dto.AnimalDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="/template/head.jsp"/>
<title>DogECatRoom - Clientes</title>
</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp"/>

	<div class="clOpcoesCrud">
		<a href="/DogECatRoom/principal.jsp">
			<button class="btn btn-danger">Voltar</button>
		</a>		
	</div>

<form action="AtendimentoController" method="post">
		<table class="table tblClientes">
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
					List<ClienteDTO> listaCliente = (List<ClienteDTO>) request.getAttribute("listaCliente");
					for(ClienteDTO cliente:listaCliente){
					%>
						<% 
						List<AnimalDTO> animalLista =  cliente.getAnimal();
						for(AnimalDTO animal : animalLista){
						%>
						
						<option width="300px" value="<% out.print(cliente.getId()); %>">
							<%
							out.print(cliente.getNome() +"-"+ animal.getNome() +"-"+ animal.getTipo());
							%>
						</option>
						<% } %>
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
					List<ServicoDTO> listaServico = (List<ServicoDTO>) request.getAttribute("listaServico");
					for(ServicoDTO servico:listaServico){
				%>
					<option style="width: 300px" value="<% out.print(servico.getId()); %>">
						<% out.print(servico.getNome()); %> - R$
						<% out.print(servico.getValor()); %>
					</option>
				<% } %>	
				</select>
			</td>
		</tr>

		<tr>
			<td> <input type="submit" value="Realizar Venda" class="btn btn-primary"></td>
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
	</form>

	<jsp:include page="/template/rodape_padrao.jsp"/>
</body>
</html>