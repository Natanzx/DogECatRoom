<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="br.com.dogcatroom.dto.ClienteDTO" %>
<%@page import="br.com.dogcatroom.dto.ServicoDTO" %>

<% session.setAttribute("page", "Atendimentos");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="/template/head.jsp"/>
<title>DogECatRoom - Clientes</title>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#slcCliente").change(function(){
			var idCliente = $("#slcCliente").val();
			if(idCliente == 0){
				$("#divResultado").hide();
			}else{
				$("#divResultado").show("slow");
			}
			$.ajax({	            
	            url: "/DogECatRoom/AnimalController",
	            data: {
	            	'acao': 'listar',
	            	'page': 'cadastroAtendimento',
	            	'idCliente': idCliente
	            },
	            type: 'GET',
	            success: function(result){
	                $("#divResultado").html(result);
	            }
	    	});			
		})	
		
	});

</script>
</head>
<body>
	<jsp:include page="/template/cabecalho_padrao.jsp"/>

	<div class="clOpcoesCrud">
		<a href="/DogECatRoom/principal.jsp">
			<button class="btn btn-danger">Voltar</button>
		</a>		
	</div>

<form action="AtendimentoController" method="post">
		<table class="table tblClientes">
		<tr bgcolor="#2b3e8c" style="color: #FFF;">
			<td colspan="2">Informe os dados:</td>
		</tr>
		<tr>
			<td colspan="2">Selecione o Cliente/Animal:</td>
		</tr>
		<tr>
			<td colspan="2">
				<select style="width: 300px;" id="slcCliente">
					<option value="0">--</option>
					<% 
					List<ClienteDTO> listaCliente = (List<ClienteDTO>) request.getAttribute("listaCliente");
					for(ClienteDTO cliente:listaCliente){
					%>
						<option width="300px" value="<%=cliente.getId()%>">
							<%
							out.print(cliente.getNome());
							%>
							
						</option>
					<% } %>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div id="divResultado"></div>
			</td>
		</tr>
		<tr >
			<td colspan="2">Selecione o tipo de Servico:</td>
		<tr>
			<td colspan="2">
				<select style="width: 300px;" name="idServico">
				<%	
					List<ServicoDTO> listaServico = (List<ServicoDTO>) request.getAttribute("listaServico");
					for(ServicoDTO servico:listaServico){
				%>
					<option style="width: 300px" value="<% out.print(servico.getId()); %>">
						<% out.print(servico.getNome()); %> - R$
						<% out.print(servico.getValor()); %>
					</option>
				<% } %>	
				</select>
			</td>
		</tr>

		<tr>
			<td> <input type="submit" value="Realizar Venda" class="btn btn-primary"></td>
		</tr>
	</table>
	</form>

	<jsp:include page="/template/rodape_padrao.jsp"/>
</body>
</html>