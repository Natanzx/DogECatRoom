package br.com.dogcatroom.bo;

import br.com.dogcatroom.dao.ILoginDAO;
import br.com.dogcatroom.dao.implementacao.LoginDAO;
import br.com.dogcatroom.dto.LoginDTO;

public class LoginBO {
	LoginDAO loginDAO = new LoginDAO();
	ILoginDAO ILoginDAO = loginDAO;
	
	public LoginDTO autenticarLogin(LoginDTO login){
		ILoginDAO.validaLogin(login);
	}
}
