<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<a href="cadastrarClientes.jsp">
			<button class="btn btn-default">Cadastrar</button>
		</a>
	</div>
	
	<table class="clTblCliente">
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
			<th>Animal</th>
		</tr>

		<tr>
			<td>Natanael Dias</td>
			<td>12344422109</td>
			<td>73340307</td>
			<td>Sudoeste Quadra CSW 40</td>
			<td>03</td>
			<td>Rua abaixo</td>
			<td>Asa Sul</td>
			<td>Brasilia</td>
			<td>Distrito Federal</td>
			<td>61 93224411</td>
			<td>61 91334422</td>
			<td>Cachorro</td>
		</tr>						
	</table>

	<jsp:include page="/template/rodape_padrao.jsp"/>
</body>
</html>