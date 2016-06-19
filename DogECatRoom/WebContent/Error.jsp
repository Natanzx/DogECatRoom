<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	session.setAttribute("page", "Principal");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/template/head.jsp" />
<title>DogECatRoom - Página Principal</title>
<style>
.widget-left {
	padding-bottom: 10px;
}

.row {
	padding-left: 150px;
}
</style>
</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp" />


	<div class="col-md-12" align="center">
		<div class="panel panel-red">
				<div>Erro na última atividade.Por favor escolher nova ação. <%=request.getAttribute("error")%></div>
		</div>
	</div>

	<jsp:include page="/template/rodape_padrao.jsp" />
</body>