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
import br.upis.jdbc.ClienteDAO;

import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;

@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClienteController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			//captura parametro da tela jsp
			String acao = request.getParameter("acao");
			
			ClienteDAO clientedao = new ClienteDAO();
			
		if(acao!=null && acao.equals("excluir")){
			//captura parametro da tela jsp
			String id = request.getParameter("id");
			
			Cliente cliente = new Cliente();
			cliente.setId(Integer.parseInt(id));
			clientedao.excluir(cliente);
			
			response.sendRedirect("ClienteController?acao=listar");
		}
		
		if(acao!=null && acao.equals("alterar")){
			//captura parametro da tela jsp
			String id = request.getParameter("id");
			
			//buscar objeto no banco
			Cliente cliente = clientedao.buscarPorID(Integer.parseInt(id));
			
			//colocar no resquest
			request.setAttribute("cliente", cliente);
			//encaminha para jsp
			RequestDispatcher saida = request.getRequestDispatcher("ClienteAlterar.jsp");
			saida.forward(request,response);
			
			response.sendRedirect("ClienteController?acao=listar");
			
			
		}
	
		if(acao!=null && acao.equals("cadastrar")){
			
			response.sendRedirect("ClienteCadastro.jsp");
			
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
		
		List<Cliente> lista = clientedao.buscarTodos();
	
		//guardar lista  no request (chave,tipo)
		request.setAttribute("lista", lista);
		
		//Enviar para jsp
		RequestDispatcher saida= request.getRequestDispatcher("Listacliente.jsp");
		//soh aceita enviar um request e response, por isso setamos no request pelo setattribute
		saida.forward(request, response);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("chamando metodo post");
		
		
		//Recebe dados da tela jsp
		String id = request.getParameter("txtid");
		String nome = request.getParameter("txtnome");
		int telefone = Integer.parseInt(request.getParameter("txttelefone"));
		String cpf = request.getParameter("txtcpf");
		String endereco = request.getParameter("txtendereco");
		String animal = request.getParameter("txtanimal");
		
		//Cria objeto usuario e seta os valores vindo da tela
		Cliente cliente = new Cliente();
		if(id!=null && id!="" && id!= "0"){
		cliente.setId(Integer.parseInt(id));
		}
		
		cliente.setNome(nome);
		cliente.setTelefone(telefone);
		cliente.setCpf(cpf);
		cliente.setEndereco(endereco);
		cliente.setAnimal(animal);
		
		
		
		//Pede para o ClienteDAO cadastrar ou atualizar no banco
		ClienteDAO clientedao = new ClienteDAO();
		if(id!=null){
			clientedao.alterar(cliente);
			//Saida ao navegador
			PrintWriter saida = response.getWriter();
			saida.println("Atualizado com sucesso no Servidor!");
			
			response.sendRedirect("ClienteController?acao=listar");
		}else{
			clientedao.inserir(cliente);
			//Saida ao navegador
			PrintWriter saida = response.getWriter();
			saida.println("Cadastrado com sucesso no Servidor!");
			
			response.sendRedirect("ClienteController?acao=listar");
		}
		
	
		
	}		
		
		

	
}
