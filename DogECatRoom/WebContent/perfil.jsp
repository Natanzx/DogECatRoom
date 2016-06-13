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

			<!-- Nome -->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Nome</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text"
						placeholder="Digite o nome" class="form-control input-md" >

				</div>
			</div>	
				
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Loguin</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text"
						placeholder="Digite o loguin" class="form-control input-md" >

				</div>
			</div>
			
			<div class="form-group">	
				<label class="col-md-3 control-label" for="textinput">Senha</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text"
						placeholder="Digite a senha" class="form-control input-md" >

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