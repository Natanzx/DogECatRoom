<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/template/head.jsp" />
<title>DogECatRoom - Cadastrar Servicos</title>
</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp" />

	<form class="form-horizontal" action="/DogECatRoom/ServicoController?acao=cadastrar" method="POST">
		<fieldset>

			<!-- Form Name -->
			<legend>Servicos</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Nome</label>
				<div class="col-md-4">
					<input id="textinput" name="textNome" type="text"
						placeholder="Digite o nome" class="form-control input-md">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Descrição</label>
				<div class="col-md-4">
					<input id="textinput" name="textDescricao" type="text"
						placeholder="Informe a descrição" class="form-control input-md">
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Valor</label>
				<div class="col-md-4">
					<input id="textinput" name="textValor" type="text" placeholder=""
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