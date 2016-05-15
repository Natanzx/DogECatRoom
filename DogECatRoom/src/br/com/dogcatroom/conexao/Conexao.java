package br.com.dogcatroom.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static String n ="teste";
	public static Connection getConnection() {
		
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dogCatRoom", "root", "root");
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {

			System.out.println("Não pode conectar: " + e.getMessage());

		} catch (ClassNotFoundException e) {
			System.out.println("Driver não encontrado");
			e.printStackTrace();
		}
		
		return con;

	}

}
