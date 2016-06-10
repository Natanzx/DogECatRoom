<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.com.dogcatroom.dto.ClienteDTO" %>
<%
	ClienteDTO cliente =(ClienteDTO) request.getAttribute("cliente");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/template/head.jsp" />
<title>DogECatRoom - Cadastrar Clientes</title>

</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp" />

	<form class="form-horizontal" method="POST" action="ClienteController?acao=alterar">
		<fieldset>
			
			<!-- Titulo - Clientes -->
			<legend>Clientes</legend>
			<input type="hidden" name="textId" value="<%=cliente.getId()%>"/>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Nome</label>
				<div class="col-md-5">
					<input id="textinput" name="textNome" type="text"
						placeholder="Digite o nome" class="form-control input-md" value=<%=cliente.getNome() %>>

				</div>
			</div>

			<!-- CPF	-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">CPF</label>
				<div class="col-md-2">
					<input id="textinput" name="textCpf" type="text"
						placeholder="Ex: 000000000-00" class="form-control input-md"
						required="" value=<%=cliente.getCpf() %>> 
				</div>
			</div>
			
			<!-- Telefone Cel-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Tel. Celular</label>
				<div class="col-md-2">
					<input id="textinput" name="textTelCelular" type="text"
						placeholder="(00) XXXX-XXXX" class="form-control input-md"
						required="" value=<%=cliente.getTelCelular() %>>

				</div>
			<!-- Telefone Fixo-->
				<label class="col-md-1 control-label" for="textinput">Tel. Fixo</label>
				<div class="col-md-2">
					<input id="textinput" name="textTelFixo" type="text"
						placeholder="(XX) XXXX-XXXX" class="form-control input-md" value=<%=cliente.getTelFixo() %>>

				</div>
			</div>

			<!-- Endereço	-->	
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Endereço</label>
				<div class="col-md-3">
					<input id="textinput" name="textEndereco" type="text"
						placeholder="Digite o endereço" class="form-control input-md" value=<%=cliente.getEndereco() %>>

				</div>
				<!-- Numero	-->
				<label class="col-md-1 control-label" for="textinput">Número</label>
				<div class="col-md-1">
					<input id="textinput" name="textNumero" type="text" placeholder=""
						class="form-control input-md" value=<%=cliente.getNumero() %>>

				</div>
			</div>

			<!-- Complemento -->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Complemento</label>
				<div class="col-md-2">
					<input id="textinput" name="textComplemento" type="text" placeholder=""
						class="form-control input-md" value=<%=cliente.getComplemento() %>>

				</div>
			<!-- Bairro	-->
				<label class="col-md-1 control-label" for="textinput">Bairro</label>
				<div class="col-md-2">
					<input id="textinput" name="textBairro" type="text" placeholder=""
						class="form-control input-md" value=<%=cliente.getBairro() %>>

				</div>
			</div>
			
			<div class="form-group">
			<!-- Cidade -->
				<label class="col-md-3 control-label" for="textinput">Cidade</label>
				<div class="col-md-2">
					<input id="textinput" name="textCidade" type="text" placeholder=""
						class="form-control input-md" value=<%=cliente.getCidade() %>>

				</div>
			<!-- Estado -->
				<label class="col-md-1 control-label" for="textinput">Estado</label>
				<div class="col-md-2">
					<input id="textinput" name="textEstado" type="text" placeholder=""
						class="form-control input-md" value=<%=cliente.getEstado() %>>

				</div>
			<!-- CEP -->
				<label class="col-md-1 control-label" for="textinput">Cep</label>
				<div class="col-md-2">
					<input id="textCep" name="textCep" type="text" placeholder=""
						class="form-control input-md" value=<%=cliente.getCep() %>>

				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Ativo</label>
				<div class="col-md-2" name="estadoCliente">
					<select class="form-control" name="estadoCliente">
						<option value="1">Ativo</option>
						<option value="0">Inativo</option>
					</select>
				</div>
			</div>
		</fieldset>
		
		<fieldset>
			<!-- Titulo - Animais -->

			<legend>
				Animal
				<button id="btnAddAnimal" type="button" class="btn btn-xs btn-warning">Adicionar</button>
			</legend>
			
			<div id="divResultadoAnimal" style="padding: 0px 0px 40px">
			</div>		
																	
			<!-- Button (Double) -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="button1id"></label>
				<div class="col-md-8">
					<input type="hidden" id="idCliente" value="<%=cliente.getId() %>">
					<button id="button1id" name="button1id" class="btn btn-success">Enviar</button>
					<button id="" name="" class="btn btn-danger">Limpar</button>
				</div>
			</div>
		</fieldset>		
	</form>

	<jsp:include page="/template/rodape_padrao.jsp" />
</body>
<script>	
	
		$(document).ready(function(){
		
			var idCliente = $("#idCliente").val();
			
			listaAnimaisCliente();
			
			function listaAnimaisCliente(){
				$.ajax({	            
		            url: "/DogECatRoom/AnimalController",
		            data: {
		            	'acao': 'listar',
		            	'idCliente': idCliente
		            },
		            type: 'GET',
		            success: function(result){
		                $("#divResultadoAnimal").html(result);
		            }
	        	});	
			}
	        
	        $("#btnAddAnimal").click(function(){
		        $.ajax({	            
		        	url: "/DogECatRoom/AnimalController",
		            data: {
		            	'acao': 'cadastro',
		            	'idCliente': idCliente
		            },
		            type: 'GET',
		            success: function(result){
		                $("#divResultadoAnimal").html(result);
		            }
	        	});	        	
	        	
	        });
	        
        });
	</script>	
</html>