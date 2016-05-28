<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/template/head.jsp" />
<title>DogECatRoom - Perfil</title>
</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp" />

	<form class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>Perfil</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Nome</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text"
						placeholder="" class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">CPF</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text"
						placeholder="" class="form-control input-md"
						required="">
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Endereço</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text"
						placeholder="" class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Número</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Complemento</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Bairro</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Cidade</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Estado</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Telefone
					Celular</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text"
						placeholder="" class="form-control input-md"
						required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Telefone
					Fixo</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text"
						placeholder="" class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Escolaridade</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Ocupação</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Salário</label>
				<div class="col-md-4">
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