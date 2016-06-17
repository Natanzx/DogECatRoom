<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="br.com.dogcatroom.dto.ClienteDTO" %>
<%@page import="br.com.dogcatroom.dto.ServicoDTO" %>
<%@page import="br.com.dogcatroom.dto.AnimalDTO" %>
<%@page import="br.com.dogcatroom.dto.AtendimentoDTO" %>
<% session.setAttribute("page", "Atendimentos");%>
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
		<a href="/DogECatRoom/AtendimentoController?acao=atendimento">
			<button class="btn btn-primary">Cadastrar</button>
		</a>
		<a href="/DogECatRoom/principal.jsp">
			<button class="btn btn-danger">Voltar</button>
		</a>		
	</div>
	<table class="table tblClientes">
		<thead>
			<tr>
				<td>Nº da Venda</td>
				<td>Cliente</td>
				<td>Animal</td>
				<td>Servico</td>
				<td>Valor</td>
				<td>Data da venda</td>
				<td>Hora da venda</td>
			</tr>
		</thead>
		
		<tbody>
	<%
		List<AtendimentoDTO> lista = (List<AtendimentoDTO>) request.getAttribute("lista");	
		for(AtendimentoDTO atendimento:lista){
	%>
			<tr>
				<td align="center"><% out.print(atendimento.getId()); %></td>
				<td><% out.print(atendimento.getAnimal().getCliente().getNome()); %></td>
				<td><% out.print(atendimento.getAnimal().getNome()); %></td>
				<td><% out.print(atendimento.getServico().getNome()); %></td>
				<td align="center"><% out.print(atendimento.getServico().getValor()); %></td>
				<td align="center"><% out.print(atendimento.getData()); %></td>
				<td align="center"><% out.print(atendimento.getHora()); %></td>
			</tr>
<% } %>
		</tbody>
	</table>
	
	<jsp:include page="/template/rodape_padrao.jsp"/>
</body>
</html>