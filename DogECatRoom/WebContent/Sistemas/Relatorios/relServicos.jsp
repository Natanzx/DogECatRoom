<%@page import="java.util.List" %>
<%@page import="br.com.dogcatroom.dto.ServicoDTO" %>

<h4 style="margin-left: 40px;">Serviços</h4>
<table class="table">
	<thead>
		<tr>
			<th>
				#
			</th>		
			<th>
				Servico
			</th>
			<th>
				Descricao
			</th>
			<th>
				Valor
			</th>											
		</tr>
	</thead>

	<tbody>
	<% 
	//retorna object tem que fazer cast pois nois sabe que é uma lista
		List<ServicoDTO> lista=(List<ServicoDTO>) request.getAttribute("lista");	
	for(ServicoDTO servico : lista){
	%>
	<tr>
		<td><%=servico.getId()%></td>
		<td><%=servico.getNome()%></td>
		<td><%=servico.getDescricao()%></td> 
		<td><%=servico.getValor()%></td>
	</tr>
<% } %>	
	
	</tbody>
</table>