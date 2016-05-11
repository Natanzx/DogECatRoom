package br.upis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

	private String driver = "com.mysql.jdbc.Driver";
	private String URL = ("jdbc:mysql://localhost:3306/ltp4");
	private String USER = ("root");
	private String SENHA = ("root");
	private Connection conn = null;

	// Retornar conexao no Banco
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(URL, USER, SENHA);
			System.out.println("Conectado com sucesso no Banco MYSQL");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver não encontrado," + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Falha de loguim no Banco" + e.getMessage());
		}
		return conn;
	}
	//Encerrar conexao do Banco
	public void fecharConexao() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}