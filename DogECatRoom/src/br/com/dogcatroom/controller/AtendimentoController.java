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
import br.com.dogcatroom.bo.AtendimentoBO;
import br.com.dogcatroom.bo.ClienteBO;
import br.com.dogcatroom.bo.ServicoBO;
import br.com.dogcatroom.dao.implementacao.AtendimentoDAO;
import br.com.dogcatroom.dao.implementacao.ClienteDAO;
import br.com.dogcatroom.dao.implementacao.ServicoDAO;
import br.com.dogcatroom.dto.AtendimentoDTO;
import br.com.dogcatroom.dto.ClienteDTO;
import br.com.dogcatroom.dto.ServicoDTO;



@WebServlet("/AtendimentoController")
public class AtendimentoController extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		ClienteDAO clienteDao = new ClienteDAO();
		ServicoDAO servicoDao = new ServicoDAO();
		
		if(acao!=null && acao.equals("atendimento")){
			ClienteBO clienteBO = new ClienteBO();
			List<ClienteDTO> listaCliente;
			
			try {
				listaCliente = clienteBO.buscarClienteAnimais();
				request.setAttribute("listaCliente", listaCliente);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			ServicoBO servicoBO = new ServicoBO();
			List<ServicoDTO> listaServico;
			try {
				listaServico = servicoBO.BuscarServicos();
				request.setAttribute("listaServico", listaServico);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			
			RequestDispatcher saida = request.getRequestDispatcher("Sistemas/Atendimento/realizarAtendimento.jsp");

			saida.forward(request, response);
			
			response.sendRedirect("AtendimentoController?acao=listar");
			
			}
		
		if(acao!=null && acao.equals("listar")){
			AtendimentoBO atendimentoBo = new AtendimentoBO();
					
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
				HttpSession session = request.getSession(true);
				
				int id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
				Integer id_servico = Integer.parseInt(request.getParameter("id_servico"));
			
				AtendimentoDTO atendimento = new AtendimentoDTO();
				ClienteBO clienteBO = new ClienteBO();
				ServicoBO servicoBO = new ServicoBO();
				
				atendimento.setCliente(clienteBO.buscarClientePorID(id_cliente));
				try {
					atendimento.setServico(servicoBO.buscarServicoPorID(id_servico));
				} catch (SQLException e) {
					e.printStackTrace();
				}
							
			
				AtendimentoBO atendimentoBo = new AtendimentoBO();
			
				try {
					atendimentoBo.cadastarAtendimento(atendimento);
				} catch (BusinesException | SQLException e) {
					e.printStackTrace();
				}
				response.sendRedirect("AtendimentoController?acao=listar");
				
				}
	
	
}
