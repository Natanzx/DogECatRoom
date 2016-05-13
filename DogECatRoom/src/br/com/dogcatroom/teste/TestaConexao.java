package br.com.dogcatroom.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.dogcatroom.conexao.Conexao;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection c = new Conexao().getConnection();
		c.close();
	}

}
