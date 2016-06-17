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

import br.com.dogcatroom.Exception.BusinesException;
import br.com.dogcatroom.bo.AnimalBO;
import br.com.dogcatroom.bo.AtendimentoBO;
import br.com.dogcatroom.bo.ClienteBO;
import br.com.dogcatroom.bo.FuncionarioBO;
import br.com.dogcatroom.bo.ServicoBO;
import br.com.dogcatroom.dto.AnimalDTO;
import br.com.dogcatroom.dto.AtendimentoDTO;
import br.com.dogcatroom.dto.ClienteDTO;
import br.com.dogcatroom.dto.ServicoDTO;


@WebServlet("/AtendimentoController")
public class AtendimentoController extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if(acao!=null && acao.equals("atendimento")){
			AnimalBO animalBO = new AnimalBO();
			ClienteBO clienteBO = new ClienteBO();
			ServicoBO servicoBO = new ServicoBO();
			
			List<ClienteDTO> listaCliente;
			List<ServicoDTO> listaServico;
			
			try {
				listaCliente = clienteBO.buscarClienteAnimais();
				listaServico = servicoBO.BuscarServicos();
				
				request.setAttribute("listaCliente", listaCliente);
				request.setAttribute("listaServico", listaServico);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
			RequestDispatcher saida = request.getRequestDispatcher("Sistemas/Atendimento/realizarAtendimento.jsp");
			saida.forward(request, response);
			response.sendRedirect("AtendimentoController?acao=listar");
		}
		
		if(acao!=null && acao.equals("listar")){
			AtendimentoBO atendimentoBo = new AtendimentoBO();
			AnimalBO animalBO = new AnimalBO();
					
			List<AtendimentoDTO> listaAtendimento;
			try {
				listaAtendimento = atendimentoBo.buscarTodosAtendimentos();
				request.setAttribute("lista", listaAtendimento);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			RequestDispatcher saida = request.getRequestDispatcher("Sistemas/Atendimento/listarAtendimentos.jsp");
			saida.forward(request, response);
			}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session = request.getSession();
		int idAnimal = Integer.parseInt(request.getParameter("idAnimal"));
		int idServico = Integer.parseInt(request.getParameter("idServico"));
		int idFuncionario =  (int)session.getAttribute("idFuncionario");
		
		AnimalBO animalBO = new AnimalBO();
		ServicoBO servicoBO = new ServicoBO();
		FuncionarioBO funcionarioBO = new FuncionarioBO();
		AtendimentoBO atendimentoBo = new AtendimentoBO();
		
		AtendimentoDTO atendimento = new AtendimentoDTO();
		
		try {
			atendimento.setAnimal(animalBO.buscaAnimalPorID(idAnimal));
			atendimento.setServico(servicoBO.buscarServicoPorID(idServico));
			atendimento.setFuncionario(funcionarioBO.buscarFuncionarioPorID(idFuncionario));
			
			atendimentoBo.cadastarAtendimento(atendimento);
		} catch (BusinesException | SQLException e) {
			e.printStackTrace();
		}

		response.sendRedirect("AtendimentoController?acao=listar");			
	}
	
}
