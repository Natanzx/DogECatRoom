package br.com.dogcatroom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dogcatroom.bo.ClienteBO;
import br.com.dogcatroom.dto.ClienteDTO;

@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao!=null && acao.equals("listar")){
			
			ClienteBO clienteBO = new ClienteBO();
			List<ClienteDTO> lista = clienteBO.buscarTodosClientes();
		
			request.setAttribute("lista", lista);
			
			RequestDispatcher saida= request.getRequestDispatcher("Sistemas/Clientes/consultarClientes.jsp");
			saida.forward(request, response);
		}

		if(acao!=null && acao.equals("alterar")){
			String id = request.getParameter("id");
			
			ClienteBO clienteBO = new ClienteBO();
			ClienteDTO cliente = clienteBO.buscarClientePorID(Integer.parseInt(id));
			
			request.setAttribute("cliente", cliente);
			RequestDispatcher saida = request.getRequestDispatcher("Sistemas/Clientes/alterarCliente.jsp");
			saida.forward(request,response);
			
		}
		
		if(acao!=null && acao.equals("excluir")){
			String id = request.getParameter("id");
			
			ClienteDTO cliente = new ClienteDTO();
			cliente.setId(Integer.parseInt(id));
			
			ClienteBO clienteBO = new ClienteBO();
			clienteBO.excluirCliente(cliente);
			
			response.sendRedirect("ClienteController?acao=listar");
		}
		
		if(acao!=null && acao.equals("cadastrar")){
			HttpSession session = request.getSession();
			session.removeAttribute("listAnimalTemp");
			//session.invalidate();
			
			RequestDispatcher saida= request.getRequestDispatcher("Sistemas/Clientes/cadastrarClientes.jsp");
			saida.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao!=null && acao.equals("cadastrar")){
			Integer numero = null;
			String nome = request.getParameter("textNome");
			String cpf = request.getParameter("textCpf");
			String cep = request.getParameter("textCep");
			String endereco = request.getParameter("textEndereco");
			String numerotext =request.getParameter("textNumero");
			String complemento = request.getParameter("textComplemento");
			String bairro = request.getParameter("textBairro");
			String cidade = request.getParameter("textCidade");
			String estado = request.getParameter("textEstado");
			String telCelular = request.getParameter("textTelCelular");
			String telFixo = request.getParameter("textTelFixo");
			
			
			if(numerotext != ""){
				numero = (Integer.parseInt(numerotext));
			}else{
				numero = 0;
			}
			
			ClienteDTO cliente = new ClienteDTO();
			
			cliente.setNome(nome);
			cliente.setCpf(cpf);
			cliente.setCep(cep);
			cliente.setEndereco(endereco);
			cliente.setNumero(numero);
			cliente.setComplemento(complemento);
			cliente.setBairro(bairro);
			cliente.setCidade(cidade);
			cliente.setEstado(estado);
			cliente.setTelCelular(telCelular);
			cliente.setTelFixo(telFixo);
			
			ClienteBO clienteBO = new ClienteBO();
			clienteBO.cadastarCliente(cliente);
			
			response.sendRedirect("ClienteController?acao=listar");
		}
	
	
	if(acao!=null && acao.equals("alterar")){
		Integer numero = null;
		String nome = request.getParameter("textNome");
		String cpf = request.getParameter("textCpf");
		String cep = request.getParameter("textCep");
		String endereco = request.getParameter("textEndereco");
		String numerotext =request.getParameter("textNumero");
		String complemento = request.getParameter("textComplemento");
		String bairro = request.getParameter("textBairro");
		String cidade = request.getParameter("textCidade");
		String estado = request.getParameter("textEstado");
		String telCelular = request.getParameter("textTelCelular");
		String telFixo = request.getParameter("textTelFixo");
		int id = Integer.parseInt(request.getParameter("textId"));
		int estadoCliente = Integer.parseInt(request.getParameter("estadoCliente"));
		
		if(numerotext != ""){
			numero = (Integer.parseInt(numerotext));
		}
		
		ClienteDTO cliente = new ClienteDTO();
		
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setCep(cep);
		cliente.setEndereco(endereco);
		cliente.setNumero(numero);
		cliente.setComplemento(complemento);
		cliente.setBairro(bairro);
		cliente.setCidade(cidade);
		cliente.setEstado(estado);
		cliente.setTelCelular(telCelular);
		cliente.setTelFixo(telFixo);
		cliente.setId(id);
		cliente.setAtivo(estadoCliente);
		
		ClienteBO clienteBO = new ClienteBO();
		clienteBO.alterarCliente(cliente);
		
		response.sendRedirect("ClienteController?acao=listar");
	}
}

}
