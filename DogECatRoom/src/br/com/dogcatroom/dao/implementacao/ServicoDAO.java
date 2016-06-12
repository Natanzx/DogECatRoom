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

	@Override
	public void cadastrarServico(ServicoDTO servico) throws SQLException {

		String sql = "INSERT INTO servicos (nome, descricao,valor,ativo) values (?,?,?,?)";

		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setString(1, servico.getNome());
		preparador.setString(2, servico.getDescricao());
		preparador.setDouble(3, servico.getValor());
		preparador.setBoolean(4, servico.isAtivo());

		preparador.execute();
		preparador.close();

	}

	@Override
	public void alterarServico(ServicoDTO servico) throws SQLException {

		String sql = "update servicos set nome=?, descricao=?,valor=?" + " where idCliente = ?";

		PreparedStatement preparador = con.prepareStatement(sql);
		preparador.setString(1, servico.getNome());
		preparador.setString(2, servico.getDescricao());
		preparador.setDouble(3, servico.getValor());
		//preparador.setBoolean(4, servico.isAtivo());
		preparador.setInt(4, servico.getId());

		preparador.execute();
		preparador.close();

	}

	@Override
	public List<ServicoDTO> buscarTodosServicos() throws SQLException {
		String sql = "SELECT * FROM servicos where ativo = 1";
		List<ServicoDTO> lista = new ArrayList<ServicoDTO>();

		PreparedStatement pstm = con.prepareStatement(sql);

		ResultSet resultado = pstm.executeQuery();

		while (resultado.next()) {
			ServicoDTO servico = new ServicoDTO();

			servico.setId(Integer.parseInt(resultado.getString("id")));
			servico.setNome(resultado.getString("nome"));
			servico.setDescricao(resultado.getString("descricao"));
			servico.setValor(resultado.getFloat("valor"));
			servico.setAtivo(Boolean.parseBoolean(resultado.getString("ativo")));

			lista.add(servico);

		}
		pstm.close();

		return lista;

	}

	public ServicoDTO buscarPorID(ServicoDTO servicoDTO) throws SQLException {
		String sql = "SELECT * FROM servicos WHERE id = ?";
		ServicoDTO servico = null;

		PreparedStatement pstm = con.prepareStatement(sql);
		pstm.setInt(1, servicoDTO.getId());
		ResultSet resultado = pstm.executeQuery();

		if (resultado.next()) {
			servico = new ServicoDTO();
			servico.setNome(resultado.getString("nome"));
			servico.setDescricao(resultado.getString("descricao"));
			servico.setValor(resultado.getFloat("valor"));
			servico.setAtivo(Boolean.parseBoolean(resultado.getString("ativo")));
			servico.setId(resultado.getInt("id"));
		}

		pstm.close();
		return servico;

	}

	@Override
	public void excluirServico(ServicoDTO servico) throws SQLException {
		String sql = "update servicos set ativo = 0 where idCliente = ?";

			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, servico.getId());
			pstm.execute();
			pstm.close();

	}
}
