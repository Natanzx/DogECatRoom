<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BSB PET</title>
</head>
<body bgcolor=#e0e0e0>
<form action="UsuarioController" method="post">
	<table align="center" style="margin-top:15%; background:#a09393 ; border: #000 solid 1px; padding: 20px; font-family:Arial, Helvetica, sans-serif;">
		<tr>
			<td colspan=2 align="center">
				<strong>BSB PET</strong>
				<br></br>
			</td>
		<tr>
			<td>Login:</td>
			<td><input type="text" name="login"/></td>
		</tr>
		<tr>
			<td>Senha:</td>
			<td><input type="password" name="senha"/></td>
		</tr>
		<tr>
			<td colspan=2 align="center">
				<input type="submit" value="Autenticar"/><br/>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>