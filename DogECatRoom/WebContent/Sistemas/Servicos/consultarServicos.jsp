<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="br.com.dogcatroom.dto.ServicoDTO" %>
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
			<button class="btn btn-default">Cadastrar</button>
		</a>
	</div>

	<table border="1" class="table">
	<tr bgcolor="#2b3e8c" style="color: #FFF;">
		<th>Id</th> 
		<th>Servico</th> 
		<th>Descricao</th> 
		<th>Valor</th> 
		<th>Acao</th> 
	</tr>
	</tr>    
	<% 
	//retorna object tem que fazer cast pois nois sabe que é uma lista
		List<ServicoDTO> lista=(List<ServicoDTO>) request.getAttribute("lista");	
	for(ServicoDTO servico : lista){
	%>
	<tr>
		<td align="center"><% out.print(servico.getId()); %></td>
		<td><% out.print(servico.getNome()); %></td>
		<td><% out.print(servico.getDescricao()); %></td> 
		<td><% out.print(servico.getValor()); %></td>
		<td align="center">
			<a href="ServicoController?acao=excluir&id=<%out.print(servico.getId());%>">Excluir</a>
			|
			<a href="ServicoController?acao=alterar&id=<%out.print(servico.getId());%>">Alterar</a>
		</td>
	</tr>
<% } %>
</table>

	<jsp:include page="/template/rodape_padrao.jsp"/>
</body>
</html>