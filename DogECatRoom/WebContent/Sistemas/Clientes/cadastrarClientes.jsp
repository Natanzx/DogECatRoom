<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/template/head.jsp" />
<title>DogECatRoom - Cadastrar Clientes</title>
</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp" />

	<form class="form-horizontal">
		<fieldset>

			<!-- Titulo - Clientes -->
			<legend>Clientes</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Nome</label>
				<div class="col-md-5">
					<input id="textinput" name="textinput" type="text"
						placeholder="Digite o nome" class="form-control input-md">

				</div>
			</div>

			<!-- CPF	-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">CPF</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text"
						placeholder="Ex: 000000000-00" class="form-control input-md"
						required=""> 
				</div>
			</div>
			
			<!-- Telefone Cel-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Tel. Celular</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text"
						placeholder="(00) XXXX-XXXX" class="form-control input-md"
						required="">

				</div>
			<!-- Telefone Fixo-->
				<label class="col-md-1 control-label" for="textinput">Tel. Fixo</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text"
						placeholder="(XX) XXXX-XXXX" class="form-control input-md">

				</div>
			</div>

			<!-- Endere�o	-->	
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Endere�o</label>
				<div class="col-md-3">
					<input id="textinput" name="textinput" type="text"
						placeholder="Digite o endere�o" class="form-control input-md">

				</div>
				<!-- Numero	-->
				<label class="col-md-1 control-label" for="textinput">N�mero</label>
				<div class="col-md-1">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>

			<!-- Complemento -->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Complemento</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			<!-- Bairro	-->
				<label class="col-md-1 control-label" for="textinput">Bairro</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>
			
			<div class="form-group">
			<!-- Cidade -->
				<label class="col-md-3 control-label" for="textinput">Cidade</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			<!-- Estado -->
				<label class="col-md-1 control-label" for="textinput">Estado</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>
		</fieldset>
		
		<fieldset>
			<!-- Titulo - Animais -->
			<legend>Animal</legend>
		
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Nome Pet</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
				
				<label class="col-md-1 control-label" for="textinput">Tipo</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Raca</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
				
				<label class="col-md-1 control-label" for="textinput">Cor</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Data Nascimento</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
				
				<label class="col-md-1 control-label" for="textinput">Sexo</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Pedigre</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
				
				<label class="col-md-1 control-label" for="textinput">N� Pedigre</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>																	
			
						<!-- Button (Double) -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="button1id"></label>
				<div class="col-md-8">
					<button id="button1id" name="button1id" class="btn btn-success">Enviar</button>
					<button id="" name="" class="btn btn-danger">Limpar</button>
				</div>
			</div>
		</fieldset>		
	</form>

	<jsp:include page="/template/rodape_padrao.jsp" />
</body>
</html>