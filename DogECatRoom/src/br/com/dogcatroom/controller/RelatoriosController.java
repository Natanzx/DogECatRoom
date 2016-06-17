package br.com.dogcatroom.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dogcatroom.bo.RelatoriosBO;
import br.com.dogcatroom.dto.RelatoriosDTO;

@WebServlet("/RelatoriosController")
public class RelatoriosController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao!=null && acao.equals("listar")){

			RelatoriosDTO rel = new RelatoriosDTO();
			RelatoriosBO relatoriosBO = new RelatoriosBO();

			relatoriosBO.RelatorioQuantitativoClientes(rel);
			relatoriosBO.RelatorioQuantitativoServicos(rel);
			relatoriosBO.RelatorioQuantitativoFuncionarios(rel);
			relatoriosBO.RelatorioQuantitativoAtendimentos(rel);
			
			request.setAttribute("relatorios", rel);

			RequestDispatcher saida = request.getRequestDispatcher("Sistemas/Relatorios/Relatorios.jsp");
			saida.forward(request, response);
		}	
		
		if(acao!=null && acao.equals("AtendimentosHora")){
			
			RelatoriosBO relatoriosBO = new RelatoriosBO();
			//ResultSet rs = relatoriosBO.RelatorioAtendimentosPorHorario();
			//request.setAttribute("rsAtendimentosHora", rs);


			RequestDispatcher saida = request.getRequestDispatcher("Sistemas/Relatorios/Relatorios.jsp");
			saida.forward(request, response);
		}		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
