<<<<<<< HEAD
package br.com.dogcatroom.bo;

import br.com.dogcatroom.dao.ILoginDAO;
import br.com.dogcatroom.dao.implementacao.LoginDAO;
import br.com.dogcatroom.dto.LoginDTO;

public class LoginBO {
	LoginDAO loginDAO = new LoginDAO();
	ILoginDAO ILoginDAO = loginDAO;
	
	public LoginDTO autenticarLogin(LoginDTO login){
		return ILoginDAO.validaLogin(login);
	}
}
=======
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
>>>>>>> 616d7353cb5b9074914b4924dbb32085d2dd1a15
