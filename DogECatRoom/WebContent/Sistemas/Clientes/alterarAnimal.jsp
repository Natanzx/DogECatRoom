<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="br.com.dogcatroom.dto.AnimalDTO" %>
<%
	AnimalDTO a = (AnimalDTO) request.getAttribute("Animal");

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
	var Temporario = $("#Temporario").val();

	$(document).ready(function(){
		//var idCliente = $("#idCliente").val(); 
		
      	$("#btnCancelarCadAnimal").click(function(){
      		listaAnimaisCliente();
      	});

		$("#btnAlterarAnimal").click(function(){
			if(Temporario == true){
				acao = "updateTemp";
			}else{
				acao = "update";
			}

			var pedigreAnimal;
			if($("#pedigreAnimal").is(':checked')){
				pedigreAnimal = 1;
			}else{
				pedigreAnimal = 0;
			}

			var idAnimal = $("#idAnimal").val();
		    $.ajax({	            
		        url: "/DogECatRoom/AnimalController",
		        data: {
		    		'acao': acao,
		    		'idAnimal': idAnimal,
		    		'nome': $("#nomeAnimal").val(),
		    		'tipo': $("#tipoAnimal").val(),
		    		'raca': $("#racaAnimal").val(),
		    		'cor': $("#corAnimal").val(),
		    		'dataNasc': $("#dataNascAnimal").val(),
		    		'sexo': $("#sexoAnimal").val(),
		    		'pedigre': pedigreAnimal,
		    		'numPedigre': $("#numPedigreAnimal").val()
		        },
		        type: 'POST',
		        success: function(result){
		        	listaAnimaisCliente();
		        }
			});	        	
			
		});
	});		
		
</script>

	<!-- Text input-->
	<div class="form-group">
		<label class="col-md-3 control-label" for="textinput">Nome Pet</label>
		<div class="col-md-2">
			<input id="nomeAnimal" type="text" placeholder=""
				class="form-control input-md" value="<%= a.getNome() %>"  >

		</div>
		
		<label class="col-md-1 control-label" for="textinput">Tipo</label>
		<div class="col-md-2">
			<input id="tipoAnimal" type="text" placeholder=""
				class="form-control input-md" value="<%= a.getTipo() %>"  >

		</div>
	</div>
	
	<div class="form-group">
		<label class="col-md-3 control-label" for="textinput">Raca</label>
		<div class="col-md-2">
			<input id="racaAnimal" type="text" placeholder=""
				class="form-control input-md" value="<%= a.getRaca() %>"  >

		</div>
		
		<label class="col-md-1 control-label" for="textinput">Cor</label>
		<div class="col-md-2">
			<input id="corAnimal" type="text" placeholder=""
				class="form-control input-md" value="<%= a.getCor() %>"  >

		</div>
	</div>
	<div class="form-group">
		<label class="col-md-3 control-label" for="textinput">Data Nascimento</label>
		<div class="col-md-2">
			<input id="dataNascAnimal" type="text" placeholder=""
				class="form-control input-md" value="<%= a.getDataNasc() %>"  >

		</div>
		
		<label class="col-md-1 control-label" for="textinput">Sexo</label>
		<div class="col-md-2">
			<input id="sexoAnimal" type="text" placeholder=""
				class="form-control input-md" value="<%= a.getSexo() %>"  >

		</div>
	</div>
	<div class="form-group">
		<label class="col-md-3 control-label" for="textinput">Pedigre</label>
		<div class="col-md-2">
			<input id="pedigreAnimal" type="checkbox" placeholder=""
				class="form-control input-md" value="<%= a.getPedigre() %>"  >

		</div>
		
		<label class="col-md-1 control-label" for="textinput">N° Pedigre</label>
		<div class="col-md-2">
			<input id="numPedigreAnimal" type="text" placeholder=""
				class="form-control input-md" value="<%= a.getNumPedigre() %>"  >

		</div>
	</div>																	

	<div class="form-group">
		<label class="col-md-4 control-label" for="button1id"></label>
		<div class="col-md-8">
			<button type="button" type="button" id="btnAlterarAnimal" name="button1id" class="btn btn-success">
				Atualizar Pet
			</button>
			<button type="button" type="button" id="btnCancelarCadAnimal" name="button1id" class="btn btn-warning">
				Cancelar
			</button>			
			<input type="hidden" id="idAnimal" value="<%=a.getIdAnimal() %>">
		</div>
	</div>
