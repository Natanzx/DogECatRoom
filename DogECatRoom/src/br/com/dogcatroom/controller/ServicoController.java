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
import br.com.dogcatroom.bo.ServicoBO;
import br.com.dogcatroom.dto.ClienteDTO;
import br.com.dogcatroom.dto.ServicoDTO;

@WebServlet("/ServicoController")
public class ServicoController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao!=null && acao.equals("listar")){
			
			ServicoBO servicoBO = new ServicoBO();
			List<ServicoDTO> lista = servicoBO.BuscarServicos();
		
			request.setAttribute("lista", lista);
			
			RequestDispatcher saida= request.getRequestDispatcher("Sistemas/Servicos/consultarServicos.jsp");
			saida.forward(request, response);
		}
		
		if(acao!=null && acao.equals("excluir")){
			String id = request.getParameter("id");
			
			ServicoDTO servico = new ServicoDTO();
			servico.setId(Integer.parseInt(id));
			
			ServicoBO servicoBO = new ServicoBO();
			servicoBO.excluirServico(servico);
			
			response.sendRedirect("ServicoController?acao=listar");
		}
		
		if(acao!=null && acao.equals("alterar")){
			String id = request.getParameter("id");
			
			ServicoBO servicoBO = new ServicoBO();
			ServicoDTO servico = servicoBO.buscarServicoPorID(Integer.parseInt(id));
			
			request.setAttribute("servico", servico);
			RequestDispatcher saida = request.getRequestDispatcher("Sistemas/Servicos/alterarServicos.jsp");
			saida.forward(request,response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao!=null && acao.equals("cadastrar")){
			
			String nome = request.getParameter("textNome");
			String descricao = request.getParameter("textDescricao");
			Float valor = Float.parseFloat(request.getParameter("textValor"));
			
			ServicoDTO servico = new ServicoDTO();
			
			servico.setNome(nome);
			servico.setDescricao(descricao);
			servico.setValor(valor);
			
			
			ServicoBO servicoBO = new ServicoBO();
			servicoBO.cadastrarServico(servico);
			
			response.sendRedirect("ServicoController?acao=listar");
		}
		
		if(acao!=null && acao.equals("alterar")){
			
			String nome = request.getParameter("textNome");
			String descricao = request.getParameter("textDescricao");
			Float valor = Float.parseFloat(request.getParameter("textValor"));
			int id = Integer.parseInt(request.getParameter("textId"));
			
			ServicoDTO servico = new ServicoDTO();
			
			servico.setNome(nome);
			servico.setDescricao(descricao);
			servico.setValor(valor);
			servico.setId(id);
			
			
			ServicoBO servicoBO = new ServicoBO();
			servicoBO.alterarServico(servico);
			
			response.sendRedirect("ServicoController?acao=listar");
		}
	}

}
