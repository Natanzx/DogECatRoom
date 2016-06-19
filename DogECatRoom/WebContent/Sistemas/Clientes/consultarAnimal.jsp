<%@page import="com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="br.com.dogcatroom.dto.AnimalDTO" %>
<%
	int Temporario;	
	List<AnimalDTO> listaAnimalTemp = new ArrayList<AnimalDTO>();	
	if(session.getAttribute("listAnimalTemp") != null){
		listaAnimalTemp = (List<AnimalDTO>) session.getAttribute("listAnimalTemp");
	}
	
	if(listaAnimalTemp.size() > 0){
		//List<AnimalDTO> listaAnimalTemp = (List<AnimalDTO>)session.getAttribute("listAnimalTemp");
		Temporario = 1;
	}else{
		Temporario = 0;
	}
%>
<input type="hidden" id="Temporario" value="<%=Temporario %>">
<script>
	//var idCliente = $("#idCliente").val();
	var Temporario = $("#Temporario").val();
	
	function AnimalDeletar(idAnimal){
		if(deletar() == true){
			var acao;
			
			if(Temporario == true){
				acao = "deletarAnimalTemp";
			}else{
				acao = "excluir";
			}

			$.ajax({	            
		    	url: "/DogECatRoom/AnimalController",
		        data: {
		        	'acao':acao,
		        	'idAnimal': idAnimal
		        },
		        type: 'GET',
		        success: function(result){
		        	listaAnimaisCliente();
		        }
			});
		}
	}
	
	function AnimalAlterar(idAnimal){
		var acao;
		
		if(Temporario == true){
			acao = "alterarTemp";
		}else{
			acao = "alterar";
		}		

		$.ajax({	            
	    	url: "/DogECatRoom/AnimalController",
	        data: {
	        	'acao':acao,
	        	'idAnimal': idAnimal
	        },
	        type: 'GET',
	        success: function(result){
	        	$("#divConsultaAnimal").html(result);
	        }
		});	        				
	}	
	/*
	function listaAnimaisCliente(){
		var acao;
		var id;
		if(Temporario){
			acao = "listAnimaisTemp";
			id = 0;
		}else{
			acao = "listar";
			id = idCliente;
		}
		
		$.ajax({	            
            url: "/DogECatRoom/AnimalController",
            data: {
            	'acao': acao,
            	'idCliente': id
            },
            type: 'GET',
            success: function(result){
                $("#divConsultaAnimal").html(result);
            }
    	});	
	} 
	*/

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
					<button type="button" class="btn btn-danger btn-xs" onclick="AnimalDeletar(<%=a.getIdAnimal() %>);">X</button>
					
					<button type="button" class="btn btn-warning btn-xs" onclick="AnimalAlterar(<%=a.getIdAnimal() %>);">Alterar</button>
				</td>					
			</tr>
		<%
			}
		%>
		</tbody>
	</table>	
