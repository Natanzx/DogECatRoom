<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% session.setAttribute("page", "Relatorios");%>
<%@page import="br.com.dogcatroom.dto.RelatoriosDTO" %>
<%@page import="java.sql.ResultSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/template/head.jsp" />
<title>DogECatRoom - Relatórios</title>
<%
	RelatoriosDTO rel = (RelatoriosDTO) request.getAttribute("relatorios");
	List<RelatoriosDTO> atendHor = (List<RelatoriosDTO>) request.getAttribute("horarios");
%>
<style>
	.divContent{
		padding: 0px;
		overflow:		auto;
	}
	.row{
		margin-right: 0px;
		margin-left: 0px;
	}
	#divResultado{
		max-height: 300px !important;
   		overflow: auto;
   		display: none;
	}
	
</style><!-- 
	<script src="/DogECatRoom/bibliotecas/js/chart.min.js"></script>
	<script src="/DogECatRoom/bibliotecas/js/chart-data.js"></script>
	
	<script src="/DogECatRoom/bibliotecas/js/easypiechart.js"></script>
	<script src="/DogECatRoom/bibliotecas/js/easypiechart-data.js"></script>
	 -->
	<script src="/DogECatRoom/bibliotecas/js/charts.js"></script>
	<script>
		$(document).ready(function(){
			
			//var ctx = $("#myChart");
			var ctx = document.getElementById("myChart");
			var labels = [];
			var data = [];
			$("[name=horarios]").each(function(index){
				labels[index] = $(this).attr('horario').substring(0,5);
				data[index] = $(this).val();
			});
			
			var myChart = new Chart(ctx, {
			    type: 'line',
			    data: {
			        labels: labels,
			        datasets: [{
			            label: 'Atendimentos',
			            data: data,
// 			            backgroundColor: [
// 			                'rgba(255, 99, 132, 0.2)',
// 			                'rgba(54, 162, 235, 0.2)',
// 			                'rgba(255, 206, 86, 0.2)',
// 			                'rgba(75, 192, 192, 0.2)',
// 			                'rgba(153, 102, 255, 0.2)'
// 			            ],
// 			            borderColor: [
// 			                'rgba(255,99,132,1)',
// 			                'rgba(54, 162, 235, 1)',
// 			                'rgba(255, 206, 86, 1)',
// 			                'rgba(75, 192, 192, 1)',
// 			                'rgba(153, 102, 255, 1)'
// 			            ],
			            borderWidth: 1
			        }]
			    },
			    options: {
			        scales: {
			            yAxes: [{
			                ticks: {
			                    beginAtZero:true
			                }
			            }]
			        }
			    }
			});	
			
			function resetActive(elem){
				$('#RelClientes, #RelServicos, #RelFuncionarios, #RelAtendimentos, #RelPrincipal').removeClass('active');
				$(elem).toggleClass('active');
			}
			
			$("#RelClientes").click(function(){
		        $.ajax({	            
		        	url: "/DogECatRoom/ClienteController",
		            data: {
		            	'acao': 'listar',
		            	'relatorios': '1'
		            },
		            type: 'GET',
		            success: function(result){
		            	resetActive($("#RelClientes"));
		            	$("#divGraficoRelatorio").hide();
		            	$("#divResultado").show('slow');
		            	$("#divResultado").html(result);
		            }
	        	});
			});
			
			$("#RelServicos").click(function(){
		        $.ajax({	            
		        	url: "/DogECatRoom/ServicoController",
		            data: {
		            	'acao': 'listar',
		            	'relatorios': '1'
		            },
		            type: 'GET',
		            success: function(result){
		            	resetActive($("#RelServicos"));
		            	$("#divGraficoRelatorio").hide();
		            	$("#divResultado").show('slow');
		            	$("#divResultado").html(result);
		            }
	        	});				
			});
			$("#RelFuncionarios").click(function(){
		        $.ajax({	            
		        	url: "/DogECatRoom/FuncionarioController",
		            data: {
		            	'acao': 'listar',
		            	'relatorios': '1'
		            },
		            type: 'GET',
		            success: function(result){
		            	resetActive($("#RelFuncionarios"));
		            	$("#divGraficoRelatorio").hide();
		            	$("#divResultado").show('slow');
		            	$("#divResultado").html(result);
		            }
	        	});
			});
			$("#RelAtendimentos").click(function(){
		        $.ajax({	            
		        	url: "/DogECatRoom/AtendimentoController",
		            data: {
		            	'acao': 'listar',
		            	'relatorios': '1'
		            },
		            type: 'GET',
		            success: function(result){
		            	resetActive($("#RelAtendimentos"));
		            	$("#divGraficoRelatorio").hide();
		            	$("#divResultado").show('slow');
		            	$("#divResultado").html(result);
		            }
	        	});
			});
			$("#RelPrincipal").click(function(){
				resetActive($("#RelPrincipal"));
	        	$("#divGraficoRelatorio").show('slow');
	        	$("#divResultado").hide();	
			});
		});
		
		
	</script>

