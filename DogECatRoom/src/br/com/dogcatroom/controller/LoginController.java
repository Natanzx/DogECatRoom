package br.com.dogcatroom.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dogcatroom.bo.LoginBO;
import br.com.dogcatroom.dto.LoginDTO;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet{
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		LoginDTO loginDto = new LoginDTO();
		loginDto.setUsuario(login);
		loginDto.setSenha(senha);
		
		LoginBO loginBO = new LoginBO();
		
		LoginDTO retorno = loginBO.autenticarLogin(loginDto);
		/*
		if(retorno.getNome() != null){
			session.setAttribute("usuario", retorno.getNome());
			response.sendRedirect("Inicio.jsp");
			
		}else{
			response.sendRedirect("Logar.jsp");
		}
		*/
		
	}
}
