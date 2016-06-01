package br.com.dogcatroom.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.dogcatroom.conexao.ConnectionFactory;
import br.com.dogcatroom.dao.IServicoDAO;
import br.com.dogcatroom.dto.ClienteDTO;
import br.com.dogcatroom.dto.ServicoDTO;

public class ServicoDAO implements IServicoDAO {
	private Connection con = ConnectionFactory.getConnection();
	
	public void cadastrar(ServicoDTO servico) {

		String sql = "INSERT INTO servicos (nome, descricao,valor,ativo) values (?,?,?,1)";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, servico.getNome());
			preparador.setString(2, servico.getDescricao());
			preparador.setDouble(3, servico.getValor());

			preparador.execute();
			preparador.close();

			System.out.println("Servico cadastrado com sucesso!");

		} catch (SQLException e) {

			System.out.println("Operação não concluída. ):");

			e.printStackTrace();
		}

	}
	
	public void alterarServico(ServicoDTO servico) {

		String sql = "update servicos set nome=?, descricao=?,valor=?"
				+" where id = ?";

		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, servico.getNome());
			preparador.setString(2, servico.getDescricao());
			preparador.setDouble(3, servico.getValor());
			preparador.setInt(4, servico.getId());

			preparador.execute();
			preparador.close();

			System.out.println("Servico alterado com sucesso!");

		} catch (SQLException e) {

			System.out.println("Operação não concluída. ):");

			e.printStackTrace();
		}

	}
	
	public List<ServicoDTO> buscarTodos() {
		String sql = "SELECT * FROM servicos where ativo = 1";
		List<ServicoDTO> lista = new ArrayList<ServicoDTO>();
		try {
			PreparedStatement pstm = con.prepareStatement(sql);

			ResultSet resultado = pstm.executeQuery();

			while (resultado.next()) {
				ServicoDTO servico = new ServicoDTO();
				
				servico.setId(Integer.parseInt(resultado.getString("id")));
				servico.setNome(resultado.getString("nome"));
				servico.setDescricao(resultado.getString("descricao"));
				servico.setValor(resultado.getFloat("valor"));

				lista.add(servico);

			}
			pstm.close();
			System.out.println("Buscar todos servicos com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}return lista;

	}

	public ServicoDTO buscarPorID(Integer id) {
		String sql = "SELECT * FROM servicos WHERE id=?";
		ServicoDTO servico = null;
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet resultado = pstm.executeQuery();
			
			if(resultado.next()) { 
				servico = new ServicoDTO();
				servico.setNome(resultado.getString("nome"));
				servico.setDescricao(resultado.getString("descricao"));
				servico.setValor(resultado.getFloat("valor"));
				servico.setId(id);
	}

			pstm.close();
			System.out.println("Buscar por ID com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}return servico;

	}
	
	public void excluir(ServicoDTO servico) {
		String sql = "update servicos set ativo = 0 where id = ?";

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
}
