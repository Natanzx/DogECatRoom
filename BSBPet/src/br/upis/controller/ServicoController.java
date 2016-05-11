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

import br.upis.Cliente;
import br.upis.Servico;
import br.upis.jdbc.ClienteDAO;
import br.upis.jdbc.ServicoDAO;

@WebServlet("/ServicoController")
public class ServicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			//captura parametro da tela jsp
			String acao = request.getParameter("acao");
			
			ServicoDAO servicodao = new ServicoDAO();
			
		if(acao!=null && acao.equals("excluir")){
			//captura parametro da tela jsp
			String id = request.getParameter("id");
			
			Servico servico = new Servico();
			servico.setId(Integer.parseInt(id));
			servicodao.excluir(servico);
			response.sendRedirect("ServicoController?acao=listar");
		}
		
		if(acao!=null && acao.equals("alterar")){
			//captura parametro da tela jsp
			String id = request.getParameter("id");
			
			//buscar objeto no banco
			Servico servico = servicodao.buscarPorID(Integer.parseInt(id));
			
			//colocar no resquest
			request.setAttribute("servico", servico);
			//encaminha para jsp
			RequestDispatcher saida = request.getRequestDispatcher("ServicoAlterar.jsp");
			saida.forward(request,response);
			
			response.sendRedirect("ServicoController?acao=listar");
			
			
		}
	
		if(acao!=null && acao.equals("cadastrar")){
			
			response.sendRedirect("ServicoCadastro.jsp");
			
			/*Cliente cliente = new Cliente();
			//colocar no resquest
			request.setAttribute("cliente", cliente);
			//encaminha para jsp
			RequestDispatcher saida = request.getRequestDispatcher("ClienteAlterar.jsp");
			saida.forward(request,response);
			*/
		}
		
		if(acao!=null && acao.equals("listar")){
		//Obter a lista
		
		List<Servico> lista = servicodao.buscarTodos();
	
		//guardar lista  no request (chave,tipo)
		request.setAttribute("lista", lista);
		
		//Enviar para jsp
		RequestDispatcher saida= request.getRequestDispatcher("Listaservico.jsp");
		//soh aceita enviar um request e response, por isso setamos no request pelo setattribute
		saida.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("chamando metodo post");
		
		
		//Recebe dados da tela jsp
		String id = request.getParameter("txtid");
		String tipo  = request.getParameter("txttipo");
		Double valor = Double.parseDouble(request.getParameter("txtvalor"));

		
		//Cria objeto servio e seta os valores vindo da tela
		Servico servico = new Servico();
		if(id!=null && id!="" && id!= "0"){
			servico.setId(Integer.parseInt(id));
			}
		
		servico.setTipo(tipo);
		servico.setValor(valor);
		
		
		
		//Pede para o ServicoDAO cadastrar ou atualizar no banco
		ServicoDAO servicodao = new ServicoDAO();
		if(id!=null){
			servicodao.alterar(servico);
			//Saida ao navegador
			PrintWriter saida = response.getWriter();
			saida.println("Atualizado com sucesso no Servidor!");
			
			response.sendRedirect("ServicoController?acao=listar");
			
		}else{
			servicodao.inserir(servico);
			//Saida ao navegador
			PrintWriter saida = response.getWriter();
			saida.println("Cadastrado com sucesso no Servidor!");
			
			response.sendRedirect("ServicoController?acao=listar");
		}
		
	
		
	}		
		
		

	
}

