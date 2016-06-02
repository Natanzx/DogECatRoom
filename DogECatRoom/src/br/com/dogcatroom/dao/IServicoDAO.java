package br.com.dogcatroom.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.dogcatroom.dto.ServicoDTO;

public interface IServicoDAO {

	
	 List<ServicoDTO> buscarTodosServicos() throws SQLException;
	
	 void cadastrarServico(ServicoDTO servicoDTO) throws SQLException;
	
	void excluirServico(ServicoDTO servicoDTO) throws SQLException;
	
	void alterarServico(ServicoDTO servicoDTO) throws SQLException;
  	
	public ServicoDTO buscarPorID(ServicoDTO servicoDTO) throws SQLException;
	
}
