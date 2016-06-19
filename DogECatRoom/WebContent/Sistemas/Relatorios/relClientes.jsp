<%@page import="java.util.List" %>
<%@page import="br.com.dogcatroom.dto.ClienteDTO" %>

<h4 style="margin-left: 40px;">Clientes</h4>
<table class="table">
	<thead>
		<tr>
			<th>
				#
			</th>		
			<th>
				Nome
			</th>
			<th>
				CPF
			</th>
			<th>
				CEP
			</th>
			<th>
				Endereço
			</th>
			<th>
				Numero
			</th>
			<th>
				Celular
			</th>
			<th>
				Estado
			</th>													
		</tr>
	</thead>

	<tbody>
<% 
	//retorna object tem que fazer cast pois nois sabe que é uma lista
		List<ClienteDTO> lista=(List<ClienteDTO>) request.getAttribute("lista");	
	for(ClienteDTO cliente : lista){
	%>
	<tr>
		<td><%=cliente.getId()%></td>
		<td><%=cliente.getNome()%></td>
		<td><%=cliente.getCpf()%></td> 
		<td><%=cliente.getCep()%></td>
		<td><%=cliente.getEndereco()%></td>
		<td><%=cliente.getNumero()%></td>
		<td><%=cliente.getTelCelular()%></td>
		<td><%=cliente.getEstado()%></td>
	</tr>
<% } %>	
	
	</tbody>
</table>