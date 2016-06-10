<%@page import="java.util.List" %>
<%@page import="br.com.dogcatroom.dto.AnimalDTO" %>
<script>
	var idCliente = $("#idCliente").val();
	
	function AnimalDeletar(idAnimal){
		$.ajax({	            
	    	url: "/DogECatRoom/AnimalController",
	        data: {
	        	'acao':'excluir',
	        	'idAnimal': idAnimal
	        },
	        type: 'GET',
	        success: function(result){
	        	listaAnimaisCliente();
	        }
		});	        				
	}
	
	function listaAnimaisCliente(){
		$.ajax({	            
            url: "/DogECatRoom/AnimalController",
            data: {
            	'acao': 'listar',
            	'idCliente': idCliente
            },
            type: 'GET',
            success: function(result){
                $("#divResultadoAnimal").html(result);
            }
    	});	
	} 

</script>

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
					<button type="button" class="btn btn-danger btn-xs" onclick="AnimalDeletar(<%=a.getIdAnimal() %>)">X</button>
					
					<button class="btn btn-warning btn-xs" idAnimal="<%=a.getIdAnimal() %>">Alterar</button>
				</td>					
			</tr>
		<%
			}
		%>
		</tbody>
	</table>	
