<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/template/head.jsp"/>
<title>DogECatRoom - Página Principal</title>
</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp"/>
	
	<div class="divMenu">
		<a href="Agenda/consultaAgenda.jsp">
			<div>Agenda</div>
		</a>
		
		<a href="Cliente/consultaCliente.jsp">
			<div>Clientes</div>
		</a>
		
		<a href="Funcionario/consultaFuncionario.jsp">
			<div>Funcionarios</div>
		</a>
		
		<a href="Servicos/consultaServico.jsp">
			<div>Servicos</div>
		</a>
		
		<a href="#">
			<div>Relatorios</div>
		</a>
	</div>
	
	<jsp:include page="/template/rodape_padrao.jsp"/>
</body>