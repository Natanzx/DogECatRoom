package br.com.dogcatroom.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dogcatroom.bo.AnimalBO;
import br.com.dogcatroom.bo.ClienteBO;
import br.com.dogcatroom.dto.AnimalDTO;
import br.com.dogcatroom.dto.ClienteDTO;

@WebServlet("/AnimalController")
public class AnimalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String acao = rq.getParameter("acao");
		HttpSession session = rq.getSession(true);
		
		if(acao!=null && acao.equals("listar")){
			int idCliente = Integer.parseInt(rq.getParameter("idCliente"));
			String page = rq.getParameter("page");
			
			AnimalBO animalBO = new AnimalBO();
			List<AnimalDTO> lista = animalBO.buscarPeloidCliente(idCliente);
		
			rq.setAttribute("listaAnimal", lista);
			RequestDispatcher saida = null;
			
			if(page != null && page.equals("cadastroAtendimento")){
				saida = rq.getRequestDispatcher("Sistemas/Atendimento/listaAnimais.jsp");
			}else{
				saida= rq.getRequestDispatcher("Sistemas/Clientes/consultarAnimal.jsp");
			}
			
			saida.forward(rq, rs);
		}	
		
		if(acao!=null && acao.equals("cadastro")){
			int idCliente = Integer.parseInt(rq.getParameter("idCliente"));
			rq.setAttribute("idCliente", idCliente);
			
			RequestDispatcher saida= rq.getRequestDispatcher("Sistemas/Clientes/cadastrarAnimal.jsp");
			saida.forward(rq, rs);
		}	
		
		if(acao!=null && acao.equals("alterar")){
			int idAnimal = Integer.parseInt(rq.getParameter("idAnimal"));
			
			AnimalBO animalBO = new AnimalBO();
			AnimalDTO a = animalBO.buscaAnimalPorID(idAnimal);
			rq.setAttribute("Animal", a);
			
			RequestDispatcher saida= rq.getRequestDispatcher("Sistemas/Clientes/alterarAnimal.jsp");
			saida.forward(rq, rs);
		}			
		
		if(acao!=null && acao.equals("excluir")){
			int idAnimal = Integer.parseInt(rq.getParameter("idAnimal"));
			
			AnimalBO animalBO = new AnimalBO();
			animalBO.excluir(idAnimal);
		}
		
		
		if(acao!=null && acao.equals("listAnimaisTemp")){
			List<AnimalDTO> listA = new ArrayList<AnimalDTO>();
			
			if(session.getAttribute("listAnimalTemp") != null){
				listA = (ArrayList<AnimalDTO>)session.getAttribute("listAnimalTemp");
			}
			
			rq.setAttribute("listaAnimal", listA);
			
			RequestDispatcher saida= rq.getRequestDispatcher("Sistemas/Clientes/consultarAnimal.jsp");
			saida.forward(rq, rs);
		}		
		
		if(acao!=null && acao.equals("deletarAnimalTemp")){
			List<AnimalDTO> listA = new ArrayList<AnimalDTO>();
			int idAnimal = Integer.parseInt(rq.getParameter("idAnimal"));
			
			if(session.getAttribute("listAnimalTemp") != null){
				listA = (ArrayList<AnimalDTO>)session.getAttribute("listAnimalTemp");
			}
			AnimalDTO a = new AnimalDTO();
			a.setIdAnimal(idAnimal);
			
			listA.remove(a);
			
			session.setAttribute("listAnimalTemp", listA);
		}		

	}

	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String acao = rq.getParameter("acao");
		
		HttpSession session = rq.getSession(true);
		ClienteBO clienteBO = new ClienteBO();
		if(acao!=null && acao.equals("cadastrar")){
			
			int idCliente = Integer.parseInt(rq.getParameter("idCliente"));
			String nome = rq.getParameter("nome");
			String tipo = rq.getParameter("tipo");
			String raca = rq.getParameter("raca");
			String cor = rq.getParameter("cor");
			String dataNasc = rq.getParameter("dataNasc");
			String sexo = rq.getParameter("sexo");
			int pedigre = Integer.parseInt(rq.getParameter("pedigre"));
			int numPedigre = Integer.parseInt(rq.getParameter("numPedigre"));

			AnimalDTO a = new AnimalDTO();
			a.setCliente(clienteBO.buscarClientePorID(idCliente));
			a.setNome(nome);
			a.setTipo(tipo);
			a.setRaca(raca);
			a.setCor(cor);
			a.setDataNasc(dataNasc);
			a.setSexo(sexo);
			a.setPedigre(pedigre);
			a.setNumPedigre(numPedigre);

			AnimalBO animalBO = new AnimalBO();
			animalBO.cadastrar(a);
		}
		
		if(acao!=null && acao.equals("update")){
			
			int idAnimal = Integer.parseInt(rq.getParameter("idAnimal"));
			String nome = rq.getParameter("nome");
			String tipo = rq.getParameter("tipo");
			String raca = rq.getParameter("raca");
			String cor = rq.getParameter("cor");
			String dataNasc = rq.getParameter("dataNasc");
			String sexo = rq.getParameter("sexo");
			int pedigre = Integer.parseInt(rq.getParameter("pedigre"));
			int numPedigre = Integer.parseInt(rq.getParameter("numPedigre"));

			AnimalDTO a = new AnimalDTO();
			a.setIdAnimal(idAnimal);
			a.setNome(nome);
			a.setTipo(tipo);
			a.setRaca(raca);
			a.setCor(cor);
			a.setDataNasc(dataNasc);
			a.setSexo(sexo);
			a.setPedigre(pedigre);
			a.setNumPedigre(numPedigre);

			AnimalBO animalBO = new AnimalBO();
			animalBO.alterar(a);
		}		

		if(acao!=null && acao.equals("cadastrarTemp")){
			
			List<AnimalDTO> listAnimal = new ArrayList<AnimalDTO>();
			
			int idCliente = 0;
			String nome = rq.getParameter("nome");
			String tipo = rq.getParameter("tipo");
			String raca = rq.getParameter("raca");
			String cor = rq.getParameter("cor");
			String dataNasc = rq.getParameter("dataNasc");
			String sexo = rq.getParameter("sexo");
			int pedigre = Integer.parseInt(rq.getParameter("pedigre"));
			int numPedigre = Integer.parseInt(rq.getParameter("numPedigre"));

			AnimalDTO a = new AnimalDTO();
			a.setCliente(clienteBO.buscarClientePorID(idCliente));
			a.setNome(nome);
			a.setTipo(tipo);
			a.setRaca(raca);
			a.setCor(cor);
			a.setDataNasc(dataNasc);
			a.setSexo(sexo);
			a.setPedigre(pedigre);
			a.setNumPedigre(numPedigre);

			//AnimalBO animalBO = new AnimalBO();
			//animalBO.cadastrar(a);
			if (session.getAttribute("listAnimalTemp") != null){
				listAnimal = (ArrayList<AnimalDTO>)session.getAttribute("listAnimalTemp");
			}
			
			listAnimal.add(a);
			
			session.setAttribute("listAnimalTemp", listAnimal);
		}
		
	}

}
