package br.upis.jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upis.Cliente;
import br.upis.Servico;

public class ServicoDAO {
	ConexaoBanco conexao = new ConexaoBanco();
	Connection con = conexao.getConnection();
	

	public void inserir(Servico servico) {
		// Criar query
		String sql = "INSERT INTO servico(tipo,valor) values(?,?)";
		
		
		
		// Constroi PrepareStatement com sql
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, servico.getTipo());
			pstm.setDouble(2, servico.getValor());
			pstm.execute();
			pstm.close();
			System.out.println("Servico cadastrado com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void alterar(Servico servico) {
		// Criar query
		String sql = "UPDATE servico SET tipo=?,valor=? WHERE id=?";

		// Constroi PrepareStatement com sql
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, servico.getTipo());
			pstm.setDouble(2, servico.getValor());
			pstm.setInt(3,servico.getId());
			pstm.execute();
			pstm.close();
			System.out.println("Servico atualizado com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void excluir(Servico servico) {
		// Criar query
		String sql = "DELETE FROM servico WHERE id=?";

		// Constroi PrepareStatement com sql
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, servico.getId());
			pstm.execute();
			pstm.close();
			System.out.println("Servico excluido com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Servico> buscarTodos() {
		// Criar query
		String sql = "SELECT * FROM servico";
		List<Servico> lista = new ArrayList<Servico>();
		// Constroi PrepareStatement com sql
		try {
			PreparedStatement pstm = con.prepareStatement(sql);

			ResultSet resultado = pstm.executeQuery();

			while (resultado.next()) {
				Servico serv = new Servico();
				serv.setId(resultado.getInt("id"));
				serv.setTipo(resultado.getString("tipo"));
				serv.setValor(resultado.getDouble("valor"));

				lista.add(serv);

			}

			pstm.close();
			System.out.println("Buscar todos registros com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}return lista;

	}

	public Servico buscarPorID(Integer id) {
		// Criar query
		String sql = "SELECT * FROM servico WHERE id=?";
		// Constroi PrepareStatement com sql
		Servico servico = null;
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet resultado = pstm.executeQuery();
			
			if(resultado.next()) { //se foi para o proximo
				servico = new Servico();
				servico.setId(resultado.getInt("id"));
				servico.setTipo(resultado.getString("tipo"));
				servico.setValor(resultado.getDouble("valor"));

	}

			pstm.close();
			System.out.println("Buscar por ID com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}return servico;

	}


}
