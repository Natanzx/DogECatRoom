package br.com.dogcatroom.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dogcatroom.Exception.BusinesException;
import br.com.dogcatroom.bo.ClienteBO;
import br.com.dogcatroom.bo.ServicoBO;
import br.com.dogcatroom.dto.ClienteDTO;
import br.com.dogcatroom.dto.ServicoDTO;

@WebServlet("/ServicoController")
public class ServicoController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		if (acao != null && acao.equals("listar")) {

			ServicoBO servicoBO = new ServicoBO();
			try {
				List<ServicoDTO> lista = servicoBO.BuscarServicos();
				request.setAttribute("lista", lista);
				RequestDispatcher saida = request.getRequestDispatcher("Sistemas/Servicos/consultarServicos.jsp");
				saida.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		if (acao != null && acao.equals("excluir")) {
			String id = request.getParameter("id");

			ServicoDTO servico = new ServicoDTO();
			servico.setId(Integer.parseInt(id));

			ServicoBO servicoBO = new ServicoBO();
			try {
				servicoBO.excluirServico(servico);
				response.sendRedirect("ServicoController?acao=listar");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		if (acao != null && acao.equals("alterar")) {
			String id = request.getParameter("id");

			ServicoBO servicoBO = new ServicoBO();
			ServicoDTO servicoDTO = new ServicoDTO();
			servicoDTO.setId(Integer.parseInt(id));
			
			try {
				servicoDTO = servicoBO.buscarServicoPorID(servicoDTO.getId());
				request.setAttribute("servico", servicoDTO);
				RequestDispatcher saida = request.getRequestDispatcher("Sistemas/Servicos/alterarServicos.jsp");
				saida.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}


		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		if (acao != null && acao.equals("salvar")) {

			String nome = request.getParameter("textNome");
			String descricao = request.getParameter("textDescricao");
			Float valor = Float.parseFloat(request.getParameter("textValor"));

			ServicoDTO servico = new ServicoDTO();

			servico.setNome(nome);
			servico.setDescricao(descricao);
			servico.setValor(valor);
			servico.setAtivo(true);

			ServicoBO servicoBO = new ServicoBO();
			try {
				if (servico.getId() != null) {
					servicoBO.salvarServico(servico);
				}
				servicoBO.salvarServico(servico);
				response.sendRedirect("ServicoController?acao=listar");
			} catch (BusinesException | SQLException e) {
				e.printStackTrace();
			}

		}

		if (acao != null && acao.equals("alterar")) {

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
			try{
			servicoBO.salvarServico(servico);
			}catch(BusinesException | SQLException e){
				e.printStackTrace();
			}

			response.sendRedirect("ServicoController?acao=listar");
		}
	}

}
