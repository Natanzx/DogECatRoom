<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="br.com.dogcatroom.dto.AnimalDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/template/head.jsp" />
<title>DogECatRoom - Cadastrar Clientes</title>

	<script src="/DogECatRoom/bibliotecas/js/jquery.validate.min.js"></script>

	<script>
	
		function listaAnimaisCliente(){
	
	        $.ajax({	            
	            url: "/DogECatRoom/AnimalController?acao=listAnimaisTemp",
	            type: 'GET',
	            success: function(result){
	            	$("#divConsultaAnimal").html(result);	
	            }
	    	});				
		}
		
		$(document).ready(function(){
			var countAnimal = 0;
			
	      	$("#btnCancelarCadAnimal").click(function(){
	      		$("#divCadastraAnimal").hide();
	      	});
	      	
	        $("#btnCadastrarAnimal").click(function(){
	        	++countAnimal;
	        	var pedigreAnimal;
				if($("#pedigreAnimal").is(':checked')){
					pedigreAnimal = 1;
				}else{
					pedigreAnimal = 0;
				}

		        $.ajax({	            
		            url: "/DogECatRoom/AnimalController?acao=cadastrarTemp",
		            data: {
		            	'id': countAnimal,
		            	'nome': $("#nomeAnimal").val(),
		            	'tipo': $("#tipoAnimal").val(),
		            	'raca': $("#racaAnimal").val(),
		            	'cor': $("#corAnimal").val(),
		            	'dataNasc': $("#dataNascAnimal").val(),
		            	'sexo': $("#sexo").val(),
		            	'pedigre': pedigreAnimal,
		            	'numPedigre': $("#numPedigreAnimal").val()
		            },
		            type: 'POST',
		            success: function(){
		            	listaAnimaisCliente();
		            	$("#divCadastraAnimal").hide();
		            }
	        	});	
	        });		
	        
			$("#btnDeleteAnimalTemp").click(function(){
				//listaAnimaisClienteTemp();
				
				$.ajax({	            
			    	url: "/DogECatRoom/AnimalController",
			        data: {
			        	'acao':'deletarAnimalTemp',
			        	'idAnimal': idAnimal
			        },
			        type: 'GET',
			        success: function(result){
			        	listaAnimaisCliente();
			        }
				});
			});
	        
	        $("#btnAddAnimal").click(function(){
	        	$('#form-cliente')[0].reset();
	        	$("#divCadastraAnimal").show();
	        });
			
		});
	
	</script>

