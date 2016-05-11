package br.upis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.upis.Orcamento;
import br.upis.Cliente;
import br.upis.Servico;
import br.upis.Usuario;
import br.upis.jdbc.OrcamentoDAO;
import br.upis.jdbc.ClienteDAO;
import br.upis.jdbc.ServicoDAO;
import br.upis.jdbc.UsuarioDAO;

@WebServlet("/OrcamentoController")
public class OrcamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OrcamentoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		OrcamentoDAO orcamentodao = new OrcamentoDAO();
		ClienteDAO clientedao = new ClienteDAO();
		ServicoDAO servicodao = new ServicoDAO();
		
		if(acao!=null && acao.equals("venda")){
			//Obter a lista
			
			List<Cliente> listaCliente = clientedao.buscarTodos();
			List<Servico> listaServico = servicodao.buscarTodos();
			
		
			//guardar lista  no request (chave,tipo)
			request.setAttribute("listaCliente", listaCliente);
			request.setAttribute("listaServico", listaServico);
			
			//Enviar para jsp
			RequestDispatcher saida = request.getRequestDispatcher("RealizaVenda.jsp");
			//soh aceita enviar um request e response, por isso setamos no request pelo setattribute
			saida.forward(request, response);
			
			response.sendRedirect("OrcamentoController?acao=listar");
			}
		
		if(acao!=null && acao.equals("listar")){
			//Obter a lista
			
			List<Orcamento> lista = orcamentodao.buscarTodos();
		
			//guardar lista  no request (chave,tipo)
			request.setAttribute("lista", lista);
			
			//Enviar para jsp
			RequestDispatcher saida = request.getRequestDispatcher("ListaOrcamento.jsp");
			//soh aceita enviar um request e response, por isso setamos no request pelo setattribute
			saida.forward(request, response);
			}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				HttpSession session = request.getSession(true);
		//Recebe dados da tela jsp
				String id_cliente = request.getParameter("id_cliente");
				String id_servico = request.getParameter("id_servico");
				String usuario = (String)session.getAttribute("usuario");
				
				//Cria objeto usuario e seta os valores vindo da tela
				Orcamento orcamento = new Orcamento();
								
				orcamento.setId_cliente(Integer.parseInt(id_cliente));
				orcamento.setId_servico(Integer.parseInt(id_servico));
				orcamento.setUsuario(usuario);
				
				//Pede para o OrcamentoDAO cadastrar ou atualizar no banco
				OrcamentoDAO orcamentodao = new OrcamentoDAO();
				
				orcamentodao.inserir(orcamento);
				//Saida ao navegador
				PrintWriter saida = response.getWriter();
				saida.println("Orcamento cadastrado com sucesso no Servidor!");
				
				response.sendRedirect("OrcamentoController?acao=listar");
				}

}
