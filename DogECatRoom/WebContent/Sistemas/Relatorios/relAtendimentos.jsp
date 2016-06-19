<%@page import="java.util.List" %>
<%@page import="br.com.dogcatroom.dto.ClienteDTO" %>
<%@page import="br.com.dogcatroom.dto.ServicoDTO" %>
<%@page import="br.com.dogcatroom.dto.AnimalDTO" %>
<%@page import="br.com.dogcatroom.dto.AtendimentoDTO" %>

<h4 style="margin-left: 40px;">Atendimentos</h4>
<table class="table">
	<thead>
		<tr>
			<th>
				#
			</th>
			<th>
				Cliente
			</th>					
			<th>
				Animal
			</th>
			<th>
				Servico
			</th>
			<th>
				Valor
			</th>
			<th>
				Data/Hora
			</th>
		</tr>
	</thead>

	<tbody>
	<%
		List<AtendimentoDTO> lista = (List<AtendimentoDTO>) request.getAttribute("lista");	
		for(AtendimentoDTO atendimento:lista){
	%>
			<tr>
				<td align="center"><%=atendimento.getId()%></td>
				<td><%=atendimento.getAnimal().getCliente().getNome()%></td>
				<td><%=atendimento.getAnimal().getNome()%></td>
				<td><%=atendimento.getServico().getNome()%></td>
				<td align="center"><%=atendimento.getServico().getValor()%></td>
				<td align="center"><%=atendimento.getData()%><%=atendimento.getHora()%></td>
			</tr>
<% } %>
	</tbody>
</table>