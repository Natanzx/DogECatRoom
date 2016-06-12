package br.com.dogcatroom.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import br.com.dogcatroom.bo.ClienteBO;
import br.com.dogcatroom.dto.AnimalDTO;
import br.com.dogcatroom.dto.ClienteDTO;

@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao!=null && acao.equals("listar")){
			
			ClienteBO clienteBO = new ClienteBO();
			List<ClienteDTO> lista;
			try {
				lista = clienteBO.buscarTodosClientes();
				request.setAttribute("lista", lista);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			RequestDispatcher saida= request.getRequestDispatcher("Sistemas/Clientes/consultarClientes.jsp");
			saida.forward(request, response);
		}

		if(acao!=null && acao.equals("alterar")){
			int idCliente = Integer.parseInt(request.getParameter("id"));
			
			ClienteBO clienteBO = new ClienteBO();
			ClienteDTO cliente = clienteBO.buscarClientePorID(idCliente);
			
			AnimalBO animalBO = new AnimalBO();
			List<AnimalDTO> listaAnimal = animalBO.buscarPeloidCliente(idCliente);
			
			request.setAttribute("cliente", cliente);
			request.setAttribute("listaAnimal", listaAnimal);
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

	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String acao = rq.getParameter("acao");
		HttpSession session = rq.getSession(true);
		
		if(acao!=null && acao.equals("cadastrar")){
			Integer numero = null;
			String nome = rq.getParameter("textNome");
			String cpf = rq.getParameter("textCpf");
			String cep = rq.getParameter("textCep");
			String endereco = rq.getParameter("textEndereco");
			String numerotext =rq.getParameter("textNumero");
			String complemento = rq.getParameter("textComplemento");
			String bairro = rq.getParameter("textBairro");
			String cidade = rq.getParameter("textCidade");
			String estado = rq.getParameter("textEstado");
			String telCelular = rq.getParameter("textTelCelular");
			String telFixo = rq.getParameter("textTelFixo");
			
			
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
			try {
				clienteBO.cadastarCliente(cliente);
			} catch (BusinesException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(session.getAttribute("listAnimalTemp") != null){
				List<AnimalDTO> listaAnimal = (ArrayList<AnimalDTO>)session.getAttribute("listAnimalTemp");
				AnimalBO animalBO = new AnimalBO();
				
				for (AnimalDTO animal : listaAnimal) {
					animal.setIdCliente(cliente.getId());
					animalBO.cadastrar(animal);
				}
			}			
			
			rs.sendRedirect("ClienteController?acao=listar");
		}
	
	
	if(acao!=null && acao.equals("alterar")){
		Integer numero = null;
		String nome = rq.getParameter("textNome");
		String cpf = rq.getParameter("textCpf");
		String cep = rq.getParameter("textCep");
		String endereco = rq.getParameter("textEndereco");
		String numerotext =rq.getParameter("textNumero");
		String complemento = rq.getParameter("textComplemento");
		String bairro = rq.getParameter("textBairro");
		String cidade = rq.getParameter("textCidade");
		String estado = rq.getParameter("textEstado");
		String telCelular = rq.getParameter("textTelCelular");
		String telFixo = rq.getParameter("textTelFixo");
		int id = Integer.parseInt(rq.getParameter("textId"));
		int estadoCliente = Integer.parseInt(rq.getParameter("estadoCliente"));
		
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
		try {
			clienteBO.alterarCliente(cliente);
		} catch (BusinesException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		rs.sendRedirect("ClienteController?acao=listar");
	}
}

}
