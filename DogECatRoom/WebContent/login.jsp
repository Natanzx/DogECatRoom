<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/template/head.jsp" />
<style>
	.divContent{
		padding-top: 50px;
	}
</style>
<title>DogECatRoom - Login</title>
</head>
<body>
	<jsp:include page="/template/cabecalho.jsp" />
	
	<div class="divContent">
	
	<form class="form-horizontal" action="/DogECatRoom/FuncionarioController?acao=autenticar" method="POST">
		<fieldset>
		
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Login</label>
				<div class="col-md-4">
					<input id="textinput" name="login" type="text" placeholder=""
						class="form-control input-sm" required="">

				</div>
			</div>		
		
			<!-- Password input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="passwordinput">Senha</label>
				<div class="col-md-4">
					<input id="passwordinput" name="senha" type="password"
						placeholder="" class="form-control input-md" required="">

				</div>
			</div>

			<!-- Button (Double) -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="button1id"></label>
				<div class="col-md-8">
					<button id="button1id" type="submit" name="button1id" class="btn btn-success">Logar</button>
					<a href="EsqueceuSenha.jsp" target="">
						<button id="" name="" type="button" class="btn btn-warning">Esqueceu a senha</button>
					</a>
				</div>
			</div>

		</fieldset>
	</form>
	</div>

	<jsp:include page="/template/rodape.jsp" />
</body>