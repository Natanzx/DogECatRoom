<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.dogcatroom.dto.FuncionarioDTO" %>
<% FuncionarioDTO func = (FuncionarioDTO) request.getAttribute("funcionario"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/template/head.jsp" />
<title>DogECatRoom - Dados</title>
</head>
<body>
	<jsp:include page="/template/cabecalho.jsp" />

	<div class="divContent">
			
		<form class="form-horizontal">
			<fieldset>
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Login</label>
					<div class="col-md-4">
						<input id="textinput" name="FuncionarioLogin" type="text" placeholder=""
							class="form-control input-sm" required="" value="<%=func.getLogin() %>">
					</div>
				</div>	
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Senha</label>
					<div class="col-md-4">
						<input id="textinput" name="FuncionarioCPF" type="text" placeholder=""
							class="form-control input-sm" required="" value="<%=func.getSenha() %>">
					</div>
				</div>			
				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-5 control-label" for="button1id"></label>
					<div class="col-md-2">
						<a href="login.jsp" target="">
							<button id="" name="" type="button" class="btn btn-success">Voltar</button>
						</a>
					</div>
				</div>
	
			</fieldset>
		</form>
	
	</div>
	<jsp:include page="/template/rodape.jsp" />
</body>
</html>