package br.com.dogcatroom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dogcatroom.bo.AnimalBO;
import br.com.dogcatroom.dto.AnimalDTO;
import br.com.dogcatroom.dto.ClienteDTO;

@WebServlet("/AnimalController")
public class AnimalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String acao = rq.getParameter("acao");
		
		if(acao!=null && acao.equals("listar")){
			
			ClienteDTO c = new ClienteDTO();
			c.setId(1);
			AnimalBO animalBO = new AnimalBO();
			List<AnimalDTO> lista = animalBO.buscarPeloCliente(c);
		
			rq.setAttribute("listaAnimal", lista);
			
			RequestDispatcher saida= rq.getRequestDispatcher("Sistemas/Clientes/consultarAnimal.jsp");
			saida.forward(rq, rs);
		}
	}

	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String acao = rq.getParameter("acao");
		
		if(acao!=null && acao.equals("cadastrar")){
			
			int idCliente = 1;
			String nome = rq.getParameter("nome");
			String tipo = rq.getParameter("tipo");
			String raca = rq.getParameter("raca");
			String cor = rq.getParameter("cor");
			String dataNasc = rq.getParameter("dataNasc");
			String sexo = rq.getParameter("sexo");
			int pedigre = Integer.parseInt(rq.getParameter("pedigre"));
			int numPedigre = Integer.parseInt(rq.getParameter("numPedigre"));

			AnimalDTO a = new AnimalDTO();
			a.setIdCliente(idCliente);
			a.setNome(nome);
			a.setTipo(tipo);
			a.setRaca(raca);
			a.setCor(cor);
			a.setDataNasc(dataNasc);
			a.setSexo(sexo);
			a.setPedigre(pedigre);
			a.setNumPedigre(numPedigre);

			AnimalBO animalBO = new AnimalBO();
			animalBO.cadastrar(a);;
			
		}
	}

}
