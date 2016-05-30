package br.com.dogcatroom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dogcatroom.bo.ClienteBO;
import br.com.dogcatroom.dao.implementacao.ClienteDAO;
import br.com.dogcatroom.dto.ClienteDTO;

@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		ClienteDAO clientedao = new ClienteDAO();
		
		if(acao!=null && acao.equals("excluir")){
			String id = request.getParameter("id");
			
			ClienteDTO cliente = new ClienteDTO();
			cliente.setId(Integer.parseInt(id));
			clientedao.excluir(cliente);
			
			response.sendRedirect("ClienteController?acao=listar");
		}
	
	if(acao!=null && acao.equals("alterar")){
		String id = request.getParameter("id");
		
		ClienteDTO cliente = clientedao.buscarPorID(Integer.parseInt(id));
		
		request.setAttribute("cliente", cliente);
		RequestDispatcher saida = request.getRequestDispatcher("ClienteAlterar.jsp");
		saida.forward(request,response);
		
		response.sendRedirect("ClienteController?acao=listar");
		
		
	}
	if(acao!=null && acao.equals("cadastrar")){
		
		String nome = request.getParameter("txtNome");
		String cpf = request.getParameter("txtCPf");
		String cep = request.getParameter("txtCep");
		String endereco = request.getParameter("txtEndereco");
		int numero = (Integer.parseInt(request.getParameter("txtNumero")));
		String complemento = request.getParameter("txtComplemento");
		String bairro = request.getParameter("txtBairro");
		String cidade = request.getParameter("txtCidade");
		String estado = request.getParameter("txtEstado");
		String telCelular = request.getParameter("txtTelCelular");
		String telFixo = request.getParameter("txtTelFixo");
		
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
	}
	
	if(acao!=null && acao.equals("listar")){
	
		ClienteBO clienteBO = new ClienteBO();
		List<ClienteDTO> lista = clienteBO.buscarTodosClientes();
	
		request.setAttribute("lista", lista);
		
		RequestDispatcher saida= request.getRequestDispatcher("consultarClientes.jsp");
		saida.forward(request, response);
	}
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
