<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BSB PET</title>
</head>
<body >
<p align="right" style="font-size: 13px;">
	você está logado como: <%=session.getAttribute("usuario") %><br>
	<a href="Logar.jsp">Fazer logout</a>
</p>
	<h2>Bem vindo <%=session.getAttribute("usuario") %>!</h2>
		<h4>Selecione uma opção:</h4>
		<form>
			<table cellpadding=4 style="font-family:"Arial, Helvetica, sans-serif;">
				<tr>
					<td align="center" colspan=5><h3><a href="OrcamentoController?acao=venda">Realizar venda</a></h3></td>
				</tr>
				<tr align="center" style="background:#2b3e8c; color:#FFF;">
					<th colspan=2>Clientes</th>
					<th colspan=2>Servico</th>
					<th>Relatorio</th>
				</tr>
				<tr style="background:#e0e0e0;">
					<td>
						<a href="ClienteCadastro.jsp">Cadastrar Cliente</a>
					</td>
					<td>
						<a href="ClienteController?acao=listar">Listar Clientes/Alterar/Excluir</a>
					</td>
					<td><a href="ServicoCadastro.jsp">Cadastrar Servico</a></td>
					<td><a href="ServicoController?acao=listar">Listar Servico/Alterar/Excluir</a></td>
					<td><a href="OrcamentoController?acao=listar">Visualizar vendas</a>
				</tr>
			</table>	
		</form>
</body>
</html>