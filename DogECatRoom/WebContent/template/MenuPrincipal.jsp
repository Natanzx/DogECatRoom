
<div>
	<nav class="navbar navbar-inverse clMenuNav">
		<ul class="nav navbar-nav clMenuPrincipal user-menu">
			<li class="active"><a href="/DogECatRoom/principal.jsp">
				<svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg>
				Principal </a>
			</li>

			<li><a href="/DogECatRoom/ClienteController?acao=listar">
				<svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-male-user"></use></svg>
				Clientes
			</a></li>
			
			<li><a href="/DogECatRoom/ServicoController?acao=listar">
				<svg class="glyph stroked dashboard-dial"><use xlink:href="#stroked-clipboard-with-paper"></use></svg>
				Serviços</a>
			</li>
			
			<li><a href="FuncionarioController?acao=listar">
				<svg class="glyph stroked dashboard dial"><use xlink:href="#stroked-dashboard-dial"/></svg>
				Funcionarios</a>
			</li>
			
			<li><a href="/DogECatRoom/Sistemas/Relatorios/Relatorios.jsp">
				<svg class="glyph stroked line-graph"><use xlink:href="#stroked-line-graph"></use></svg>
				Relatórios</a>
			</li>

			<!--
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false">Dropdown <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Action</a></li>
					<li><a href="#">Another action</a></li>
					<li><a href="#">Something else here</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#">Separated link</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#">One more separated link</a></li>
				</ul>
			</li>
			-->
			<li class="dropdown pull-right">
			<a href="#"	class="dropdown-toggle" data-toggle="dropdown">
			<svg class="glyph stroked male-user">
				<use xlink:href="#stroked-male-user"></use></svg> Usuario <span
					class="caret"></span></a>
				<ul class="dropdown-menu" role="menu">
					<li><a href="/DogECatRoom/perfil.jsp"><svg class="glyph stroked male-user">
								<use xlink:href="#stroked-male-user"></use></svg> Perfil</a></li>
					<li><a href="/DogECatRoom/config.jsp"><svg class="glyph stroked gear">
								<use xlink:href="#stroked-gear"></use></svg> Configurações</a></li>
					<li><a href="/DogECatRoom/login.jsp"><svg class="glyph stroked cancel">
								<use xlink:href="#stroked-cancel"></use></svg> Sair</a></li>
				</ul>
			</li>
		</ul>
	</nav>
</div>
<!-- 
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
  <header class="mdl-layout__header">
    <div class="mdl-layout__tab-bar mdl-js-ripple-effect">
      <a href="/DogECatRoom/Sistemas/Clientes/consultarClientes.jsp" class="mdl-layout__tab">Clientes</a>
      <a href="#scroll-tab-2" class="mdl-layout__tab">Serviços</a>
      <a href="/DogECatRoom/Sistemas/Funcionarios/consultarFuncionarios.jsp#scroll-tab-3" class="mdl-layout__tab">Funcionários</a>
      <a href="#scroll-tab-4" class="mdl-layout__tab">Relátorios</a>
      <a href="#scroll-tab-5" class="mdl-layout__tab">Tab 5</a>
      <a href="#scroll-tab-6" class="mdl-layout__tab">Tab 6</a>
    </div>
  </header>
  <div class="mdl-layout__drawer">
    <span class="mdl-layout-title">Title</span>
  </div>
  <main class="mdl-layout__content">
    <section class="mdl-layout__tab-panel is-active" id="scroll-tab-1">
      <div class="page-content"></div>
    </section>
    <section class="mdl-layout__tab-panel" id="scroll-tab-2">
      <div class="page-content"></div>
    </section>
    <section class="mdl-layout__tab-panel" id="scroll-tab-3">
      <div class="page-content"></div>
    </section>
    <section class="mdl-layout__tab-panel" id="scroll-tab-4">
      <div class="page-content"></div>
    </section>
    <section class="mdl-layout__tab-panel" id="scroll-tab-5">
      <div class="page-content"></div>
    </section>
    <section class="mdl-layout__tab-panel" id="scroll-tab-6">
      <div class="page-content"></div>
    </section>
  </main>
</div>
 -->