package br.com.dogcatroom.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.dogcatroom.conexao.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection c = new ConnectionFactory().getConnection();
		c.close();
	}

}
