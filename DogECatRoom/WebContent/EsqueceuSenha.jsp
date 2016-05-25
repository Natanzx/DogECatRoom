<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/template/head.jsp" />
<title>DogECatRoom - Redefinir senha</title>
</head>
<body>
	<jsp:include page="/template/cabecalho.jsp" />

	<div class="divContent">
	
		<form class="form-horizontal" action="" method="post">
			<fieldset>
			
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">CPF</label>
					<div class="col-md-4">
						<input id="textinput" name="textinput" type="text" placeholder=""
							class="form-control input-sm" required="">
					</div>
				</div>		
			
				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-5 control-label" for="button1id"></label>
					<div class="col-md-2">
						<a href="login.jsp" target="">
							<button id="" name="" type="button" class="btn btn-warning">Recuperar</button>
						</a>
					</div>
				</div>
	
			</fieldset>
		</form>
	
	</div>
	<jsp:include page="/template/rodape.jsp" />
</body>
</html>