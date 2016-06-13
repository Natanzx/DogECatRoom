package br.com.dogcatroom.dao;

import br.com.dogcatroom.dto.LoginDTO;

public interface ILoginDAO {
	public LoginDTO validaLogin(LoginDTO login);
}
