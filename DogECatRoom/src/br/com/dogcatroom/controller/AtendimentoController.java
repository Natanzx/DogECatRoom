package br.com.dogcatroom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dogcatroom.bo.AtendimentoBO;
import br.com.dogcatroom.bo.ClienteBO;
import br.com.dogcatroom.bo.ServicoBO;
import br.com.dogcatroom.dto.AtendimentoDTO;
import br.com.dogcatroom.dto.ClienteDTO;
import br.com.dogcatroom.dto.ServicoDTO;



@WebServlet("/AtendimentoController")
public class AtendimentoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		// Recebe os dados da tela
		long idAtendimento = Long.parseLong(rq.getParameter("idAtendimento"));
		String cliente = rq.getParameter("cliente");
		String servico = rq.getParameter("servico");

		AtendimentoBO atendBO = new AtendimentoBO();
		ClienteBO cliBO = new ClienteBO();
		ServicoBO servBO = new ServicoBO();
		
		ServicoDTO servDTO = new ServicoDTO();
		ClienteDTO cliDTO = new ClienteDTO();
		AtendimentoDTO atendDTO = new AtendimentoDTO();

		cliDTO.setNome(cliente);
		
//		cliDTO = cliBO.BuscarCliente(cliDTO);
		servDTO = servBO.BuscarServico(servDTO);
		
		atendDTO.setCliente(cliDTO);
		atendDTO.setServico(servDTO);

		atendBO.RealizarAtendimento(atendDTO);
	}
	
	
}
