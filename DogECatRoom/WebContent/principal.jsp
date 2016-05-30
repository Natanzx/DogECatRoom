<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/template/head.jsp"/>
<title>DogECatRoom - Página Principal</title>
<style>
	.widget-left{
		padding-bottom: 10px;
	}
	.row{
		padding-left: 150px;
	}
</style>
</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp"/>
	<!--
	<div class="divMenu">
		 
		<a href="Sistemas/Agenda/consultarAgenda.jsp">
			<div>Agenda</div>
		</a>
		
		<a href="Sistemas/Clientes/consultarClientes.jsp">
			<div>Clientes</div>
		</a>
		
		<a href="Sistemas/Funcionarios/consultarFuncionarios.jsp">
			<div>Funcionarios</div>
		</a>
		
		<a href="Sistemas/Servicos/consultarServicos.jsp">
			<div>Servicos</div>
		</a>
		
		<a href="Sistemas/Relatorios/Relatorios.jsp">
			<div>Relatorios</div>
		</a>	 	
	</div>
	-->
	
	<div class="row">
		
		<a href="Sistemas/Agenda/consultarAgenda.jsp">	
			<div class="col-xs-12 col-md-6 col-lg-2">
				<div class="panel panel-orange panel-widget">
					<div class="col-sm-3 col-lg-11 widget-left">
						<i class="pe-7s-bookmarks clIcon"></i>
						<div>Agenda</div>
					</div>
				</div>
			</div>
		</a>

		<a href="ClienteController?acao=listar">
			<div class="col-xs-12 col-md-6 col-lg-2">
				<div class="panel panel-teal panel-widget">
					<div class="col-sm-3 col-lg-11 widget-left">
						<svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg>
						<div>Clientes</div>
					</div>
				</div>
			</div>
		</a>
		
		<a href="Sistemas/Funcionarios/consultarFuncionarios.jsp">							
			<div class="col-xs-12 col-md-6 col-lg-2">
				<div class="panel panel-blue panel-widget ">
					<div class="col-sm-3 col-lg-11 widget-left">
						<i class="pe-7s-users clIcon"></i>
						<div>Funcionários</div>
					</div>
				</div>
			</div>
		</a>
			
		<a href="Sistemas/Servicos/consultarServicos.jsp">	
			<div class="col-xs-12 col-md-6 col-lg-2">
				<div class="panel panel-red panel-widget">
					<div class="col-sm-3 col-lg-11 widget-left">
						<svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-clipboard-with-paper"></use></svg>
						<div>Serviços</div>
					</div>
				</div>
			</div>
		</a>
			
		<a href="Sistemas/Relatorios/Relatorios.jsp">
			<div class="col-xs-12 col-md-6 col-lg-2">
				<div class="panel panel-black panel-widget">
					<div class="col-sm-3 col-lg-11 widget-left">
						<svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-clipboard-with-paper"></use></svg>
						<div>Relatórios</div>
					</div>
				</div>
			</div>	
		</a>
							
		</div><!--/.row-->
		
	
	<jsp:include page="/template/rodape_padrao.jsp"/>
</body>