package br.com.dogcatroom.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConnection() {

		Connection con = null;

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/dogcatroom", "postgres", "admin");
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {

			System.out.println("N�o pode conectar: " + e.getMessage());

		} catch (ClassNotFoundException e) {
			System.out.println("Driver n�o encontrado");
			e.printStackTrace();
		}

		return con;

	}

}
