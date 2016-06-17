<%@page import="br.com.dogcatroom.dto.AnimalDTO" %>
<%@page import="java.util.List" %>

	<select style="width: 300px;" name="idAnimal">
		<% 
		List<AnimalDTO> listaAnimalCliente = (List<AnimalDTO>) request.getAttribute("listaAnimal");
		for(AnimalDTO animal : listaAnimalCliente){
		%>
			
			<option width="300px" value="<%=animal.getIdAnimal()%>">
				<%
				out.print(animal.getNome() +" - "+ animal.getTipo());
				%>
				
			</option>
		
		<% } %>
	</select>	