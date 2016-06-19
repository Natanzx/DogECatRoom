<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="br.com.dogcatroom.dto.ClienteDTO" %>
<% session.setAttribute("page", "Clientes");%>
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
		<a href="/DogECatRoom/ClienteController?acao=cadastrar">
			<button class="btn btn-primary">Cadastrar</button>
		</a>
		<a href="/DogECatRoom/principal.jsp">
			<button class="btn btn-danger">Voltar</button>
		</a>		
	</div>
	
	<table class="table tblClientes">
		<thead>
			<tr>
				<th>Cliente</th> 
				<th>CPF</th> 
				<th>Cep</th> 
				<th>Endereço</th> 
				<th>Numero</th> 
				<th>Complemento</th> 
				<th>Bairro</th> 
				<th>Cidade</th>
				<th>Estado</th> 
				<th>Celular</th> 
				<th>Fixo</th> 
				<th>Acao</th> 
			</tr>
		</thead>
	<% 
	//retorna object tem que fazer cast pois nois sabe que é uma lista
		List<ClienteDTO> lista=(List<ClienteDTO>) request.getAttribute("lista");	
	for(ClienteDTO cliente : lista){
	%>
	<tr>
		<td><% out.print(cliente.getNome()); %></td>
		<td><% out.print(cliente.getCpf()); %></td> 
		<td><% out.print(cliente.getCep()); %></td>
		<td><% out.print(cliente.getEndereco()); %></td>
		<td><% out.print(cliente.getNumero()); %></td>
		<td><% out.print(cliente.getComplemento()); %></td>
		<td><% out.print(cliente.getBairro()); %></td>
		<td><% out.print(cliente.getCidade()); %></td>
		<td><% out.print(cliente.getEstado()); %></td>
		<td><% out.print(cliente.getTelCelular()); %></td>
		<td><% out.print(cliente.getTelFixo()); %></td>
		<td nowrap>
			<a href="ClienteController?acao=excluir&id=<%out.print(cliente.getId());%>" onclick="return deletar();">
				<button id="btnDeleteAnimalTemp" class="btn btn-danger btn-xs">X</button>
			</a>
			
			<a href="ClienteController?acao=alterar&id=<%out.print(cliente.getId());%>">
				<button class="btn btn-warning btn-xs">Alterar</button>
			</a>
		</td>
	</tr>
<% } %>
</table>

	<jsp:include page="/template/rodape_padrao.jsp"/>
</body>
</html>