<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<a href="cadastrarServicos.jsp">
			<button class="btn btn-default">Cadastrar</button>
		</a>
	</div>

	<table class="clTblCliente">
		<tr>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Valor</th>
		</tr>

		<tr>
			<td>Tosa</td>
			<td>Tosa</td>
			<td>Tosa</td>
		</tr>						
	</table>

	<jsp:include page="/template/rodape_padrao.jsp"/>
</body>
</html>