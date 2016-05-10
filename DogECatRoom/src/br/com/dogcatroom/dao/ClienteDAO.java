package br.com.dogcatroom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.dogcatroom.conexao.Conexao;
import br.com.dogcatroom.dto.ClienteDTO;


public class ClienteDAO {

	
	private Connection con = Conexao.getConnection();

	public ClienteDTO buscarCliente(ClienteDTO cDTO){	
		return cDTO;
	}
	
	public void cadastrar(ClienteDTO cliente) {

		String sql = "INSERT INTO cliente (nome, cpf,endereco, telefone) values (?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getCpf());
			preparador.setLong(3, cliente.getEndereco().getId());
			preparador.setLong(4, cliente.getTelefone().getId());
			

			preparador.execute();
			preparador.close();

			System.out.println("Parabéns!!! Cadastrado com sucesso!");

		} catch (SQLException e) {

			System.out.println("Operação não concluída. ):");

			e.printStackTrace();
		}

	}

}
