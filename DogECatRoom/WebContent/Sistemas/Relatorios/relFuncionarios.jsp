<%@page import="java.util.List"%>
<%@ page import="br.com.dogcatroom.dto.FuncionarioDTO"%>

<h4 style="margin-left: 40px;">Funcionários</h4>
<table class="table">
	<thead>
		<tr>
			<th>
				#
			</th>
			<th>
				Matricula
			</th>					
			<th>
				Nome
			</th>
			<th>
				CPF
			</th>
			<th>
				Celular
			</th>
			<th>
				Ocupação
			</th>
			<th>
				Salario
			</th>													
		</tr>
	</thead>

	<tbody>
		<% 
	//retorna object lista
		List<FuncionarioDTO> lista =(List<FuncionarioDTO>) request.getAttribute("lista");	
	for(FuncionarioDTO funcionario : lista){
	%>
		<tr>
			<td><%=funcionario.getId()%></td>
			<td><%=funcionario.getMatricula()%></td>
			<td><%=funcionario.getNome()%></td>
			<td><%=funcionario.getCpf()%></td>
			<td><%=funcionario.getTelCelular()%></td>
			<td><%=funcionario.getOcupacao()%></td>
			<td><%=funcionario.getSalario()%></td>
		</tr>
		<% } %>	
	
	</tbody>
</table>