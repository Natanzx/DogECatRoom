package br.com.dogcatroom.dao;

import java.util.List;

import br.com.dogcatroom.dto.ServicoDTO;

public interface IServicoDAO {

	
	public List<ServicoDTO> buscarTodos();
	
	public ServicoDTO buscarPorID(Integer id);
	
}
