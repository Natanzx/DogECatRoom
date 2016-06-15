package br.com.dogcatroom.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dogcatroom.bo.FuncionarioBO;
import br.com.dogcatroom.dto.FuncionarioDTO;

@WebServlet("/FuncionarioController")
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FuncionarioController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");

		if (acao != null && acao.equals("listar")) {

			FuncionarioBO funcionarioBO = new FuncionarioBO();
			List<FuncionarioDTO> funcionarioDTOs = funcionarioBO.buscarTodosFuncionariosAtivo();

			request.setAttribute("lista", funcionarioDTOs);

			RequestDispatcher saida = request.getRequestDispatcher("Sistemas/Funcionarios/consultarFuncionarios.jsp");
			saida.forward(request, response);
		}
		
		if (acao != null && acao.equals("alterar")) {
            FuncionarioDTO funcionarioAlterar = new FuncionarioDTO();
            funcionarioAlterar.setId(Integer.parseInt(request.getParameter("id")));
			
            FuncionarioBO funcionarioBO = new FuncionarioBO();
            FuncionarioDTO funcionarioDTO;
			try {
				funcionarioDTO = funcionarioBO.buscarFuncionarioPorID(funcionarioAlterar);
				request.setAttribute("funcionario", funcionarioDTO);
				RequestDispatcher saida = request.getRequestDispatcher("Sistemas/Funcionarios/alterarFuncionario.jsp");
				saida.forward(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (acao != null && acao.equals("logout")) {
			HttpSession session = request.getSession(true);
			session.invalidate();
			response.sendRedirect("login.jsp");
		}		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao != null && acao.equals("salvar")) {

			String nome = request.getParameter("nomeFuncionario");
			String numeroCPF = request.getParameter("numeroCPF");
			int matricula = Integer.parseInt(request.getParameter("matriculaFuncionario"));
			String endereco = request.getParameter("enderecoFuncionario");
			String numeroEndereco = request.getParameter("numeroFuncionario");
			String complemento = request.getParameter("complementoFuncionario");
			String bairro = request.getParameter("bairroFuncionario");
			String cidade = request.getParameter("cidadeFuncionario");
			String estado = request.getParameter("estadoFuncionario");
			String telCelular = request.getParameter("telCelular");
			String telFixo = request.getParameter("telFixo");
			String escolaridade = request.getParameter("escolaridadeFuncionario");
			String ocupacao = request.getParameter("ocupacaoFuncionario");
			double salario = Double.parseDouble(request.getParameter("salarioFuncionario"));
			String login = request.getParameter("loginFuncionario");
			String senha = request.getParameter("senhaFuncionario");
			boolean estadoFuncionario = request.getParameter("estadoFuncionario").equalsIgnoreCase("Ativo")? false: true;

			FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

			funcionarioDTO.setNome(nome);
			funcionarioDTO.setCpf(numeroCPF);
			funcionarioDTO.setMatricula(matricula);
			funcionarioDTO.setEndereco(endereco);
			funcionarioDTO.setNumero(numeroEndereco);
			funcionarioDTO.setComplemento(complemento);
			funcionarioDTO.setBairro(bairro);
			funcionarioDTO.setCidade(cidade);
			funcionarioDTO.setEstado(estado);
			funcionarioDTO.setTelCelular(telCelular);
			funcionarioDTO.setTelFixo(telFixo);
			funcionarioDTO.setEscolaridade(escolaridade);
			funcionarioDTO.setOcupacao(ocupacao);
			funcionarioDTO.setSalario(salario);
			funcionarioDTO.setLogin(login);
			funcionarioDTO.setSenha(senha);
			funcionarioDTO.setAtivo(estadoFuncionario);

			FuncionarioBO funcionarioBO = new FuncionarioBO();
			
			try {
				funcionarioBO.salvarFuncionario(funcionarioDTO);
				response.sendRedirect("FuncionarioController?acao=listar");
			} catch (Exception e) {
				e.getMessage();
			}

		}

		if (acao != null && acao.equals("alterar")) {

			String nome = request.getParameter("nomeFuncionario");
			String numeroCPF = request.getParameter("numeroCPF");
			int matricula = Integer.parseInt(request.getParameter("matriculaFuncionario"));
			String endereco = request.getParameter("enderecoFuncionario");
			String numeroEndereco = request.getParameter("numeroFuncionario");
			String complemento = request.getParameter("complementoFuncionario");
			String bairro = request.getParameter("bairroFuncionario");
			String cidade = request.getParameter("cidadeFuncionario");
			String estado = request.getParameter("estadoFuncionario");
			String telCelular = request.getParameter("telCelular");
			String telFixo = request.getParameter("telFixo");
			String escolaridade = request.getParameter("escolaridadeFuncionario");
			String ocupacao = request.getParameter("ocupacaoFuncionario");
			double salario = Double.parseDouble(request.getParameter("salarioFuncionario"));
			boolean estadoFuncionario = request.getParameter("estadoFuncionario").equalsIgnoreCase("Ativo")? false: true;
			int id = Integer.parseInt(request.getParameter("id"));
			String login = request.getParameter("loginFuncionario");
			FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

			funcionarioDTO.setNome(nome);
			funcionarioDTO.setCpf(numeroCPF);
			funcionarioDTO.setMatricula(matricula);
			funcionarioDTO.setEndereco(endereco);
			funcionarioDTO.setNumero(numeroEndereco);
			funcionarioDTO.setComplemento(complemento);
			funcionarioDTO.setBairro(bairro);
			funcionarioDTO.setCidade(cidade);
			funcionarioDTO.setEstado(estado);
			funcionarioDTO.setTelCelular(telCelular);
			funcionarioDTO.setTelFixo(telFixo);
			funcionarioDTO.setEscolaridade(escolaridade);
			funcionarioDTO.setOcupacao(ocupacao);
			funcionarioDTO.setSalario(salario);
			funcionarioDTO.setAtivo(estadoFuncionario);
			funcionarioDTO.setId(id);
			funcionarioDTO.setLogin(login);

			FuncionarioBO funcionarioBO = new FuncionarioBO();
			try {
				funcionarioBO.salvarFuncionario(funcionarioDTO);
				response.sendRedirect("FuncionarioController?acao=listar");
			} catch (Exception e) {
				e.getMessage();
			}

		}
		
		if (acao != null && acao.equals("autenticar")) {
			
			
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			
			FuncionarioDTO f = new FuncionarioDTO();
			f.setLogin(login);
			f.setSenha(senha);
			
			FuncionarioBO funcBO = new FuncionarioBO();
			FuncionarioDTO retorno = funcBO.autenticarLogin(f);
			
			if(retorno.getNome() != null){
				HttpSession session = request.getSession(true);
				session.setAttribute("UsuarioLogado", retorno.getNome());
				response.sendRedirect("principal.jsp");
			}else{
				response.sendRedirect("login.jsp");
			}
		}
		
		if (acao != null && acao.equals("recuperaSenha")) {
			String FuncionarioCPF = request.getParameter("FuncionarioCPF");
			String FuncionarioLogin = request.getParameter("FuncionarioLogin");
			FuncionarioDTO func = new FuncionarioDTO();
			func.setCpf(FuncionarioCPF);
			func.setLogin(FuncionarioLogin);
			
			FuncionarioBO funcionarioBO = new FuncionarioBO();
			FuncionarioDTO funcionarioDTO = funcionarioBO.recuperarSenha(func);

			if(funcionarioDTO.getNome() != null){
				request.setAttribute("funcionario", funcionarioDTO);
				RequestDispatcher saida = request.getRequestDispatcher("Recuperado.jsp");
				saida.forward(request, response);
			}else{
				response.sendRedirect("EsqueceuSenha.jsp");
			}
		}		
		
	}

}
