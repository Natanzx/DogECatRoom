<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="/template/head.jsp"/>
<title>DogECatRoom - Funcionários</title>
</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp"/>

	<div class="clOpcoesCrud">
		<a href="cadastrarFuncionarios.jsp">
			<button class="btn btn-default">Cadastrar</button>
		</a>
	</div>
	
	<table class="clTblCliente table">
		<tr>
			<th>Nome</th>
			<th>CPF</th>
			<th>CEP</th>
			<th>Endereço</th>
			<th>Número</th>
			<th>Complemento</th>
			<th>Bairro</th>
			<th>Cidade</th>
			<th>Estado</th>
			<th>Telefone Celular</th>
			<th>Telefone Fixo</th>
			<th>Escolaridade</th>
			<th>Ocupação</th>
			<th>Salário</th>
		</tr>

		<tr>
		</tr>						
	</table>

	<jsp:include page="/template/rodape_padrao.jsp"/>
</body>
</html>