package br.upis.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upis.Usuario;

public class UsuarioDAO {
	ConexaoBanco conexao = new ConexaoBanco();
	Connection con = conexao.getConnection();
		
	public Usuario verificarUsuario(Usuario autenticar){
		String sql = "SELECT * FROM usuario WHERE login=? and senha=?";
		//Usuario autenticarRetorno=null;
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1,autenticar.getLogin());
			pstm.setString(2,autenticar.getSenha());
			ResultSet resultado = pstm.executeQuery();
			
			if(resultado.next()){
				
				//autenticarRetorno = new Usuario();
				autenticar.setId(resultado.getInt("id"));
				autenticar.setNome(resultado.getString("nome"));
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autenticar;
		
	}
	
	public Boolean existeUsuario(Usuario usuario){
		String sql = "SELECT * FROM usuario WHERE login=? and senha=?";
		boolean ret=false;
		try{
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1,usuario.getLogin());
			pstm.setString(2,usuario.getSenha());
			ResultSet resultado = pstm.executeQuery();
			ret= resultado.next();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return ret;
	}

}

