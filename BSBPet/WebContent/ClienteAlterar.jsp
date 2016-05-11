<%@page import="jdk.nashorn.internal.ir.RuntimeNode.Request"%>
<%@page import="com.sun.corba.se.impl.corba.RequestImpl"%>
<%@page import="org.apache.coyote.RequestGroupInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="br.upis.Cliente" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Cliente</title>
</head>
<body>
<%
Cliente cliente =(Cliente) request.getAttribute("cliente");
%>
<br>
<br>
	<form action="ClienteController" method="post">
		<table bgcolor="#e0e0e0" align="center" style="width: 250px; border:1px solid #000; padding:10px; font-family:Arial, Helvetica, sans-serif;">
			<tr>
				<td colspan="2" align="center" ><h3>Alterar dados do Cliente</h3></td>
			</tr>
			<tr>
				<td align="right">Matricula:</td>
				<td><input type="text" name="txtid" value="<%=cliente.getId()%>"/></td>
			</tr>
			<tr>
				<td align="right">Nome:</td>
				<td><input type="text" name="txtnome" value="<%=cliente.getNome() %>"/></td>
			</tr>
			<tr>
				<td align="right">Telefone:</td>
				<td><input type="text" name="txttelefone" value="<%=cliente.getTelefone() %>" maxlength="8"/></td>
			</tr>
			<tr>
				<td align="right">CPF:</td>
				<td><input type="text" name="txtcpf" value="<%=cliente.getCpf() %>" maxlength="11"/></td>
			</tr>
			<tr>
				<td align="right">Endereço:</td>
				<td><input type="text" name="txtendereco" value="<%=cliente.getEndereco() %>"/></td>
			</tr>
			<tr>
				<td align="right">Pet</td>
				<td><input type="text" name="txtanimal" value="<%=cliente.getAnimal() %>"/></td>
			<tr>
			<tr>
				<td align='center'><br><a href="ClienteController?acao=listar">Voltar</a></td>
				<td align="center"><input type="submit" value="Atualizar"/></td>
			</tr>
		</table>
	</form>

</body>
</html>