</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp" />

	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				
			</div>
		</form>
		<ul class="nav menu">
			<li id="RelPrincipal" class="active">
				<a href="#divResultado" target="_parent">
					<svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg> 
					Relatórios
				</a>
			</li>
			
			<li id="RelClientes">
				<a href="#divResultado" target="_parent">
					<svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-male-user"></use></svg>
			 		Clientes
			 	</a>
			 </li>
			 
			<li id="RelServicos">
				<a href="#divResultado" target="_parent">
					<svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-clipboard-with-paper"></use></svg>
			 		Serviços
			 	</a>
			 </li>
			 
			<li id="RelFuncionarios">
				<a href="#divResultado" target="_parent">
					<svg class="glyph stroked dashboard dial"><use xlink:href="#stroked-dashboard-dial"/></svg>
			 		Funcionários
			 	</a>
			 </li>
			 
			<li id="RelAtendimentos">
				<a href="#divResultado" target="_parent">
					<svg class="glyph stroked dashboard dial"><use xlink:href="#stroked-dashboard-dial"/></svg>
			 		Atendimentos
			 	</a>
			 </li>
			<li role="presentation" class="divider"></li>
		</ul>

	</div>
	<!--/.sidebar-->
	
	<div class="content">
	
		<!-- Grafico	-->
		<div class="row">
			<div class="col-lg-9">
				<div class="panel panel-default">
					<div class="panel-heading">Relatórios de Vendas</div>
					<div class="panel-body">
						<div id="divGraficoRelatorio" class="canvas-wrapper">
							<!-- <canvas class="main-chart" id="line-chart" height="200" width="600"></canvas> -->
							<canvas class="main-chart" id="myChart" height="200" width="600"></canvas>
							
						</div>
						<div id="divResultado"></div>
					</div>
				</div>
			</div>
		</div><!--/.row-->	

		<!-- Lista Procentagem	
		<div class="row">
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>New Orders</h4>
						<div class="easypiechart" id="easypiechart-blue" data-percent="92" ><span class="percent">92%</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>Comments</h4>
						<div class="easypiechart" id="easypiechart-orange" data-percent="65" ><span class="percent">65%</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>New Users</h4>
						<div class="easypiechart" id="easypiechart-teal" data-percent="56" ><span class="percent">56%</span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 col-md-3">
				<div class="panel panel-default">
					<div class="panel-body easypiechart-panel">
						<h4>Visitors</h4>
						<div class="easypiechart" id="easypiechart-red" data-percent="27" ><span class="percent">27%</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		-->
		
		
		<!-- Lista quadrados Numeros	-->
		<div class="row">
			<div class="panel-heading">Relatório Quantitativo</div>
			
			<div class="col-xs-12 col-md-6 col-lg-3">
				<div class="panel panel-blue panel-widget ">
					<div class="row no-padding">
						<div class="col-sm-3 col-lg-5 widget-left">
							<svg class="glyph stroked bag"><use xlink:href="#stroked-bag"></use></svg>
						</div>
						<div class="col-sm-9 col-lg-7 widget-right">
							<div class="large"><%=rel.getCountClientes() %></div>
							<div class="text-muted">Clientes</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-6 col-lg-3">
				<div class="panel panel-orange panel-widget">
					<div class="row no-padding">
						<div class="col-sm-3 col-lg-5 widget-left">
							<svg class="glyph stroked empty-message"><use xlink:href="#stroked-empty-message"></use></svg>
						</div>
						<div class="col-sm-9 col-lg-7 widget-right">
							<div class="large"><%=rel.getCountServicos() %></div>
							<div class="text-muted">Servicos</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-6 col-lg-3">
				<div class="panel panel-teal panel-widget">
					<div class="row no-padding">
						<div class="col-sm-3 col-lg-5 widget-left">
							<svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg>
						</div>
						<div class="col-sm-9 col-lg-7 widget-right">
							<div class="large"><%=rel.getCountFuncionarios() %></div>
							<div class="text-muted">Funcionarios</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-md-6 col-lg-3">
				<div class="panel panel-red panel-widget">
					<div class="row no-padding">
						<div class="col-sm-3 col-lg-5 widget-left">
							<svg class="glyph stroked app-window-with-content"><use xlink:href="#stroked-app-window-with-content"></use></svg>
						</div>
						<div class="col-sm-9 col-lg-7 widget-right">
							<div class="large"><%=rel.getCountAtendimentos() %></div>
							<div class="text-muted">Atendimentos</div>
						</div>
					</div>
				</div>
			</div>
		</div><!--/.row-->
	</div><!--/.content-->

	<%
	int i = 1;
	for(RelatoriosDTO h : atendHor){
	%>
		<input type="hidden" name="horarios" horario="<%=h.getHorarios()%>" value="<%=h.getCountHorarios()%>">
	<%
		i++;
	};
	%>

	<jsp:include page="/template/rodape_padrao.jsp" />
</body>
</html>