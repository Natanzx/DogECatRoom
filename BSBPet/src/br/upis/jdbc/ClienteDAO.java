package br.upis.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.upis.Cliente;

public class ClienteDAO {
	ConexaoBanco conexao = new ConexaoBanco();
	Connection con = conexao.getConnection();
	

	public void inserir(Cliente cliente) {
		// Criar query
		String sql = "INSERT INTO cliente(nome,telefone,cpf,endereco,animal) values(?,?,?,?,?)";
		
		// Constroi PrepareStatement com sql
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setInt(2, cliente.getTelefone());
			pstm.setString(3, cliente.getCpf());
			pstm.setString(4, cliente.getEndereco());
			pstm.setString(5, cliente.getAnimal());
			pstm.execute();
			pstm.close();
			System.out.println("Registro cadastrado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void alterar(Cliente cliente) {
		// Criar query
		String sql = "UPDATE cliente SET nome=?,telefone=?,cpf=?,endereco=?,animal=? WHERE id=?";

		// Constroi PrepareStatement com sql
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setInt(2, cliente.getTelefone());
			pstm.setString(3, cliente.getCpf());
			pstm.setString(4, cliente.getEndereco());
			pstm.setString(5, cliente.getAnimal());
			pstm.setInt(6, cliente.getId());
			pstm.execute();
			pstm.close();
			System.out.println("Registro atualizado com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void excluir(Cliente cliente) {
		// Criar query
		String sql = "DELETE FROM cliente WHERE id=?";

		// Constroi PrepareStatement com sql
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, cliente.getId());
			pstm.execute();
			pstm.close();
			System.out.println("Registro excluido com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Cliente> buscarTodos() {
		// Criar query
		String sql = "SELECT * FROM cliente";
		List<Cliente> lista = new ArrayList<Cliente>();
		// Constroi PrepareStatement com sql
		try {
			PreparedStatement pstm = con.prepareStatement(sql);

			ResultSet resultado = pstm.executeQuery();

			while (resultado.next()) {
				Cliente cli = new Cliente();
				cli.setId(resultado.getInt("id"));
				cli.setNome(resultado.getString("nome"));
				cli.setTelefone(resultado.getInt("telefone"));
				cli.setCpf(resultado.getString("cpf"));
				cli.setEndereco(resultado.getString("endereco"));
				cli.setAnimal(resultado.getString("animal"));

				lista.add(cli);

			}

			pstm.close();
			System.out.println("Buscar todos registros com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}return lista;

	}

	public Cliente buscarPorID(Integer id) {
		// Criar query
		String sql = "SELECT * FROM cliente WHERE id=?";
		// Constroi PrepareStatement com sql
		Cliente cliente = null;
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet resultado = pstm.executeQuery();
			
			if(resultado.next()) { //se foi para o proximo
				cliente = new Cliente();
				cliente.setId(resultado.getInt("id"));
				cliente.setNome(resultado.getString("nome"));
				cliente.setTelefone(resultado.getInt("telefone"));
				cliente.setCpf(resultado.getString("cpf"));
				cliente.setEndereco(resultado.getString("endereco"));
				cliente.setAnimal(resultado.getString("animal"));
	}

			pstm.close();
			System.out.println("Buscar por ID com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}return cliente;

	}


}
