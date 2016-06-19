<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="br.com.dogcatroom.dto.ServicoDTO" %>
<% session.setAttribute("page", "Servicos");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="/template/head.jsp"/>
<title>DogECatRoom - Serviços</title>
</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp"/>
	
	<div class="clOpcoesCrud">
		<a href="Sistemas/Servicos/cadastrarServicos.jsp">
			<button class="btn btn-primary">Cadastrar</button>
		</a>
		<a href="/DogECatRoom/principal.jsp">
			<button class="btn btn-danger">Voltar</button>
		</a>			
	</div>

	<table class="table">
		<thead>
			<tr>
				<th>Servico</th> 
				<th>Descricao</th> 
				<th>Valor</th> 
				<th>Acao</th> 
			</tr>
		</thead>
		
	<% 
	//retorna object tem que fazer cast pois nois sabe que é uma lista
		List<ServicoDTO> lista=(List<ServicoDTO>) request.getAttribute("lista");	
	for(ServicoDTO servico : lista){
	%>
	<tr>
		<td><% out.print(servico.getNome()); %></td>
		<td><% out.print(servico.getDescricao()); %></td> 
		<td><% out.print(servico.getValor()); %></td>
		<td>
			<a href="ServicoController?acao=excluir&id=<%out.print(servico.getId());%>" onclick="return deletar();">
				<button class="btn btn-danger btn-xs">X</button>
			</a>
			<a href="ServicoController?acao=alterar&id=<%out.print(servico.getId());%>">
				<button class="btn btn-warning btn-xs">Alterar</button>
			</a>
		</td>
	</tr>
<% } %>
</table>

	<jsp:include page="/template/rodape_padrao.jsp"/>
</body>
</html>