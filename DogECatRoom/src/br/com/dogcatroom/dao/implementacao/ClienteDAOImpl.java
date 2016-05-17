package br.com.dogcatroom.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.dogcatroom.conexao.ConnectionFactory;
import br.com.dogcatroom.dao.IClienteDAO;
import br.com.dogcatroom.dto.ClienteDTO;


public class ClienteDAOImpl implements IClienteDAO {

	private Connection con = ConnectionFactory.getConnection();

	public ClienteDTO buscarCliente(ClienteDTO cDTO){	
		return cDTO;
	}
	
	public void cadastrar(ClienteDTO cliente) {

		String sql = "INSERT INTO cliente (nome, cpf,endereco, telefone) values (?,?,?)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getCpf());
			

			preparador.execute();
			preparador.close();

			System.out.println("Parabéns!!! Cadastrado com sucesso!");

		} catch (SQLException e) {

			System.out.println("Operação não concluída. ):");

			e.printStackTrace();
		}

	}

}
