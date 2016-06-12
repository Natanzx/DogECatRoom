package br.com.dogcatroom.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dogcatroom.bo.ClienteBO;
import br.com.dogcatroom.bo.ServicoBO;
import br.com.dogcatroom.dao.implementacao.ClienteDAO;
import br.com.dogcatroom.dao.implementacao.ServicoDAO;
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
				listaCliente = clienteBO.buscarTodosClientes();
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
			
			response.sendRedirect("OrcamentoController?acao=listar");
			
			}
		
		if(acao!=null && acao.equals("listar")){
//			//Obter a lista
//			
//			List<Orcamento> lista = orcamentodao.buscarTodos();
//		
//			//guardar lista  no request (chave,tipo)
//			request.setAttribute("lista", lista);
//			
//			//Enviar para jsp
//			RequestDispatcher saida = request.getRequestDispatcher("ListaOrcamento.jsp");
//			//soh aceita enviar um request e response, por isso setamos no request pelo setattribute
//			saida.forward(request, response);
			}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				HttpSession session = request.getSession(true);
		//Recebe dados da tela jsp
//				String id_cliente = request.getParameter("id_cliente");
//				String id_servico = request.getParameter("id_servico");
//				String usuario = (String)session.getAttribute("usuario");
//				
//				//Cria objeto usuario e seta os valores vindo da tela
//				Orcamento orcamento = new Orcamento();
//								
//				orcamento.setId_cliente(Integer.parseInt(id_cliente));
//				orcamento.setId_servico(Integer.parseInt(id_servico));
//				orcamento.setUsuario(usuario);
//				
//				//Pede para o OrcamentoDAO cadastrar ou atualizar no banco
//				OrcamentoDAO orcamentodao = new OrcamentoDAO();
//				
//				orcamentodao.inserir(orcamento);
//				//Saida ao navegador
//				PrintWriter saida = response.getWriter();
//				saida.println("Orcamento cadastrado com sucesso no Servidor!");
//				
//				response.sendRedirect("OrcamentoController?acao=listar");
				}
	
	
}
