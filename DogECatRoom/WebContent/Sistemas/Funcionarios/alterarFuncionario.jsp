<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.com.dogcatroom.dto.FuncionarioDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/template/head.jsp" />
<title>DogECatRoom - Cadastrar Clientes</title>
</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp" />
	<%
	FuncionarioDTO funcionarioDTO = (FuncionarioDTO) request.getAttribute("funcionario");
	%>
	<form class="form-horizontal" method="POST" action="FuncionarioController?acao=alterar">
		<fieldset>
			
			<!-- Titulo - Clientes -->
			<legend>Funcionários</legend>
			<input type="hidden" name="id" value="<%=funcionarioDTO.getId()%>"/>
			<!-- Text input-->
			<div class="form-group">

				<!-- Nome -->
				<label class="col-md-3 control-label" for="textinput">Nome</label>
				<div class="col-md-5">
					<input id="textinput" name="nomeFuncionario" type="text"
						placeholder="Digite o nome" class="form-control input-md"
						value=<%=funcionarioDTO.getNome() %>>

				</div>
				<!-- CPF	-->
				<label class="col-md-1 control-label" for="textinput">CPF</label>
				<div class="col-md-2">
					<input id="textinput" name="numeroCPF" type="text"
						placeholder="Ex: 000000000-00" class="form-control input-md"
						value=<%= funcionarioDTO.getCpf()%>>
				</div>
			</div>

			<!-- Tel Cel-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Tel.Celular</label>
				<div class="col-md-3">
					<input id="textinput" name="telCelular" type="text"
						placeholder="(00) XXXX-XXXX" class="form-control input-md"
						value=<%=funcionarioDTO.getTelCelular() %>>
				</div>
				<!-- Tel Fixo-->
				<label class="col-md-2 control-label" for="textinput">Tel.
					Fixo</label>
				<div class="col-md-2">
					<input id="textinput" name="telFixo" type="text"
						placeholder="(XX) XXXX-XXXX" class="form-control input-md"
						value="<%= funcionarioDTO.getTelFixo() %>">
				</div>
			</div>

			<!-- Endereco -->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Endereço</label>
				<div class="col-md-4">
					<input id="textinput" name="enderecoFuncionario" type="text"
						placeholder="Digite o endereço" class="form-control input-md" value="<%= funcionarioDTO.getEndereco() %>">

				</div>
				<!-- Numero -->
				<label class="col-md-1 control-label" for="textinput">Número</label>
				<div class="col-md-1">
					<input id="textinput" name="numeroFuncionario" type="text"
						class="form-control input-md" value="<%= funcionarioDTO.getNumero()%>">
				</div>
			</div>

			<!-- Complemento -->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Complemento</label>
				<div class="col-md-4">
					<input id="textinput" name="complementoFuncionario" type="text"
						 class="form-control input-md" value="<%= funcionarioDTO.getComplemento() %>">
				</div>
				<!-- Bairro-->
				<label class="col-md-1 control-label" for="textinput">Bairro</label>
				<div class="col-md-2">
					<input id="textinput" name="bairroFuncionario" type="text"
						 class="form-control input-md" value="<%= funcionarioDTO.getBairro()%>">

				</div>
			</div>

			<!-- Cidade	-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Cidade</label>
				<div class="col-md-3">
					<input id="textinput" name="cidadeFuncionario" type="text"
						 class="form-control input-md" value="<%= funcionarioDTO.getCidade() %>">

				</div>
				<!-- Estado	-->
				<label class="col-md-2 control-label" for="textinput">Estado</label>
				<div class="col-md-2">
					<input id="textinput" name="estadoFuncionario" type="text"
						 class="form-control input-md" value="<%= funcionarioDTO.getEstado() %>">

				</div>
			</div>

			<!-- Escolaridade -->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Escolaridade</label>
				<div class="col-md-2">
					<input id="textinput" name="escolaridadeFuncionario" type="text"
						 class="form-control input-md" value="<%= funcionarioDTO.getEscolaridade()%>">
				</div>
				<!-- Ocupação	-->
				<label class="col-md-3 control-label" for="textinput">Ocupação</label>
				<div class="col-md-2">
					<input id="textinput" name="ocupacaoFuncionario" type="text"
					 class="form-control input-md" value="<%=funcionarioDTO.getOcupacao() %>">
				</div>
			</div>

			<!-- Salario	-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Salário</label>
				<div class="col-md-2">
					<input id="textinput" name="salarioFuncionario" type="text"
						class="form-control input-md" value="<%= funcionarioDTO.getSalario()%>">
				</div>
				<label class="col-md-3 control-label" for="textinput">Matrícula</label>
				<div class="col-md-2">
					<input id="textinput" name="matriculaFuncionario" type="text"
					 class="form-control input-md" value="<%=funcionarioDTO.getMatricula() %>">
				</div>
			</div>
			
			<!-- Login	-->
			<div class="form-group">
				<label class="col-md-3 control-label" for="textinput">Login</label>
				<div class="col-md-2">
					<input id="textinput" name="loginFuncionario" type="text"
						class="form-control input-md" value="<%=funcionarioDTO.getLogin() %>">
				</div>
				<label class="col-md-3 control-label" for="button1id"></label>
				<div class="col-md-1">
					<button id="" name="" class="btn btn-defult"  onclick= href="FuncionarioController?acao=alterar&id=<%out.print(funcionarioDTO.getId());%>">Trocar Senha</button>
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