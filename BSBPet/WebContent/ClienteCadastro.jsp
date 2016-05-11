<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="br.upis.Cliente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Cliente</title>
</head>
<body>
<br>
<br>
	<form action="ClienteController" method="post">
		<table bgcolor="#e0e0e0" align="center" style="border:1px solid #000; padding:10px; font-family:Arial, Helvetica, sans-serif;">
			<tr>
				<td colspan="2" align="center" ><h3>Cadastro do Cliente</h3></td>
			</tr>
			<tr>
				<td align="right">Nome:</td><td><input type="text" name="txtnome" value=""/></td>
			</tr>
			<tr>
				<td align="right">Telefone:</td><td><input type="text" name="txttelefone" value="" maxlength="8"/></td>
			</tr>
			<tr>
				<td align="right">CPF:</td><td><input type="text" name="txtcpf" value="" maxlength="11"/></td>
			</tr>
			<tr>
				<td align="right">Endereco:</td><td><input type="text" name="txtendereco" value=""/></td>
			</tr>
			<tr>
				<td align="right">Animal:</td><td><input type="text" name="txtanimal" value=""/></td>
			</tr>
			<tr>
				<br>
				<td align='center'><br><a href="Inicio.jsp">Voltar</a></td><td align="center"><input type="submit" value="Cadastrar"/></td>
			</tr>
		</table>
	</form>

</body>
</html>