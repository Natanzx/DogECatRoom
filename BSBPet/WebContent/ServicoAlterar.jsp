<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.List" %>
    <%@page import="br.upis.Servico" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Servico</title>
</head>
<body>
<%
Servico servico =(Servico) request.getAttribute("servico");
%>
<br>
<br>
	<form action="ServicoController" method="post">
		<table bgcolor="#e0e0e0" align="center" style="width: 250px; border:1px solid #000; padding:10px; font-family:"Arial, Helvetica, sans-serif;">
			<tr>
				<td colspan="2" align="center" ><h3>Alterar dados do Servico</h3></td>
			</tr>
			<tr>
				<td align="right">ID:</td>
				<td><input type="text" name="txtid" value="<%=servico.getId()%>"/></td>
			</tr>
			<tr>
				<td align="right">Tipo:</td>
				<td><input type="text" name="txttipo" value="<%=servico.getTipo() %>"/></td>
			</tr>
			<tr>
				<td align="right">Valor: R$</td>
				<td><input type="text" name="txtvalor" value="<%=servico.getValor() %>" maxlength="8"/></td>
			</tr>
			<tr>
				<td align='center'><br><a href="ServicoController?acao=listar">Voltar</a></td>
				<td align="center"><input type="submit" value="Atualizar"/></td>
			</tr>
		</table>
	</form>

</body>
</html>