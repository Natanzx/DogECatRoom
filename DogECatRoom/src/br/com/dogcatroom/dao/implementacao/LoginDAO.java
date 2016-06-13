package br.com.dogcatroom.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.dogcatroom.conexao.ConnectionFactory;
import br.com.dogcatroom.dao.ILoginDAO;
import br.com.dogcatroom.dto.LoginDTO;

public class LoginDAO implements ILoginDAO {
	private Connection con = ConnectionFactory.getConnection();
	public LoginDTO validaLogin(LoginDTO login){
		String sql = "SELECT * FROM login WHERE login=? and senha=?";
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1,login.getUsuario());
			pstm.setString(2,login.getSenha());
			ResultSet resultado = pstm.executeQuery();
			
			if(resultado.next()){
				
				//autenticarRetorno = new Usuario();
				login.setId(resultado.getInt("id"));
				login.setFuncionario(funcionario);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return login;
	}
}
