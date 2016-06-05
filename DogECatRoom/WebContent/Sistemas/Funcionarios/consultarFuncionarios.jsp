<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ page import="br.com.dogcatroom.dto.FuncionarioDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/template/head.jsp" />
<title>DogECatRoom - Funcionários</title>
</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp" />

	<div class="clOpcoesCrud">
		<a href="Sistemas/Funcionarios/cadastrarFuncionarios.jsp">
			<button class="btn btn-default">Cadastrar</button>
		</a>
	</div>

	<table class="table">
		<tr bgcolor="#2b3e8c" style="color: #FFF;">
		
			<th>Matricula</th>
			<th>Nome</th>
			<th>CPF</th>
			<th>Telefone Celular</th>
			<th>Telefone Fixo</th>
			<th>Ocupação</th>
			<th>Salário</th>
			<th>login</th>
			<th>Ativo</th>
			<th>Ações</th>
		</tr>
		<% 
	//retorna object lista
		List<FuncionarioDTO> lista =(List<FuncionarioDTO>) request.getAttribute("lista");	
	for(FuncionarioDTO funcionario : lista){
	%>
		<tr>
		<td><% out.print(funcionario.getMatricula()); %></td>
			<td><% out.print(funcionario.getNome()); %></td>
			<td><% out.print(funcionario.getCpf()); %></td>
			<td><% out.print(funcionario.getTelCelular()); %></td>
			<td><% out.print(funcionario.getTelFixo()); %></td>
			<td><% out.print(funcionario.getOcupacao()); %></td>
			<td><% out.print(funcionario.getSalario()); %></td>
			<td><% out.print(funcionario.getLogin()); %></td>
			<td><% out.print(funcionario.isAtivo()? "Inativo" : "Ativo"); %></td>
			<td align="center">
				<a href="FuncionarioController?acao=alterar&id=<%out.print(funcionario.getId());%>">Alterar</a>
			|
				<a href="FuncionarioController?acao=excluir&id=<%out.print(funcionario.getId());%>">Excluir</a>
		</td>
		</tr>
		<% } %>
	</table>

	<jsp:include page="/template/rodape_padrao.jsp" />
</body>
</html>