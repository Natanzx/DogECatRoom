package br.com.dogcatroom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dogcatroom.bo.FuncionarioBO;
import br.com.dogcatroom.dto.FuncionarioDTO;

/**
 * Servlet implementation class FuncionarioController
 */
@WebServlet("/FuncionarioController")
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FuncionarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String acao = request.getParameter("acao");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if(acao!=null && acao.equals("salvar")){

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
			boolean estadoFuncionario = Boolean.parseBoolean(request.getParameter("estadoFuncionario"));
		
			
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
			

			FuncionarioBO funcionarioBO = new FuncionarioBO();
			try {
				funcionarioBO.salvarFuncionario(funcionarioDTO);
			} catch (Exception e) {
				e.getMessage();
			}

			response.sendRedirect("consultarFuncionarios.jsp");
		}

		
	}

}
