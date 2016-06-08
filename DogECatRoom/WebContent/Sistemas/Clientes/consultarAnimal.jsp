<%@page import="java.util.List" %>
<%@page import="br.com.dogcatroom.dto.AnimalDTO" %>

	<table class="table">
		<thead>
			<tr>
				<th colspan="9">Lista de Animais</th>
			</tr>
			<tr>
				<th>Nome</th>
				<th>Tipo</th>
				<th>Raca</th>
				<th>Cor</th>
				<th>Data Nasc.</th>
				<th>Sexo</th>
				<th>Pedigre</th>
				<th>N° Pedigre</th>
				<th>Acao</th>
			</tr>
		</thead>
		
		<tbody>
		<%
			List<AnimalDTO> lista =(List<AnimalDTO>) request.getAttribute("listaAnimal");	
			for(AnimalDTO a : lista){
		%>
			
			<tr>
				<td><% out.print(a.getNome()); %></td>
				<td><% out.print(a.getTipo()); %></td>
				<td><% out.print(a.getRaca()); %></td>
				<td><% out.print(a.getCor()); %></td>
				<td><% out.print(a.getDataNasc()); %></td>
				<td><% out.print(a.getSexo()); %></td>
				<td><% out.print(a.getPedigre()); %></td>
				<td><% out.print(a.getNumPedigre()); %></td>
				<td>
					<a href="/DogECatRoom/AnimalController?acao=deletarAnimalTemp&idAnimal=<%out.print(a.getIdAnimal());%>">
						<button type="button" class="btn btn-danger btn-xs">X</button>
					</a>
					<button class="btn btn-warning btn-xs">Alterar</button>
				</td>					
			</tr>
		<%
			}
		%>
		</tbody>
	</table>	