</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp" />
	
	<form class="form-horizontal" id="form-cliente" method="POST" action="/DogECatRoom/ClienteController?acao=cadastrar" data-toggle="validator" role="form">
		<fieldset>

			<!-- Titulo - Clientes -->
			<legend>Clientes</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Nome</label>
				<div class="col-md-5">
					<input id="textinput" name="textNome" type="text"
						placeholder="Digite o nome" class="form-control input-md" pattern="^[a-zA-Z\s]+$" required>
					<div class="help-block with-errors"></div>	
				</div>
			</div>

			<!-- CPF	-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">CPF</label>
				<div class="col-md-2">
					<input id="textinput" name="textCpf" type="text"
						placeholder="Ex: 000000000-00" class="form-control input-md"
						required="" maxlength="11" min="11"> 
					<div class="help-block with-errors"></div>					
				</div>
			</div>
			
			<!-- Telefone Cel-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Tel. Celular</label>
				<div class="col-md-2">
					<input id="textinput" name="textTelCelular" type="text"
						placeholder="(00) XXXX-XXXX" class="form-control input-md"
						required="" pattern="\b\d{4}[-]?\d{4}\b" maxlength="12">
						<div class="help-block with-errors"></div>
				</div>
			<!-- Telefone Fixo-->
				<label class="col-md-1 control-label" for="textinput">Tel. Fixo</label>
				<div class="col-md-2">
					<input id="textinput" name="textTelFixo" type="text"
						placeholder="(XX) XXXX-XXXX" class="form-control input-md" pattern="\b\d{4}[-]?\d{4}\b" maxlength="12">
						<div class="help-block with-errors"></div>
				</div>
			</div>

			<!-- Endereço	-->	
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Endereço</label>
				<div class="col-md-3">
					<input id="textinput" name="textEndereco" type="text"
						placeholder="Digite o endereço" class="form-control input-md" maxlength="30">

				</div>
				<!-- Numero	-->
				<label class="col-md-1 control-label" for="textinput">Número</label>
				<div class="col-md-1">
					<input id="textinput" name="textNumero" type="number" placeholder=""
						class="form-control input-md" maxlength="3">

				</div>
			</div>

			<!-- Complemento -->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Complemento</label>
				<div class="col-md-2">
					<input id="textinput" name="textComplemento" type="text" placeholder=""
						class="form-control input-md" maxlength="40">

				</div>
			<!-- Bairro	-->
				<label class="col-md-1 control-label" for="textinput">Bairro</label>
				<div class="col-md-2">
					<input id="textinput" name="textBairro" type="text" placeholder=""
						class="form-control input-md" maxlength="20">

				</div>
			</div>
			
			<div class="form-group">
			<!-- Cidade -->
				<label class="col-md-3 control-label" for="textinput">Cidade</label>
				<div class="col-md-2">
					<input id="textinput" name="textCidade" type="text" placeholder=""
						class="form-control input-md" pattern="^[a-zA-Z\s]+$" maxlength="20">

				</div>
			<!-- Estado -->
				<label class="col-md-1 control-label" for="textinput">Estado</label>
				<div class="col-md-2">
					<input id="textinput" name="textEstado" type="text" placeholder=""
						class="form-control input-md" pattern="^[a-zA-Z\s]+$" maxlength="20">

				</div>
			<!-- CEP -->
				<label class="col-md-1 control-label" for="textinput">Cep</label>
				<div class="col-md-2">
					<input id="textCep" name="textCep" type="text" placeholder=""
						class="form-control input-md" maxlength="9">

				</div>
			</div>
		</fieldset>
		
		<fieldset>
			<!-- Titulo - Animais -->

			<div id="divConsultaAnimal" style="padding: 0px 0px 40px">
			
			</div>
			
			<legend>
				Animal 
				<button id="btnAddAnimal" type="button" class="btn btn-xs btn-warning">Adicionar</button>
				
			</legend>
						
			<div id="divCadastraAnimal">

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-3 control-label" for="textinput">Nome Pet</label>
					<div class="col-md-2">
						<input id="nomeAnimal" type="text" placeholder=""
							class="form-control input-md" pattern="^[a-zA-Z\s]+$" maxlength="30">
			
					</div>
					
					<label class="col-md-1 control-label" for="textinput">Tipo</label>
					<div class="col-md-2">
						<input id="tipoAnimal" type="text" placeholder=""
							class="form-control input-md" pattern="^[a-zA-Z\s]+$" maxlength="20">
			
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-3 control-label" for="textinput">Raca</label>
					<div class="col-md-2">
						<input id="racaAnimal" type="text" placeholder=""
							class="form-control input-md" maxlength="20">
			
					</div>
					
					<label class="col-md-1 control-label" for="textinput">Cor</label>
					<div class="col-md-2">
						<input id="corAnimal" type="text" placeholder=""
							class="form-control input-md" pattern="^[a-zA-Z\s]+$" maxlength="20">
			
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label" for="textinput">Data Nascimento</label>
					<div class="col-md-2">
						<input id="dataNascAnimal" type="date" placeholder=""
							class="form-control input-md" maxlength="8">
			
					</div>
					
					<label class="col-md-1 control-label" for="textinput">Sexo</label>
					<div class="col-md-2">
						<input id="sexo" type="text" placeholder="M/F"
							class="form-control input-md" maxlength="1">
			
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label" for="textinput">Pedigre</label>
					<div class="col-md-2">
						<input id="pedigreAnimal" type="checkbox" placeholder=""
							class="form-control input-md" maxlength="1">
			
					</div>
					
					<label class="col-md-1 control-label" for="textinput">N° Pedigre</label>
					<div class="col-md-2">
						<input id="numPedigreAnimal" type="text" placeholder=""
							class="form-control input-md" maxlength="8">
			
					</div>
				</div>																	
			
				<div class="form-group">
					<label class="col-md-4 control-label" for="button1id"></label>
					<div class="col-md-8">
						<button type="button" type="button" id="btnCadastrarAnimal" name="button1id" class="btn btn-success">
							Adicionar Pet
						</button>
						<button type="button" type="button" id="btnCancelarCadAnimal" name="button1id" class="btn btn-danger">
							Cancelar
						</button>						
					</div>
				</div>
			
			
			</div>
			
		</fieldset>		
	
	<hr>
	
	<!-- Button (Double) -->
	<div class="form-group">
		<label class="col-md-4 control-label" for="button1id"></label>
		<div class="col-md-8">
			<button id="button1id" type="submit" name="button1id" class="btn btn-primary">Enviar</button>
			<button id="" name="" type="reset" class="btn btn-warning">Limpar</button>
		</div>
	</div>	
	</form>

	<jsp:include page="/template/rodape_padrao.jsp" />
</body>

</html>