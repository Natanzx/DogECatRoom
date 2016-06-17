<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% session.setAttribute("page", "Perfil");%>
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

			<!-- Nome -->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Nome</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text"
						placeholder="Digite o nome" class="form-control input-md" readonly>

				</div>
			<!-- CPF	-->
				<label class="col-md-1 control-label" for="textinput">CPF</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text"
						placeholder="Ex: 000000000-00" class="form-control input-md"
						required="" readonly>
				</div>
			</div>
			
			<!-- Tel Cel-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Tel. Celular</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text"
						placeholder="(00) XXXX-XXXX" class="form-control input-md"
						required="" readonly>
				</div>
			<!-- Tel Fixo-->
				<label class="col-md-2 control-label" for="textinput">Tel. Fixo</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text"
						placeholder="(XX) XXXX-XXXX" class="form-control input-md" readonly>
				</div>
			</div>

			<!-- Endereco -->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Endereço</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text"
						placeholder="Digite o endereço" class="form-control input-md" readonly>

				</div>
			<!-- Numero -->
				<label class="col-md-1 control-label" for="textinput">Número</label>
				<div class="col-md-1">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md" readonly>
				</div>
			</div>

			<!-- Complemento -->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Complemento</label>
				<div class="col-md-3">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md" readonly>
				</div>
			<!-- Bairro-->
				<label class="col-md-1 control-label" for="textinput">Bairro</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md" readonly>

				</div>
			</div>

			<!-- Cidade	-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Cidade</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md" readonly>

				</div>
			<!-- Estado	-->
				<label class="col-md-2 control-label" for="textinput">Estado</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md" readonly>

				</div>
			</div>

			<!-- Escolaridade -->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Escolaridade</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md" readonly>
				</div>
			<!-- Ocupação	-->
				<label class="col-md-1 control-label" for="textinput">Ocupação</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md" readonly>
				</div>
			</div>

			<!-- Salario	-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Salário</label>
				<div class="col-md-2">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-md" readonly>
				</div>
			</div>

			<!-- Button (Double) -->
			<div class="form-group">
				<label class="col-md-5 control-label" for="button1id"></label>
				<div class="col-md-6">
					<button id="button1id" name="button1id" class="btn btn-warning">Alterar</button>
				</div>
			</div>

		</fieldset>
	</form>

	<jsp:include page="/template/rodape_padrao.jsp" />
</body>
</html>