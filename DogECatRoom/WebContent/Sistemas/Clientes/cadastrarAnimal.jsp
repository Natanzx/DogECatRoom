

	<!-- Text input-->
	<div class="form-group">
		<label class="col-md-3 control-label" for="textinput">Nome Pet</label>
		<div class="col-md-2">
			<input id="nomeAnimal" type="text" placeholder=""
				class="form-control input-md" pattern="^[a-zA-Z\s]+$">

		</div>
		
		<label class="col-md-1 control-label" for="textinput">Tipo</label>
		<div class="col-md-2">
			<input id="tipoAnimal" type="text" placeholder=""
				class="form-control input-md">

		</div>
	</div>
	
	<div class="form-group">
		<label class="col-md-3 control-label" for="textinput">Raca</label>
		<div class="col-md-2">
			<input id="racaAnimal" type="text" placeholder=""
				class="form-control input-md">

		</div>
		
		<label class="col-md-1 control-label" for="textinput">Cor</label>
		<div class="col-md-2">
			<input id="corAnimal" type="text" placeholder=""
				class="form-control input-md">

		</div>
	</div>
	<div class="form-group">
		<label class="col-md-3 control-label" for="textinput">Data Nascimento</label>
		<div class="col-md-2">
			<input id="dataNascAnimal" type="date" placeholder=""
				class="form-control input-md">

		</div>
		
		<label class="col-md-1 control-label" for="textinput">Sexo</label>
		<div class="col-md-2">
			<input id="sexoAnimal" type="text" placeholder=""
				class="form-control input-md">

		</div>
	</div>
	<div class="form-group">
		<label class="col-md-3 control-label" for="textinput">Pedigre</label>
		<div class="col-md-2">
			<input id="pedigreAnimal" type="checkbox" placeholder=""
				class="form-control input-md">

		</div>
		
		<label class="col-md-1 control-label" for="textinput">N° Pedigre</label>
		<div class="col-md-2">
			<input id="numPedigreAnimal" type="number" placeholder=""
				class="form-control input-md">

		</div>
	</div>																	

	<div class="form-group">
		<label class="col-md-4 control-label" for="button1id"></label>
		<div class="col-md-8">
			<button type="button" type="button" id="btnCadastrarAnimal" name="button1id" class="btn btn-success">
				Adicionar Pet
			</button>
			<button type="button" type="button" id="btnCancelar" name="button1id" class="btn btn-danger">
				Cancelar
			</button>
		</div>
	</div>

	
<script>

	$(document).ready(function(){
		//var idCliente = $("#idCliente").val();
		
		$("#btnCancelar").click(function(){
			listaAnimaisCliente();
		});

		$("#btnCadastrarAnimal").click(function(){
			var pedigreAnimal;
			if($("#pedigreAnimal").is(':checked')){
				pedigreAnimal = 1;
			}else{
				pedigreAnimal = 0;
			}
			
		    $.ajax({	            
		        url: "/DogECatRoom/AnimalController",
		        data: {
		    		'acao': 'cadastrar',
		    		'idCliente': $("#idCliente").val(),
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