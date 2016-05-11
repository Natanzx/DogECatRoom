package br.upis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;

import br.upis.Usuario;
import br.upis.jdbc.UsuarioDAO;


@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		//Captura dados da tela
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		//constroi objeto loguin para consulta
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		//busca no banco de dados
		UsuarioDAO usuarioRetorno = new UsuarioDAO();
		
		Usuario retorno = usuarioRetorno.verificarUsuario(usuario);
		
		if(retorno.getNome() != null){
			session.setAttribute("usuario", retorno.getNome());
			response.sendRedirect("Inicio.jsp");
			
		}else{
			response.sendRedirect("Logar.jsp");
		}
		
	}

}
