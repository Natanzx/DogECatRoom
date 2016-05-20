<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/template/head.jsp" />
<title>DogECatRoom - Login</title>
</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp" />

	<form class="form-horizontal" action="principal.jsp">
		<fieldset>
		
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="textinput">Login</label>
				<div class="col-md-4">
					<input id="textinput" name="textinput" type="text" placeholder=""
						class="form-control input-sm" required="">

				</div>
			</div>		
		
			<!-- Password input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="passwordinput">Senha</label>
				<div class="col-md-4">
					<input id="passwordinput" name="passwordinput" type="password"
						placeholder="" class="form-control input-md" required="">

				</div>
			</div>

			<!-- Button (Double) -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="button1id"></label>
				<div class="col-md-8">
					<button id="button1id" name="button1id" class="btn btn-success">Logar</button>
					<button id="" name="" class="btn btn-warning">Esqueceu a
						senha</button>
				</div>
			</div>

		</fieldset>
	</form>



	<jsp:include page="/template/rodape_padrao.jsp" />
</body>